package com.qiezi.hermes.api.dao;

import base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Daniel on 3/15/16.
 */
public class IUserDAOTest extends BaseTest {

    @Autowired
    private IUserDAO userDAO;

    @Test
    public void testGetUserInfoById() throws Exception {
        System.out.println(userDAO.getUserInfoById(12345));
    }
}