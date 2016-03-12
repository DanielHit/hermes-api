package com.qiezi.hermes.api.domain;

/**
 * Created by Daniel on 3/12/16.
 */
public class ResumeDO {
    private int id;
    private int userId;
    private String userImg;
    private String address;
    private String phoneNum;
    private int workYear;
    private String workContent;
    private int degree;
    private String educationContent;
    private String startDate;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWorkYear() {
        return workYear;
    }

    public void setWorkYear(int workYear) {
        this.workYear = workYear;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getEducationContent() {
        return educationContent;
    }

    public void setEducationContent(String educationContent) {
        this.educationContent = educationContent;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ResumeDO{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userImg='").append(userImg).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", phoneNum=").append(phoneNum);
        sb.append(", workYear=").append(workYear);
        sb.append(", workContent='").append(workContent).append('\'');
        sb.append(", degree=").append(degree);
        sb.append(", educationContent='").append(educationContent).append('\'');
        sb.append(", startDate='").append(startDate).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
