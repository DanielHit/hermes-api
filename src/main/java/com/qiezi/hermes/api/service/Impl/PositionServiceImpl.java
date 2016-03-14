package com.qiezi.hermes.api.service.Impl;

import com.qiezi.hermes.api.dao.IApplicationDAO;
import com.qiezi.hermes.api.dao.IJobDescDAO;
import com.qiezi.hermes.api.domain.JobDescDO;
import com.qiezi.hermes.api.model.PostJobModel;
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

    @Override
    public List<PostJobModel> getPostJobList(int postUserId) {
        List<JobDescDO> jobDescDOs = jobDescDAO.getJobListByPostUserId(postUserId);
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
}
