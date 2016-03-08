package com.qiezi.hermes.api.controller;

import com.qiezi.hermes.api.exception.WrongParamException;
import com.qiezi.hermes.api.model.JobListModel;
import com.qiezi.hermes.api.param.JobListSelectRequestParam;
import com.qiezi.hermes.api.service.IJobListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.*;

@RestController
@RequestMapping("/api/jobList/")
public class ListController {

    public static final Logger logger = LoggerFactory.getLogger(ListController.class);

    @Autowired
    private IJobListService jobListService;

    @RequestMapping("/getJobList")
    public Map<String, Object> getJobList(@RequestParam("cityId") int cityId, @RequestParam("areaId") int areaId, @RequestParam("cateId") int cateId, @RequestParam("salary") int salary,
                                          @RequestParam("postDays") int days, @RequestParam("jobType") int jobType,
                                          @RequestParam("sortType") String sortType, @RequestParam( required = true, defaultValue = "0") int offset, @RequestParam(required = true, defaultValue = "15") int limit,
                                          @RequestParam("experience") int experience, @RequestParam("degree") int degree) {

        Map<String, Object> resultMap = new HashMap<>();
        JobListSelectRequestParam selectRequestParam = null;
        try {
            selectRequestParam = buildSelectParam(cityId, areaId, cateId, days, jobType, sortType, salary, offset, limit, experience, degree);
        } catch (WrongParamException e) {
            logger.info("getJobList param error {} ", e);
            resultMap.put("status", 500);
            resultMap.put("message", e.getMessage());
        }

        try {
            JobListModel jobList = jobListService.getJobListBySelect(selectRequestParam);
            resultMap.put("data", jobList);
            resultMap.put("status", 200);
            resultMap.put("message", "success");
        } catch (Exception e) {
            logger.info("getJobList error {} ", e);
            resultMap.put("status", 500);
            resultMap.put("message", e.getMessage());
        }

        return resultMap;
    }

    private JobListSelectRequestParam buildSelectParam(int cityId, int areaId, int cateId, int days, int jobType, String sortType, int salary, int offset, int limit, int experience, int degree) throws WrongParamException {

        JobListSelectRequestParam selectRequestParam = new JobListSelectRequestParam();
        selectRequestParam.setCityId(cityId);
        selectRequestParam.setAreaId(areaId);
        selectRequestParam.setCateId(cateId);
        selectRequestParam.setDays(days);
        selectRequestParam.setJobType(jobType);
        selectRequestParam.setSortType(sortType);
        selectRequestParam.setSalary(salary);
        selectRequestParam.setOffset(offset);
        selectRequestParam.setLimit(limit);
        selectRequestParam.setExperience(experience);
        selectRequestParam.setDegree(degree);
        return selectRequestParam;
    }

    // todo @hulei02 完善请求参数
    private void checkParam(int cityId, int areaId, int salaryMin, int salaryMax, int days, int jobType, String sortType) {

    }


}
