package com.qiezi.hermes.api.param;

/**
 * Created by Daniel on 3/8/16.
 */
public class PostNewJobRequestParam {

    private int userId;
    private int cateId;            //大的行业方面 todo 思考如何划分 职位范围
    private String jobName;
    private String jobContent;
    private String companyDesc;
    private int jobType;
    private int salary;
    private String welfare;
    private String address;
    private String employerName;
    private String employerPostion;
    private int phoneNum;

    public PostNewJobRequestParam(int userId, int cateId, String jobName, String jobContent, String companyDesc, int jobType, int salary, String welfare, String address, String employerName, String employerPostion, int phoneNum) {
        this.userId = userId;
        this.cateId = cateId;
        this.jobName = jobName;
        this.jobContent = jobContent;
        this.companyDesc = companyDesc;
        this.jobType = jobType;
        this.salary = salary;
        this.welfare = welfare;
        this.address = address;
        this.employerName = employerName;
        this.employerPostion = employerPostion;
        this.phoneNum = phoneNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerPostion() {
        return employerPostion;
    }

    public void setEmployerPostion(String employerPostion) {
        this.employerPostion = employerPostion;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PostNewJobRequestParam{");
        sb.append("userId=").append(userId);
        sb.append(", cateId=").append(cateId);
        sb.append(", jobName='").append(jobName).append('\'');
        sb.append(", jobContent='").append(jobContent).append('\'');
        sb.append(", companyDesc='").append(companyDesc).append('\'');
        sb.append(", jobType=").append(jobType);
        sb.append(", salary=").append(salary);
        sb.append(", welfare='").append(welfare).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", employerName='").append(employerName).append('\'');
        sb.append(", employerPostion='").append(employerPostion).append('\'');
        sb.append(", phoneNum='").append(phoneNum).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
