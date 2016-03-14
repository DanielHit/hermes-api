package com.qiezi.hermes.api.service.Impl;

import com.qiezi.hermes.api.dao.IApplicationDAO;
import com.qiezi.hermes.api.dao.IJobDescDAO;
import com.qiezi.hermes.api.domain.ApplicationDO;
import com.qiezi.hermes.api.model.ApplicationModel;
import com.qiezi.hermes.api.service.IApplicationService;
import com.qiezi.hermes.api.utils.DateFormatUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements IApplicationService {

    @Autowired
    private IApplicationDAO applicationDAO;

    @Autowired
    private IJobDescDAO jobDescDAO;

    public List<ApplicationModel> getApplicationByUserId(int userId) {

        List<ApplicationDO> applicationDOs = applicationDAO.getApplicationByUserId(userId);
        if (CollectionUtils.isEmpty(applicationDOs)) {
            return Collections.EMPTY_LIST;
        }

        List<ApplicationModel> applicationModelList = new ArrayList<>();
        for (ApplicationDO applicationDO : applicationDOs) {
            ApplicationModel model = new ApplicationModel();
            model.setId(applicationDO.getId());
            model.setJobName(jobDescDAO.getJobDescByJobId(applicationDO.getId()).getJobName());
            model.setStage(String.valueOf(applicationDO.getStage()));
            model.setHireManager(jobDescDAO.getJobDescByJobId(applicationDO.getJobId()).getEmployerName());
            try {
                long days = DateFormatUtils.getIntervalDays(applicationDO.getDate());
                model.setDays((int) days);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            applicationModelList.add(model);
        }

        return applicationModelList;
    }
}
