package com.qiezi.hermes.api.service.Impl;

import base.BaseTest;
import com.qiezi.hermes.api.service.IJobDetailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Daniel on 3/7/16.
 */
public class JobDetailServiceImplTest extends BaseTest {

    @Autowired
    private IJobDetailService jobDetailService;

    @Test
    public void testGetJobDescById() throws Exception {
        System.out.println(jobDetailService.getJobDescById(10002));
    }


}