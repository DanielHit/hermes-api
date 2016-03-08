package com.qiezi.hermes.api.service;

import com.qiezi.hermes.api.model.JobESModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * Description: ES的DAO
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-07
 */
public interface IJobESRepository extends ElasticsearchCrudRepository<JobESModel, Integer> {
}
