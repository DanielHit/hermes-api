package com.qiezi.hermes.api.domain;

import java.util.Date;

/**
 * Created by Daniel on 3/8/16.
 */
public class ApplicationDO {
    private int id;
    private int jobId;
    private int userId;
    private String date;
    private int stage;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ApplicationDO{");
        sb.append("id=").append(id);
        sb.append(", jobId=").append(jobId);
        sb.append(", userId=").append(userId);
        sb.append(", date='").append(date).append('\'');
        sb.append(", stage=").append(stage);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
