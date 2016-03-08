package com.qiezi.hermes.api.dao;

import com.qiezi.hermes.api.domain.ApplicationDO;

import java.util.List;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-08
 */
public interface IApplicationDAO {
	List<ApplicationDO> getByUserId(int userId);
}
