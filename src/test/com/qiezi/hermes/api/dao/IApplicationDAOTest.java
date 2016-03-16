package com.qiezi.hermes.api.dao;

import base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Daniel on 3/8/16.
 */
public class IApplicationDAOTest extends BaseTest {

    @Autowired
    private IApplicationDAO applicationDAO;

    @Test
    public void testAddApplication() throws Exception {
        int result = applicationDAO.addApplication(10002, 12345);
        System.out.println("*******result " + result);
    }

    @Test
    public void testGetApplicationByUserIdAndJobId() throws Exception {
        System.out.println("get here !");
        System.out.println(applicationDAO.getApplicationByUserIdAndJobId(10001, 12345));
    }

    @Test
    public void testGetApplicationByUserId() throws Exception {
        System.out.println(applicationDAO.getApplicationByUserId(100012));
    }

    @Test
    public void testGetApplicationNumByJobId() throws Exception {
        System.out.println("************ result");
        System.out.println(applicationDAO.getApplicatioNumByJobId(17699));
    }

    @Test
    public void testGetAppByPostUserId() throws Exception {
        System.out.println(applicationDAO.getApplicationListByPostUserId(12345, 1));
    }

    @Test
    public void testSetApplicationId() throws Exception {
        System.out.println(applicationDAO.setApplicationState(10031, 1));
    }
}