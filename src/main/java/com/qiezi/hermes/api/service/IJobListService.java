package com.qiezi.hermes.api.service;

import com.qiezi.hermes.api.model.JobListModel;
import com.qiezi.hermes.api.param.JobListSelectRequestParam;

/**
 * Created by Daniel on 3/6/16.
 */
public interface IJobListService {

    public JobListModel getJobListBySelect(JobListSelectRequestParam selectRequestParam);

}
