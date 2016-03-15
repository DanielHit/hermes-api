package com.qiezi.hermes.api.dao;

import com.qiezi.hermes.api.domain.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDAO {
    UserDO getUserInfoById(@Param("userId") int userId);
}
