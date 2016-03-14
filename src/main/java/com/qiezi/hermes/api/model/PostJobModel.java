package com.qiezi.hermes.api.model;

import java.io.Serializable;

/**
 * 招聘者查看发布的职位
 */
public class PostJobModel implements Serializable {

    private static final long serialVersionUID = -3572253155979533039L;

    private int jobId;
    private String jobName;
    private String editDate;            // 更新日期
    private int applicationNum;         // 岗位投递数量

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

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public int getApplicationNum() {
        return applicationNum;
    }

    public void setApplicationNum(int applicationNum) {
        this.applicationNum = applicationNum;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PostJobModel{");
        sb.append("jobId=").append(jobId);
        sb.append(", jobName='").append(jobName).append('\'');
        sb.append(", editDate='").append(editDate).append('\'');
        sb.append(", applicationNum=").append(applicationNum);
        sb.append('}');
        return sb.toString();
    }
}
