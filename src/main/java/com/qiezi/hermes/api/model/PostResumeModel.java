package com.qiezi.hermes.api.model;

import java.io.Serializable;

/**
 * Created by Daniel on 3/15/16.
 */
public class PostResumeModel implements Serializable {

    private static final long serialVersionUID = -1078350938291708843L;

    private int applicationId;
    private int resumeId;
    private String date;
    private int userId;
    private String candidateName;    // 求职者名称
    private String telephone;
    private int jobId;          // 投递的岗位ID
    private String jobName;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PostResumeModel{");
        sb.append("applicationId=").append(applicationId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", date='").append(date).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", candidateName='").append(candidateName).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", jobId=").append(jobId);
        sb.append(", jobName='").append(jobName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
