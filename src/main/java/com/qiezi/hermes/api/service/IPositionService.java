package com.qiezi.hermes.api.service;

import com.qiezi.hermes.api.model.PostJobModel;

import java.util.List;

public interface IPositionService {
    public List<PostJobModel> getPostJobList(int userId);
}
