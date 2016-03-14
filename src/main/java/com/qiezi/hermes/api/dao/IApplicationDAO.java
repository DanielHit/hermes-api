package com.qiezi.hermes.api.dao;

import com.qiezi.hermes.api.domain.ApplicationDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-08
 */
@Repository
public interface IApplicationDAO {

    public int addApplication(@Param("userId") int userId, @Param("jobId") int jobId);

    public ApplicationDO getApplicationByUserIdAndJobId(@Param("userId") int userId, @Param("jobId") int jobId);

    List<ApplicationDO> getApplicationByUserId(int userId);

    public int getApplicatioNumByJobId(@Param("jobId") int jobId);
}
