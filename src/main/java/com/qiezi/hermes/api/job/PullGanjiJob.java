package com.qiezi.hermes.api.job;

import com.google.common.base.Splitter;
import com.qiezi.hermes.api.dao.IJobDescDAO;
import okhttp3.OkHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-09
 */
@Service
public class PullGanjiJob {
	OkHttpClient okHttpClient = new OkHttpClient();
	static String list = "http://3g.ganji.com/bj_zpjudianfuwuyuan/?url=zpjudianfuwuyuan&page=";
	static String detailUrl = "http://3g.ganji.com/bj_zpjiudiancanyin/";
	static String userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36";
	static String cookieValue = "ganji_uuid=6251779932673981034298;citydomain=bj;ganji_xuuid=775be2c4-0022-4967-af65-c042ea2c8ed7.1442928184503;lg=1;__utma=32156897.1205104231.1457169143.1457169143.1457527981.2;cityDomain=bj; mobversionbeta=3g; __utmganji_v20110909=0x878ef3712912de2617116785f80d9a2; index_city_domain=bj; index_city_name=%E5%8C%97%E4%BA%AC%E5%B8%82; wantedFindjobBrowseHistoryId=%5B%224_106547%22%5D; wap_banner_list=off; footer_float=off; GANJISESSID=30868b87f4076c99f59400b923b8f675";
	static Map<String, String> cookieKV = Splitter.on(";").withKeyValueSeparator("=").split(cookieValue);
	@Resource
	private GanjiIdRepo ganjiIdRepo;
	@Resource
	private GanjiRepo ganjiRepo;
	@Resource
	private IJobDescDAO jobDescDAO;

	@PostConstruct
	public void init() {
		Executors.newSingleThreadExecutor().submit(new Runnable() {
			@Override
			public void run() {
				pullDetail();
			}
		});
	}

	@Scheduled(cron = "0 0 0/2 * * ?")
	public void startPull() {
		Random random = new Random();
		for (int i = 0; i < 2000; i++) {
			try {
				Document document = Jsoup.connect(list + i).cookies(cookieKV).userAgent(userAgent).get();
				Elements select = document.select("label[data-role=label]");
				int size = select.size();
				for (int j = 0; j < size; j++) {
					Element element = select.get(j);
					String attr = element.attr("data-puid");
					System.out.println(attr);
					try {
						ganjiIdRepo.saveAndFlush(new GanjiId(Integer.parseInt(attr)));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Thread.sleep(random.nextInt(2000));
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		pullDetail();
	}

	public void sync() {
		List<GanjiJob> ganjiJobs = ganjiRepo.findAll();
		for (GanjiJob ganjiJob : ganjiJobs) {
			jobDescDAO.addNewJobDesc(1, 123, 10001, ganjiJob.getTitle(), 0, 0, "", 0, 0, 0, 0, "", ganjiJob.getAddress(), 0, 0, 0, "", ganjiJob.getCompanyDetail(), "");
		}
	}

	@Scheduled(cron = "0 30 0/1 * * ?")
	public void pullDetail() {
		Pattern timePattern = Pattern.compile("\\d{2}-\\d{2} \\d{2}:\\d{2}");
		List<GanjiId> all = ganjiIdRepo.findAll();
		for (GanjiId ganjiId : all) {
			Random random = new Random();
			try {
				int id = ganjiId.getGanjiId();
				String url = detailUrl + id + "x";
				System.out.println("get detail " + id);
				try {
					Document document = Jsoup.connect(url).cookies(cookieKV).userAgent(userAgent).get();
					document.select("#detail_info");
					String title = document.select("#detail_info h1.title").text();
					String salary = document.select("#detail_info .fc-red").text();
					String address = document.select("#detail_info .table tr").get(2).select("td").text();
					String detail = document.select("#detail_info .comm-desp").text();
					String modTime = document.select("#detail_info .fc8d f12").text();

					Matcher matcher = timePattern.matcher(modTime);
					boolean b = matcher.find();
					Date mod = new Date();
					if (b) {
						String group = matcher.group();
						SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
						mod = sdf.parse(group);
					}
					GanjiJob ganjiJob = new GanjiJob();
					ganjiJob.setCityId(1);
					ganjiJob.setJobId(String.valueOf(id));
					ganjiJob.setSalary(salary);
					ganjiJob.setTitle(title);
					ganjiJob.setCompanyDetail(detail);
					ganjiJob.setAddress(address);
					ganjiJob.setModTime(mod);
					ganjiRepo.saveAndFlush(ganjiJob);
					Thread.sleep(random.nextInt(2000));
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
