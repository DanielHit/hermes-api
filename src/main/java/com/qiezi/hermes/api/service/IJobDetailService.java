package com.qiezi.hermes.api.service;

import com.qiezi.hermes.api.model.JobDescModel;

/**
 * Created by Daniel on 3/7/16.
 */
public interface IJobDetailService {
    public JobDescModel getJobDescById(int jobId);
}
