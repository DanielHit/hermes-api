package com.qiezi.hermes.api.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

// 首页接口
@RestController
@RequestMapping("/api/index")
public class IndexController {

    @RequestMapping("/")
    public Map<String, Object> index() {
        return ImmutableMap.<String, Object>builder().put("data", "what a fuck").build();

    }

    // 获取首页所有的开通品类
    @RequestMapping("/getCategoryList")
    public Map<String, Object> getCategoryList(@RequestParam(required = true, defaultValue = "10") int ci, @ModelAttribute("appVersion") float appVersion, HttpServletRequest request) {
        return ImmutableMap.<String, Object>builder().put("data", "ew").build();
    }

    // 获取当前城市开通区域
    @RequestMapping("/getAreaList")
    public Map<String, Object> getAreaList(@RequestParam(required = true, defaultValue = "10") int ci, @ModelAttribute("appVersion") float appVersion, HttpServletRequest request) {
        return ImmutableMap.<String, Object>builder().put("data", "ew").build();

    }


}
