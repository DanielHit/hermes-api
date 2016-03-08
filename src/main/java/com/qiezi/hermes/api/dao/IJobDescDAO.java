package com.qiezi.hermes.api.dao;

import com.qiezi.hermes.api.domain.JobDescDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Daniel on 3/6/16.
 */
@Repository
public interface IJobDescDAO {
    public List<JobDescDO> getJobDescListBySelectParam(@Param("cityId") int cityId, @Param("areaId") int areaId, @Param("cateId") int cateId, @Param("experience") int experience, @Param("degree") int degree,@Param("salary") int salray, @Param("postTime") String postTime);

    public JobDescDO getJobDescByJobId(@Param("jobId") int jobId);

	public List<JobDescDO> getJobDescList(@Param("offset") int offset, @Param("limit") int limit);

	public int countJob();
}
