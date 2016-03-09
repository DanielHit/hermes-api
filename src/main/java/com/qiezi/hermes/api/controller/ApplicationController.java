package com.qiezi.hermes.api.controller;

import com.google.common.collect.ImmutableMap;
import com.qiezi.hermes.api.dao.IApplicationDAO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//	@Resource
	private IApplicationDAO applicationDAO;

	@RequestMapping("/list")
	public Map<String, ? extends Object> applicationList(int userId) {
		return ImmutableMap.of("data", applicationDAO.getByUserId(userId));
	}

	
}
