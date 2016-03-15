package com.qiezi.hermes.api.domain;

/**
 * Created by Daniel on 3/15/16.
 */
public class UserDO {
    private int id;
    private int userType;
    private String name;
    private String userImg;
    private String phoneNum;
    private String email;
    private String password;
    private String companyPosition;
    private int companyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyPosition() {
        return companyPosition;
    }

    public void setCompanyPosition(String companyPosition) {
        this.companyPosition = companyPosition;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserDO{");
        sb.append("id=").append(id);
        sb.append(", userType=").append(userType);
        sb.append(", name='").append(name).append('\'');
        sb.append(", userImg='").append(userImg).append('\'');
        sb.append(", phoneNum='").append(phoneNum).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", companyPosition='").append(companyPosition).append('\'');
        sb.append(", companyId=").append(companyId);
        sb.append('}');
        return sb.toString();
    }
}
