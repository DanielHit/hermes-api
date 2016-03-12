package com.qiezi.hermes.api.dao;

import base.BaseNonTransactionTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Daniel on 3/12/16.
 */
public class IResumeDAOTest extends BaseNonTransactionTest {

    @Autowired
    private IResumeDAO resumeDAO;

    @Test
    public void testEditResume() throws Exception {
        System.out.println(resumeDAO.editResume(12345, "http://1.2.4", "18610027435", "北京市朝阳大妈所在小区", "教育牛逼", "工作内容牛逼", 3, 2, "2016-03-20", 23));
    }

    @Test
    public void testGetResumeByUserId() throws Exception {
        System.out.println(resumeDAO.getResumeByUserId(12345));
    }

    @Test
    public void testAddNewResume() throws Exception {
        System.out.println(resumeDAO.addResume(12346, "http://1.2.3", "18610027435", "海淀区地址", "教育牛逼", "工作内容牛逼", 3, 2, "2016-03-20", 23));

    }
}