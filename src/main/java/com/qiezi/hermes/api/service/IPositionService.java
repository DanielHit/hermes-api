package com.qiezi.hermes.api.service;

import com.qiezi.hermes.api.model.PostJobModel;
import com.qiezi.hermes.api.model.PostResumeModel;

import java.util.List;

public interface IPositionService {
    public List<PostJobModel> getPostJobList(int id, int userId);
    public List<PostResumeModel> getPostResumeList(int userId, int jobId, int stage);
}
