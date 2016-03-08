package com.qiezi.hermes.api.domain;

import java.util.Date;

public class JobDescDO {

    private int id;
    private int cityId;
    private int areaId;
    private String jobName;
    private int jobType;
    private String jobImg;
    private String welfare;
    private int experience;
    private int degree;
    private int gender;
    private int salary;
    private String address;
    private double longitude;
    private double latitude;
    private Date postTime;    //后台直接切换到具体的日期格式,5分钟前, 2小时前,3天前
    private String jobContent;
    private int employerId;
    private String employerName;
    private String employerTitle;
    private String employerdImg;
    private int companyId;
    private String companyName;
    private String companyDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }


    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerTitle() {
        return employerTitle;
    }

    public void setEmployerTitle(String employerTitle) {
        this.employerTitle = employerTitle;
    }

    public String getEmployerdImg() {
        return employerdImg;
    }

    public void setEmployerdImg(String employerdImg) {
        this.employerdImg = employerdImg;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobImg() {
        return jobImg;
    }

    public void setJobImg(String jobImg) {
        this.jobImg = jobImg;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JobDescDO{");
        sb.append("id=").append(id);
        sb.append(", cityId=").append(cityId);
        sb.append(", areaId=").append(areaId);
        sb.append(", jobName='").append(jobName).append('\'');
        sb.append(", jobType=").append(jobType);
        sb.append(", jobImg='").append(jobImg).append('\'');
        sb.append(", welfare='").append(welfare).append('\'');
        sb.append(", experience=").append(experience);
        sb.append(", degree=").append(degree);
        sb.append(", gender=").append(gender);
        sb.append(", salary=").append(salary);
        sb.append(", address='").append(address).append('\'');
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", postTime=").append(postTime);
        sb.append(", employerId=").append(employerId);
        sb.append(", employerName='").append(employerName).append('\'');
        sb.append(", employerTitle='").append(employerTitle).append('\'');
        sb.append(", employerdImg='").append(employerdImg).append('\'');
        sb.append(", companyId=").append(companyId);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", companyDesc='").append(companyDesc).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
