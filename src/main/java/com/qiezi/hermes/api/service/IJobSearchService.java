package com.qiezi.hermes.api.service;

import com.qiezi.hermes.api.model.JobESModel;
import com.qiezi.hermes.api.param.JobListSelectRequestParam;
import com.qiezi.hermes.api.result.JobSearchResult;

import java.util.List;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-07
 */
public interface IJobSearchService {
	List<JobESModel> jobESModels(String searchKey);

	JobSearchResult getJobListBySelect(JobListSelectRequestParam selectRequestParam);

	boolean index(List<JobESModel> jobESModel);
}
