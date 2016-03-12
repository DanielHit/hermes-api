package com.qiezi.hermes.api.dao;

import com.qiezi.hermes.api.domain.ResumeDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IResumeDAO {

    public int editResume(@Param("userId")int userId, @Param("userImg")String userImg,@Param("phoneNum") String phoneNum, @Param("address") String address, @Param("educationContent") String educationContent, @Param("workContent") String workContent, @Param("workYear") int workYear, @Param("degree") int degree, @Param("startDate") String startDate, @Param("cateId")int cateId);

    public int addResume(@Param("userId")int userId,  @Param("userImg")String userImg,@Param("phoneNum") String phoneNum, @Param("address") String address,  @Param("educationContent")String educationContent, @Param("workContent") String workContent, @Param("workYear") int workYear, @Param("degree") int degree, @Param("startDate") String startDate, @Param("cateId")int cateId);

    public ResumeDO getResumeByUserId(@Param("userId") int userId);
}
