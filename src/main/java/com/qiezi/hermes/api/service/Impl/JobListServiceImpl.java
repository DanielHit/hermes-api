package com.qiezi.hermes.api.service.Impl;

import com.qiezi.hermes.api.dao.IJobDescDAO;
import com.qiezi.hermes.api.domain.JobDescDO;
import com.qiezi.hermes.api.enums.SalaryEnum;
import com.qiezi.hermes.api.model.JobListModel;
import com.qiezi.hermes.api.model.JobTitleModel;
import com.qiezi.hermes.api.param.JobListSelectRequestParam;
import com.qiezi.hermes.api.service.IJobListService;
import com.qiezi.hermes.api.utils.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Daniel on 3/6/16.
 */
@Service("jobListService")
public class JobListServiceImpl implements IJobListService {

    @Autowired
    private IJobDescDAO jobDescDAO;

    @Override
    public JobListModel getJobListBySelect(JobListSelectRequestParam selectRequestParam) {

        JobListModel resultModel = new JobListModel();
        List<JobTitleModel> jobTitleList = new ArrayList<>();

        // 最简化的第一版本
        List<JobDescDO> jobList = jobDescDAO.getJobDescListBySelectParam(selectRequestParam.getCityId(), selectRequestParam.getAreaId(), selectRequestParam.getCateId(), selectRequestParam.getExperience(), selectRequestParam.getDegree(), selectRequestParam.getSalary(), DateFormatUtils.formatDateByDays(selectRequestParam.getDays()));

        if (selectRequestParam.getOffset() > jobList.size()) {
            return new JobListModel();  //如果offset > 总的,返回为空
        }

        if (selectRequestParam.getSortType() == "salaryDown") {
            Collections.sort(jobList, new Comparator<JobDescDO>() {
                @Override
                public int compare(JobDescDO o1, JobDescDO o2) {
                    return o1.getSalary() - o2.getSalary();
                }
            });

        } else if (selectRequestParam.getSortType() == "postTimeNew") {
            Collections.sort(jobList, new Comparator<JobDescDO>() {
                @Override
                public int compare(JobDescDO o1, JobDescDO o2) {
                    return (int) (o1.getPostTime().getTime() - o2.getPostTime().getTime());
                }
            });

        }

        // 获取offset 和 limit 之间的排序结果
        for (int i = selectRequestParam.getOffset(); i < jobList.size(); i++) {
            JobDescDO jobDescDO = jobList.get(i);
            JobTitleModel jobTitleModel = new JobTitleModel();
            jobTitleModel.setJobId(jobDescDO.getId());
            jobTitleModel.setJobName(jobDescDO.getJobName());
            jobTitleModel.setAddress(jobDescDO.getAddress());
            jobTitleModel.setImgUrl(jobDescDO.getImgUrl());
            jobTitleModel.setMaxSalary(SalaryEnum.FirstLevelSalary.getMaxSalary());
            jobTitleModel.setMinSalary(SalaryEnum.SecondLevelSalary.getMinSalary());
            jobTitleModel.setPostTime(jobDescDO.getPostTime().toString());
            jobTitleModel.setWelfare(jobDescDO.getWelfare());

            jobTitleList.add(jobTitleModel);
            if (i - selectRequestParam.getOffset() >= selectRequestParam.getLimit()) {
                break;
            }
        }

        // 增加返回的列表
        resultModel.setJobList(jobTitleList);
        resultModel.setSize(jobTitleList.size());
        return resultModel;
    }


}
