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
    
    public List<JobDescDO> getJobDescListBySelectParam(@Param("cityId") int cityId, @Param("areaId") int areaId, @Param("cateId") int cateId, @Param("experience") int experience, @Param("degree") int degree, @Param("salary") int salray, @Param("postTime") String postTime);

    public JobDescDO getJobDescByJobId(@Param("jobId") int jobId);

    public List<JobDescDO> getJobDescList(@Param("offset") int offset, @Param("limit") int limit);

    public int countJob();

    public int addNewJobDesc(@Param("cityId") int cityId, @Param("areaId") int areaId, @Param("cateId") int cateId, @Param("jobName") String jobName,
                             @Param("jobType") int jobType, @Param("salary") int salary, @Param("welfare") String welfare, @Param("experience") int experience, @Param("degree") int degree,
                             @Param("jobImg") String jobImg, @Param("address") String address,
                             @Param("longitude") double longitude, @Param("latitude") double latitude, @Param("userId") int userId,
                             @Param("jobContent") String jobContent, @Param("companyDesc") String company_desc);

    public List<JobDescDO> getJobListByPostUserId(@Param("postUserId") int postUserId, @Param("stage") int stage);
}
