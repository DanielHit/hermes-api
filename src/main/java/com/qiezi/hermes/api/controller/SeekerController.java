package com.qiezi.hermes.api.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 求职者相关的所有后台接口
 */
@RestController
@RequestMapping("/api/user/seeker")
public class SeekerController {

    // 查看个人简历接口
    @RequestMapping(value = "/getResume", method = RequestMethod.GET)
    public Map<String, Object> getUserResume(@RequestParam(required = true, defaultValue = "10") int ci, @ModelAttribute("appVersion") float appVersion, HttpServletRequest request) {
        return ImmutableMap.<String, Object>builder().put("data", "fuck").build();

    }

    // 修改个人简历接口
    @RequestMapping(value = "/editResume", method = RequestMethod.POST)
    public Map<String, Object> changeResume(@RequestParam(required = true, defaultValue = "10") int ci, @ModelAttribute("appVersion") float appVersion, HttpServletRequest request) {
        return ImmutableMap.<String, Object>builder().put("data", "fuck").build();

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
