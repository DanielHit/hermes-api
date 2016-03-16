package com.qiezi.hermes.api.service.Impl;

import com.qiezi.hermes.api.dao.IApplicationDAO;
import com.qiezi.hermes.api.dao.IJobDescDAO;
import com.qiezi.hermes.api.dao.IResumeDAO;
import com.qiezi.hermes.api.dao.IUserDAO;
import com.qiezi.hermes.api.domain.ApplicationDO;
import com.qiezi.hermes.api.domain.JobDescDO;
import com.qiezi.hermes.api.model.PostJobModel;
import com.qiezi.hermes.api.model.PostResumeModel;
import com.qiezi.hermes.api.service.IPositionService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IJobDescDAO jobDescDAO;
    @Autowired
    private IApplicationDAO applicationDAO;
    @Autowired
    private IResumeDAO resumeDAO;
    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<PostJobModel> getPostJobList(int postUserId, int stage) {
        List<JobDescDO> jobDescDOs = jobDescDAO.getJobListByPostUserId(postUserId,stage);

        if (CollectionUtils.isEmpty(jobDescDOs)) {
            return Collections.EMPTY_LIST;
        }

        List<PostJobModel> postJobModels = new ArrayList<>();
        for (JobDescDO jobDescDO : jobDescDOs) {
            PostJobModel postJobModel = new PostJobModel();
            postJobModel.setJobId(jobDescDO.getId());
            postJobModel.setJobName(jobDescDO.getJobName());
            postJobModel.setEditDate(jobDescDO.getPostTime().toString());
            postJobModel.setApplicationNum(applicationDAO.getApplicatioNumByJobId(jobDescDO.getId()));
            postJobModels.add(postJobModel);
        }

        return postJobModels;
    }

    @Override
    public List<PostResumeModel> getPostResumeList(int postUserId, int jobId) {
        List<ApplicationDO> applicationDOs;
        if (jobId == 0) {
            applicationDOs = applicationDAO.getApplicationListByPostUserId(postUserId);
            if (CollectionUtils.isEmpty(applicationDOs)) {
                return Collections.EMPTY_LIST;
            }
        } else {
            applicationDOs = applicationDAO.getApplicationListByJobId(jobId);
            if (CollectionUtils.isEmpty(applicationDOs)) {
                return Collections.EMPTY_LIST;
            }
        }

        List<PostResumeModel> postResumeModelList = new ArrayList<>();
        for (ApplicationDO applicationDO : applicationDOs) {
            PostResumeModel postResumeModel = new PostResumeModel();
            postResumeModel.setDate(applicationDO.getDate());
            postResumeModel.setJobId(applicationDO.getJobId());
            postResumeModel.setUserId(applicationDO.getUserId());
            postResumeModel.setTelephone(userDAO.getUserInfoById(applicationDO.getUserId()).getPhoneNum());
            postResumeModel.setCandidateName(userDAO.getUserInfoById(applicationDO.getUserId()).getName());   // 求职者名称 -> 求职者的名称
            postResumeModel.setResumeId(resumeDAO.getResumeByUserId(applicationDO.getUserId()).getId());
            postResumeModel.setJobName(jobDescDAO.getJobDescByJobId(applicationDO.getJobId()).getJobName());
            postResumeModelList.add(postResumeModel);
        }
        return postResumeModelList;
    }
}







