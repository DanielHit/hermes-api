package com.qiezi.hermes.api.dao;

import base.BaseNonTransactionTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Daniel on 3/8/16.
 */
public class IApplicationDAOTest extends BaseNonTransactionTest {

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
        System.out.println(applicationDAO.getApplicationByUserIdAndJobId(10002, 12345));
    }
}