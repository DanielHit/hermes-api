package com.qiezi.hermes.api.job;

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
	static String detailUrl = "http://3g.ganji.com/bj_zpjiudiancanyin/2134103252x";
	@Resource
	private GanjiIdRepo ganjiIdRepo;

	@PostConstruct
	public void init() {
		startPull();
	}

	public void startPull() {

		for (int i = 0; i < 2000; i++) {
			try {
				Document document = Jsoup.connect(list + i).userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36").get();
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
