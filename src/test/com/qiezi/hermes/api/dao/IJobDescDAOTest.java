package com.qiezi.hermes.api.dao;

import base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class IJobDescDAOTest extends BaseTest {

    @Autowired
    private IJobDescDAO jobDescDAO;

    @Test
    public void testGetJobDescListByParam() throws Exception {
        System.out.println(jobDescDAO.getJobDescListBySelectParam(1, 123, 10001, 0, 0, 0, "2016-03-01 00:00:00"));
    }

    @Test
    public void testGetJobDetailById() throws Exception {
        System.out.println(jobDescDAO.getJobDescByJobId(10002));
    }
}