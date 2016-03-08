package com.qiezi.hermes.api.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.lease.Releasable;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.TransportClientFactoryBean;

import java.util.Properties;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-07
 */
@Configuration
@EnableConfigurationProperties(ElasticsearchProperties.class)
public class ElasticSearchConfig implements DisposableBean {

	@Autowired
	private ElasticsearchProperties properties;

	private Releasable releasable;

	@Bean
	public Client elasticSearchClient() throws Exception {
		TransportClientFactoryBean factory = new TransportClientFactoryBean();
		factory.setClusterNodes(properties.getClusterNodes());
		factory.setProperties(createProperties());
		factory.afterPropertiesSet();

		TransportClient transportClient = factory.getObject();
		releasable = transportClient;
		return transportClient;
	}

	private Properties createProperties() {
		Properties properties = new Properties();
		properties.put("cluster.name", this.properties.getClusterName());
		properties.putAll(this.properties.getProperties());
		return properties;
	}

	@Override
	public void destroy() throws Exception {
		releasable.close();
	}
}