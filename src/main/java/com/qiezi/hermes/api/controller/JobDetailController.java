package com.qiezi.hermes.api.controller;

import com.qiezi.hermes.api.model.JobDescModel;
import com.qiezi.hermes.api.service.IJobDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// 职位详情页接口
@RestController
@RequestMapping("/api/jobdetail/")
public class JobDetailController {
    public static final Logger logger = LoggerFactory.getLogger(JobDetailController.class);
    @Autowired
    private IJobDetailService jobDetailService;

    // 查看职位详情接口
    @RequestMapping("/getjobdesc")
    public Map<String, Object> getJobList(@RequestParam("jobId") int jobId) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            JobDescModel jobDescModel = jobDetailService.getJobDescById(jobId);
            if (jobDescModel != null) {
                resultMap.put("data", jobDescModel);
                resultMap.put("status", 200);
                resultMap.put("message", "success");
            } else {
                resultMap.put("status", 404);
                resultMap.put("message", "not found the job");

            }
        } catch (Exception e) {
            logger.error("get job detail message error " + e);
            resultMap.put("status", 500);
            resultMap.put("message", e.toString());
        }
        return resultMap;
    }

    // 申请职位
    @RequestMapping(value = "/applyJob", method = RequestMethod.POST)
    public Map<String, Object> applyJob(@RequestParam("jobId") int jobId, @RequestParam("userId") int userId) {
        Map<String, Object> resultMap = new HashMap<>();

        try {
            if (jobDetailService.applyJobById(jobId, userId) == 1) {
                resultMap.put("data", "1");         // 1 代表申请成功
                resultMap.put("status", 200);
                resultMap.put("message", "success");
            } else {
                resultMap.put("data", jobDetailService.applyJobById(jobId, userId));         // 1代表已经申请过
                resultMap.put("status", 200);
                resultMap.put("message", "success");
            }

        } catch (Exception e) {

            logger.error("applyJob error " + e);
            resultMap.put("status", 500);
            resultMap.put("message", e.toString());
        }

        return resultMap;
    }


}
