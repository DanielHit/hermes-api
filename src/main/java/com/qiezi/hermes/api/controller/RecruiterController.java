package com.qiezi.hermes.api.controller;

import com.google.common.collect.ImmutableMap;
import com.qiezi.hermes.api.dao.IJobDescDAO;
import com.qiezi.hermes.api.param.PostNewJobRequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 招聘者所有的个人页面
 */
@RestController
@RequestMapping("/api/user/recruiter")
public class RecruiterController {
    public static final Logger logger = LoggerFactory.getLogger(RecruiterController.class);
    @Autowired
    private IJobDescDAO jobDescDAO;

    @RequestMapping(value = "/postJob", method = RequestMethod.POST)
    public Map<String, Object> postNewJob(@RequestParam(required = true) int cityId, @RequestParam(required = true) int areaId,
                                          @RequestParam(required = true) String jobName, @RequestParam(required = true) int cateId,
                                          @RequestParam(required = true) String jobContent, @RequestParam(required = true) String companyDesc, @RequestParam(required = false) int jobType,
                                          @RequestParam(required = false) int salary, @RequestParam(required = true) String welfare, @RequestParam(required = true) int experience, @RequestParam(required = true) String address,
                                          @RequestParam(required = true) int userId, @RequestParam(required = true) String jobImg, @RequestParam(required = false) int degree, @RequestParam(required = false) double longitude, @RequestParam(required = false) double latitude) {


        int result = jobDescDAO.addNewJobDesc(cityId, areaId, cateId, jobName, jobType, salary, welfare, experience, degree, jobImg, address,
                longitude, latitude, userId, jobContent, companyDesc);
        try {
            if (result == 1) {
                return ImmutableMap.<String, Object>builder().put("data", "1").put("status", 200).build();
            }
        } catch (Exception e) {
            logger.error("postNew job error {} ", e);
        }
        return ImmutableMap.<String, Object>builder().put("data", "-1").put("status", 500).build();

    }

    private PostNewJobRequestParam buildPostNewJobRequestParam(String jobName, int cateId, String jobContent, String companyDesc, int jobType, int salary, String welfare, String address, String employerName, int userId, String employerPostion, int phoneNum) {
        return new PostNewJobRequestParam(userId, cateId, jobName, jobContent, companyDesc, jobType, salary, welfare, address, employerName, employerPostion, phoneNum);
    }

    // 查看已经发布的职位
    @RequestMapping(value = "/getJob", method = RequestMethod.GET)
    public Map<String, Object> getAllJob(@RequestParam(required = true, defaultValue = "10") int ci, @ModelAttribute("appVersion") float appVersion, HttpServletRequest request) {
        return ImmutableMap.<String, Object>builder().put("data", "fuck").build();
    }

    // 更改已经发布的职位
    @RequestMapping(value = "/editJob", method = RequestMethod.POST)
    public Map<String, Object> editJob(@RequestParam(required = true, defaultValue = "10") int ci, @ModelAttribute("appVersion") float appVersion, HttpServletRequest request) {
        return ImmutableMap.<String, Object>builder().put("data", "fuck").build();
    }


}
