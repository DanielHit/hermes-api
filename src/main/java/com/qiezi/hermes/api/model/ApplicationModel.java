package com.qiezi.hermes.api.model;

import java.io.Serializable;

/**
 * Created by Daniel on 3/14/16.
 */
public class ApplicationModel implements Serializable {

    private static final long serialVersionUID = 8868485949541602137L;

    private int id;
    private String jobName;
    private String hireManager;
    private String company;
    private String stage;
    private int days;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getHireManager() {
        return hireManager;
    }

    public void setHireManager(String hireManager) {
        this.hireManager = hireManager;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ApplicationModel{");
        sb.append("id=").append(id);
        sb.append(", jobName='").append(jobName).append('\'');
        sb.append(", hireManager='").append(hireManager).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", stage='").append(stage).append('\'');
        sb.append(", days=").append(days);
        sb.append('}');
        return sb.toString();
    }
}
