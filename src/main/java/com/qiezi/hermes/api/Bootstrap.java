package com.qiezi.hermes.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-08
 */
@Configuration
@EnableAutoConfiguration(exclude = {ElasticsearchAutoConfiguration.class})
@ComponentScan
@EnableScheduling
@EnableElasticsearchRepositories
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Bootstrap {
	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class);
	}
}
