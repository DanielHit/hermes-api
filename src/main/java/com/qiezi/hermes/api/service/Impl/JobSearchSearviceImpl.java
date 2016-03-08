package com.qiezi.hermes.api.service.Impl;

import com.google.common.collect.Lists;
import com.qiezi.hermes.api.dao.IJobDescDAO;
import com.qiezi.hermes.api.domain.JobDescDO;
import com.qiezi.hermes.api.model.JobESModel;
import com.qiezi.hermes.api.param.JobListSelectRequestParam;
import com.qiezi.hermes.api.result.JobSearchResult;
import com.qiezi.hermes.api.service.IJobESRepository;
import com.qiezi.hermes.api.service.IJobSearchService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.util.Strings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-07
 */
@Service
public class JobSearchSearviceImpl implements IJobSearchService {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobSearchSearviceImpl.class);

	@Resource
	private IJobESRepository jobESRepository;
	@Resource
	private IJobDescDAO jobDescDAO;
	@Resource
	private ElasticsearchTemplate elasticsearchTemplate;

	private ExecutorService executorService;

	@PostConstruct
	private void init() {
		executorService = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(1024));
	}

	@PreDestroy
	private void destroy() {
		executorService.shutdown();
	}

	@Scheduled(cron = "0/10 * * * * *")
	public void batchIndex() {
		int total = jobDescDAO.countJob();
		int batchSize = 100;
		int current = 0;
		int offset = batchSize;
		while (current < total) {
			final List<JobDescDO> jobDescList = jobDescDAO.getJobDescList(current, batchSize);
			if (CollectionUtils.isEmpty(jobDescList)) {
				continue;
			}
			current += batchSize;
			offset += batchSize;
			if (offset > total) {
				offset = total;
			}
			final List<JobESModel> jobESModels = transformESModelFromDO(jobDescList);
			executorService.submit(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					return JobSearchSearviceImpl.this.index(jobESModels);
				}
			});
		}

	}

	private List<JobESModel> transformESModelFromDO(List<JobDescDO> jobDescList) {
		if (CollectionUtils.isEmpty(jobDescList)) {
			return Lists.newArrayList();
		}
		List<JobESModel> jobESModels = Lists.newArrayList();
		// FIXME 先用一部分
		for (JobDescDO jobDescDO : jobDescList) {
			JobESModel jobESModel = new JobESModel();
			jobESModel.setJobId(jobDescDO.getId());
			jobESModel.setCityId(jobDescDO.getCityId());
			jobESModel.setCateId(jobDescDO.getJobType());  // TODO cate id 详情
			jobESModel.setJobType(jobDescDO.getJobType());
			jobESModel.setCateId(jobDescDO.getAreaId());
			jobESModel.setJobAddress(jobDescDO.getAddress());
			jobESModel.setMinSalary(jobDescDO.getSalary());
			jobESModel.setMaxSalary(jobDescDO.getSalary());
			jobESModel.setJobName(jobDescDO.getJobName());
			jobESModel.setAreaId(jobDescDO.getAreaId());
			jobESModel.setDegree(jobDescDO.getDegree());
			jobESModel.setExperience(jobDescDO.getExperience());
			jobESModel.setJobContent(jobDescDO.getJobContent());
			Date postTime = jobDescDO.getPostTime();
			if (postTime != null) {
				jobESModel.setCreateTimeMillis(jobDescDO.getPostTime().getTime());
			} else {
				jobESModel.setCreateTimeMillis(0); // todo 没有时间, 不应该发生
			}
			jobESModels.add(jobESModel);
		}
		return jobESModels;
	}

	@Override
	public List<JobESModel> jobESModels(String searchKey) {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		if (Strings.isNotEmpty(searchKey)) {
			MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(searchKey, "jobName", "jobContent", "company");
			BoolQueryBuilder keyQueryBuilder = QueryBuilders.boolQuery();
			keyQueryBuilder.should(multiMatchQueryBuilder);
			boolQueryBuilder.must(keyQueryBuilder);
		}
		return elasticsearchTemplate.queryForList(new NativeSearchQuery(boolQueryBuilder), JobESModel.class);
	}

	@Override
	public JobSearchResult getJobListBySelect(JobListSelectRequestParam selectRequestParam) {
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		int cityId = selectRequestParam.getCityId();
		if (cityId != 0) {
			MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("cityId", cityId);
			boolQueryBuilder.must(matchQueryBuilder);
		}
		int areaId = selectRequestParam.getAreaId();
		if (areaId != 0) {
			MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("areaId", areaId);
			boolQueryBuilder.must(matchQueryBuilder);
		}
		int cateId = selectRequestParam.getCateId();
		if (cateId != 0) {
			MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("cateId", cateId);
			boolQueryBuilder.must(matchQueryBuilder);
		}
		int jobType = selectRequestParam.getJobType();
		if (jobType != 0) {
			MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("jobType", jobType);
			boolQueryBuilder.must(matchQueryBuilder);
		}
		int degree = selectRequestParam.getDegree();
		if (degree != 0) {
			MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("degree", degree);
			boolQueryBuilder.must(matchQueryBuilder);
		}
		int experience = selectRequestParam.getExperience();
		if (experience != 0) {
			MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("experience", experience);
			boolQueryBuilder.must(matchQueryBuilder);
		}

		int salaryMinReq = selectRequestParam.getSalaryMin();
		if (salaryMinReq != 0) {
			RangeQueryBuilder salaryMaxBuilder = QueryBuilders.rangeQuery("salaryMax").from(salaryMinReq);
			boolQueryBuilder.must(salaryMaxBuilder);
		}
		int salaryMaxReq = selectRequestParam.getSalaryMax();
		if (salaryMaxReq != 0) {
			RangeQueryBuilder salaryMinBuilder = QueryBuilders.rangeQuery("salaryMin").to(salaryMaxReq);
			boolQueryBuilder.must(salaryMinBuilder);
		}
		int days = selectRequestParam.getDays();
		if (days != 0) {
			DateTime dateTime = DateTime.now();
			DateTime fromTime = dateTime.minusDays(days);
			long fromMillis = fromTime.getMillis();
			RangeQueryBuilder timeRange = QueryBuilders.rangeQuery("createTimeMillis").from(fromMillis);
			boolQueryBuilder.must(timeRange);
		}
		// 关键词搜索
		String searchKey = selectRequestParam.getKeyWord();
		if (Strings.isNotEmpty(searchKey)) {
			MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(searchKey, "jobName", "company");
			BoolQueryBuilder keyQueryBuilder = QueryBuilders.boolQuery();
			keyQueryBuilder.should(multiMatchQueryBuilder);
			boolQueryBuilder.must(keyQueryBuilder);
		}
		String sortType = selectRequestParam.getSortType();
		SortBuilder fieldSortBuilder = SortBuilders.fieldSort("createTimeMillis").order(SortOrder.DESC);
		if ("default".equals(sortType)) {
			// 默认按照发布时间降序
			fieldSortBuilder = SortBuilders.fieldSort("createTimeMillis").order(SortOrder.DESC);
		} else if ("salaryUp".equals(sortType)) {
			fieldSortBuilder = SortBuilders.fieldSort("salaryMax").order(SortOrder.ASC);
		} else if ("salaryDown".equals(sortType)) {
			fieldSortBuilder = SortBuilders.fieldSort("salaryMax").order(SortOrder.DESC);
		} else if ("postTimeUp".equals(sortType)) {
			fieldSortBuilder = SortBuilders.fieldSort("createTimeMillis").order(SortOrder.ASC);
		} else if ("postTimeDown".equals(sortType)) {
			fieldSortBuilder = SortBuilders.fieldSort("createTimeMillis").order(SortOrder.DESC);
		}
		NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(boolQueryBuilder, null, Collections.singletonList(fieldSortBuilder));
		int offset = selectRequestParam.getOffset();
		int limit = selectRequestParam.getLimit();
		if (limit > 100) {
			limit = 100;
		}
		int page = offset / limit;
		Pageable pageable = new PageRequest(page, limit);
		nativeSearchQuery.setPageable(pageable);
		Page<JobESModel> jobESModelPage = elasticsearchTemplate.queryForPage(nativeSearchQuery, JobESModel.class);
		return transform(jobESModelPage);
	}

	private JobSearchResult transform(Page<JobESModel> page) {
		if (page != null) {
			JobSearchResult jobSearchResult = new JobSearchResult();
			long totalElements = page.getTotalElements();
			jobSearchResult.setTotal((int) totalElements);
			List<Integer> idList = Lists.newArrayList();
			List<JobESModel> content = page.getContent();
			if (CollectionUtils.isNotEmpty(content)) {
				for (JobESModel jobESModel : content) {
					idList.add(jobESModel.getJobId());
				}
			}
			return jobSearchResult;
		} else {
			return new JobSearchResult();
		}
	}

	@Override
	public boolean index(List<JobESModel> jobESModel) {
		jobESRepository.save(jobESModel);
		return true;
	}
}
