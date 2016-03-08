package com.qiezi.hermes.api.dao;

import com.qiezi.hermes.api.domain.ApplicationDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IApplicationDAO {
    public int addApplication(@Param("userId") int userId, @Param("jobId") int jobId);

    public ApplicationDO getApplicationByUserIdAndJobId(@Param("userId") int userId, @Param("jobId") int jobId);
}
