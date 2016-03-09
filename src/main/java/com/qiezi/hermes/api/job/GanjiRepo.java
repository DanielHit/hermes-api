package com.qiezi.hermes.api.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-09
 */
public interface GanjiRepo extends JpaRepository<GanjiJob, Integer> {

}
