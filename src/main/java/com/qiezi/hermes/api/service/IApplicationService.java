package com.qiezi.hermes.api.service;

import com.qiezi.hermes.api.model.ApplicationModel;

import java.util.List;

/**
 * Created by Daniel on 3/14/16.
 */
public interface IApplicationService {
    public List<ApplicationModel> getApplicationByUserId(int userId);
}
