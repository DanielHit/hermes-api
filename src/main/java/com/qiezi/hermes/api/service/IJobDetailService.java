package com.qiezi.hermes.api.service;

import com.qiezi.hermes.api.exception.HasApplyForJobException;
import com.qiezi.hermes.api.model.JobDescModel;

/**
 * Created by Daniel on 3/7/16.
 */
public interface IJobDetailService {

    public JobDescModel getJobDescById(int jobId);

    public int applyJobById(int jobId, int userId) throws HasApplyForJobException;
}
