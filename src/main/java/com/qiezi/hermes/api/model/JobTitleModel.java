package com.qiezi.hermes.api.model;

import java.io.Serializable;

/**
 * 职位列表中的职位数据模型
 */
public class JobTitleModel implements Serializable {

    private static final long serialVersionUID = 484754020880086195L;

    private int jobId;
    private String jobName;
    private int minSalary;
    private int maxSalary;
    private String imgUrl;
    private String address;
    private String postTime;
    private String welfare;

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

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JobTitleModel{");
        sb.append("jobId=").append(jobId);
        sb.append(", jobName='").append(jobName).append('\'');
        sb.append(", minSalary=").append(minSalary);
        sb.append(", maxSalary=").append(maxSalary);
        sb.append(", imgUrl='").append(imgUrl).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", postTime='").append(postTime).append('\'');
        sb.append(", welfare='").append(welfare).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
