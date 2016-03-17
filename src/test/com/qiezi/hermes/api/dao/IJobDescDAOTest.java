package com.qiezi.hermes.api.dao;

import base.BaseNonTransactionTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class IJobDescDAOTest extends BaseNonTransactionTest {

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

    // code everywhere
    @Test
    public void testAddNewJobDesc() throws Exception {
//        jobDescDAO.addNewJobDesc(1, 123, 10002, "销售", 0, 1000, "福利各种待遇好", 0, 0, 1000, 2000, "http://img3.imgtn.bdimg.com/it/u=1183223528,3058066243&fm=21&gp=0.jpg",
//                "北京市朝阳区望京国际研发园", 12.23, 234.34, 12345, "茄子科技有限公司", "负责给各个女生进行保研", "公司各种福利赶紧过来吧");
    }

    @Test
    public void testGetJDByPostUserID() throws Exception {
        System.out.println("*****************************************");
        System.out.println(jobDescDAO.getJobListByPostUserId(12345, 1));
    }

    @Test
    public void testSetJobStatus() throws Exception {
        System.out.println(jobDescDAO.setJobServiceStatus(10002,0));
    }
}