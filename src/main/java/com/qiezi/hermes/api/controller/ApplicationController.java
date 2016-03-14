package com.qiezi.hermes.api.controller;

import com.google.common.collect.ImmutableMap;
import com.qiezi.hermes.api.service.IApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-08
 */
@RestController
@RequestMapping("/api/user/application")
public class ApplicationController {

    @Resource
    private IApplicationService applicationService;

    public static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @RequestMapping("/list")
    public Map<String, ? extends Object> applicationList(int userId) {
        try {
            return ImmutableMap.<String, Object>builder().put("data", applicationService.getApplicationByUserId(userId)).put("status", 200).build();
        } catch (Exception e) {
            logger.error("get application error {} ", e);
        }
        return ImmutableMap.<String, Object>builder().put("status", 500).build();
    }
}
