package com.qiezi.hermes.api.service.Impl;

import com.qiezi.hermes.api.dao.IApplicationDAO;
import com.qiezi.hermes.api.dao.IJobDescDAO;
import com.qiezi.hermes.api.domain.JobDescDO;
import com.qiezi.hermes.api.exception.HasApplyForJobException;
import com.qiezi.hermes.api.model.JobDescModel;
import com.qiezi.hermes.api.service.IJobDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jobDetailService")
public class JobDetailServiceImpl implements IJobDetailService {

    @Autowired
    private IJobDescDAO jobDescDAO;

    @Autowired
    private IApplicationDAO applicationDAO;

    @Override
    public JobDescModel getJobDescById(int jobId) {
        JobDescDO jobDescDO = jobDescDAO.getJobDescByJobId(jobId);
        if (jobDescDO != null) {
            JobDescModel jobDescModel = new JobDescModel(jobDescDO);
            return jobDescModel;
        }
        return null;
    }

    @Override
    public int applyJobById(int jobId, int userId) throws HasApplyForJobException {
        if (applicationDAO.getApplicationByUserIdAndJobId(userId, jobId) != null) {
            throw new HasApplyForJobException("has already apply for the job");   // 已经申请过
        } else {
            return applicationDAO.addApplication(userId, jobId);
        }
    }
}
