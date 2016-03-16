package com.qiezi.hermes.api.dao;

import com.qiezi.hermes.api.domain.ApplicationDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IApplicationDAO {

    public int addApplication(@Param("userId") int userId, @Param("jobId") int jobId);

    public ApplicationDO getApplicationByUserIdAndJobId(@Param("userId") int userId, @Param("jobId") int jobId);

    List<ApplicationDO> getApplicationByUserId(int userId);

    public int getApplicatioNumByJobId(@Param("jobId") int jobId);

    List<ApplicationDO> getApplicationListByJobId(int jobId, int stage);

    List<ApplicationDO> getApplicationListByPostUserId(@Param("postUserId") int postUserId, @Param("stage") int stage);

    int setApplicationState(@Param("applicationId") int applicationId, @Param("stage") int stage);
}
