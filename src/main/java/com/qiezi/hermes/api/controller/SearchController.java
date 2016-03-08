package com.qiezi.hermes.api.controller;

import com.qiezi.hermes.api.service.IJobSearchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-08
 */
@RestController
public class SearchController {
	@Resource
	private IJobSearchService jobSearchService;

	@RequestMapping("/s")
	public Object search(String key) {
		return jobSearchService.jobESModels(key);
	}
}
