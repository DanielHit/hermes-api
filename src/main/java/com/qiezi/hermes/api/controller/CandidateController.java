package com.qiezi.hermes.api.controller;

import com.google.common.collect.ImmutableMap;
import com.qiezi.hermes.api.dao.IResumeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 求职者相关的所有后台接口
 */
@RestController
@RequestMapping("/api/user/candidate")
public class CandidateController {
    @Autowired
    private IResumeDAO resumeDAO;

    public static final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    // 查看个人简历接口
    @RequestMapping(value = "/getResume", method = RequestMethod.GET)
    public Map<String, Object> getUserResume(@RequestParam(required = true) int userId) {

        try {
            if (resumeDAO.getResumeByUserId(userId) != null) {
                return ImmutableMap.<String, Object>builder().put("data", resumeDAO.getResumeByUserId(userId)).put("status", 200).build();
            }
        } catch (Exception e) {
            logger.info("getUserResume {}", e);
        }
        return ImmutableMap.<String, Object>builder().put("status", 500).build();
    }

    // 修改个人简历接口
    @RequestMapping(value = "/editResume", method = RequestMethod.POST)
    public Map<String, Object> editResume(@RequestParam(required = true) int userId, @RequestParam(required = false) String userImg, @RequestParam(required = true) String phoneNum,
                                          @RequestParam(required = true) String address, @RequestParam(required = false) String education, @RequestParam(required = false) String workContent,
                                          @RequestParam(required = true) int workYear, @RequestParam(required = true) int degree,
                                          @RequestParam(required = true) String date, @RequestParam(required = true) int cateId) {

        try {
            int result = resumeDAO.editResume(userId, userImg, phoneNum, address, education, workContent, workYear, degree, date, cateId);
            return ImmutableMap.<String, Object>builder().put("data", result).put("status", 200).build();
        } catch (Exception e) {
            return ImmutableMap.<String, Object>builder().put("data", 0).put("status", 500).build();
        }
    }

    // 增加个人简历接口
    @RequestMapping(value = "/addNewResume", method = RequestMethod.POST)
    public Map<String, Object> addNewResume(@RequestParam(required = true) int userId, @RequestParam(required = false) String userImg, @RequestParam(required = true) String phoneNum,
                                            @RequestParam(required = true) String address, @RequestParam(required = false) String education, @RequestParam(required = false) String workContent,
                                            @RequestParam(required = true) int workYear, @RequestParam(required = true) int degree,
                                            @RequestParam(required = true) String date, @RequestParam(required = true) int cateId) {

        try {
            int result = resumeDAO.addResume(userId, userImg, phoneNum, address, education, workContent, workYear, degree, date, cateId);
            return ImmutableMap.<String, Object>builder().put("data", result).build();

        } catch (Exception e) {
            return ImmutableMap.<String, Object>builder().put("data", 0).build();
        }

    }


    // 查看个人招聘状态接口
    @RequestMapping(value = "/getApplication", method = RequestMethod.GET)
    public Map<String, Object> getApplication(@RequestParam(required = true, defaultValue = "10") int ci, @ModelAttribute("appVersion") float appVersion, HttpServletRequest request) {
        return ImmutableMap.<String, Object>builder().put("data", "fuck").build();

    }

    // 产看个人信箱 -> 沟通工具的东西
    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public Map<String, Object> getMessage(@RequestParam(required = true, defaultValue = "10") int ci, @ModelAttribute("appVersion") float appVersion, HttpServletRequest request) {
        return ImmutableMap.<String, Object>builder().put("data", "fuck").build();

    }


}
