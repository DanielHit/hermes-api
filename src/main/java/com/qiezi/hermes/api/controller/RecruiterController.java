package com.qiezi.hermes.api.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 招聘者所有的个人页面
 */
@RestController
@RequestMapping("/api/user/recruiter")
public class RecruiterController {

    // 发布新的工作岗位
    @RequestMapping(value = "/postJob", method = RequestMethod.POST)
    public Map<String, Object> postNewJob(@RequestParam(required = true, defaultValue = "10") int ci, @ModelAttribute("appVersion") float appVersion, HttpServletRequest request) {
        return ImmutableMap.<String, Object>builder().put("data", "fuck").build();
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
