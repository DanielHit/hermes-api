package com.qiezi.hermes.api.service.Impl;

import base.BaseTest;
import com.qiezi.hermes.api.param.JobListSelectRequestParam;
import com.qiezi.hermes.api.service.IJobListService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Daniel on 3/7/16.
 */
public class JobListServiceImplTest extends BaseTest {

    @Autowired
    private IJobListService jobListService;

    @Test
    public void testGetJobListBySelect() throws Exception {

        JobListSelectRequestParam requestParam = new JobListSelectRequestParam();

        requestParam.setSortType("default");
        requestParam.setCityId(1);
        requestParam.setAreaId(123);
        requestParam.setCateId(10001);
        requestParam.setDays(10);
        requestParam.setDegree(0);
        requestParam.setExperience(0);
        requestParam.setLimit(10);
        requestParam.setOffset(0);
        requestParam.setSalary(0);

        System.out.println(jobListService.getJobListBySelect(requestParam));
    }
}