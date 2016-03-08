package com.qiezi.hermes.api.model;

import com.qiezi.hermes.api.domain.JobDescDO;

import java.io.Serializable;

/**
 * Created by Daniel on 3/6/16.
 */
public class JobDescModel implements Serializable {

    private static final long serialVersionUID = 4311529118276977759L;
    private int id;
    private String name;
    private int jobType;
    private String welfareList;
    private int experience;
    private int degree;
    private int gender;
    private int minSalary;
    private int maxSalary;
    private String jobImg;
    private String address;
    private double longitude;
    private double latitude;
    private String postTime;    //后台直接切换到具体的日期格式,5分钟前, 2小时前,3天前
    private String jobContent;  //岗位职责详细描述
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    public String getWelfareList() {
        return welfareList;
    }

    public void setWelfareList(String welfareList) {
        this.welfareList = welfareList;
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

    public String getJobImg() {
        return jobImg;
    }

    public void setJobImg(String jobImg) {
        this.jobImg = jobImg;
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

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
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

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public JobDescModel() {
    }

    public JobDescModel(JobDescDO jobDescDO) {
        this.setId(jobDescDO.getId());
        this.setAddress(jobDescDO.getAddress());
        this.setCompanyDesc(jobDescDO.getCompanyDesc());
        this.setCompanyId(jobDescDO.getCompanyId());
        this.setCompanyName(jobDescDO.getCompanyName());
        this.setEmployerdImg(jobDescDO.getEmployerdImg());
        this.setEmployerId(jobDescDO.getEmployerId());
        this.setEmployerName(jobDescDO.getEmployerName());
        this.setEmployerTitle(jobDescDO.getEmployerTitle());
        this.setDegree(jobDescDO.getDegree());
        this.setExperience(jobDescDO.getExperience());
        this.setGender(jobDescDO.getGender());
        this.setJobImg(jobDescDO.getJobImg());
        this.setJobType(jobDescDO.getJobType());
        this.setGender(jobDescDO.getGender());
        this.setLatitude(jobDescDO.getLatitude());
        this.setLongitude(jobDescDO.getLongitude());

        // todo 将不同的等级进行转换 salary范围 学历要求educatoin 经验要求
        this.setMaxSalary(jobDescDO.getSalary());
        this.setMinSalary(jobDescDO.getSalary());
        this.setName(jobDescDO.getJobName());
        this.setPostTime(jobDescDO.getPostTime().toString());
        this.setWelfareList(jobDescDO.getWelfare());
        this.setJobContent(jobDescDO.getJobContent());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JobDescModel{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", jobType=").append(jobType);
        sb.append(", welfareList='").append(welfareList).append('\'');
        sb.append(", experience=").append(experience);
        sb.append(", degree=").append(degree);
        sb.append(", gender=").append(gender);
        sb.append(", minSalary=").append(minSalary);
        sb.append(", maxSalary=").append(maxSalary);
        sb.append(", jobImg='").append(jobImg).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", postTime='").append(postTime).append('\'');
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
