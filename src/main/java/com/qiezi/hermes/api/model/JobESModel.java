package com.qiezi.hermes.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.List;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-07
 */
@Document(indexName = "hermes", type = "job")
public class JobESModel {
	private static final String analyzer = "ik";
	@Id
	private int jobId;
	private int cityId;
	private int areaId;
	private int cateId;
	private int jobType;
	@Field(analyzer = analyzer)
	private String jobName;
	@Field(analyzer = analyzer)
	private String jobDesc;
	private String jobExperience;
	@Field(analyzer = analyzer)
	private String jobAddress;
	@Field(analyzer = analyzer)
	private String companyName;
	@Field(analyzer = analyzer)
	private String companyDesc;
	@Field
	private String jobContent;
	@Field(analyzer = analyzer)
	private List<String> welfareList;
	private int minSalary;
	private int maxSalary;
	private int experience;
	private int degree;
	private long createTimeMillis;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
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

	public String getJobExperience() {
		return jobExperience;
	}

	public void setJobExperience(String jobExperience) {
		this.jobExperience = jobExperience;
	}

	public String getJobAddress() {
		return jobAddress;
	}

	public void setJobAddress(String jobAddress) {
		this.jobAddress = jobAddress;
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

	public long getCreateTimeMillis() {
		return createTimeMillis;
	}

	public void setCreateTimeMillis(long createTimeMillis) {
		this.createTimeMillis = createTimeMillis;
	}

	public List<String> getWelfareList() {
		return welfareList;
	}

	public void setWelfareList(List<String> welfareList) {
		this.welfareList = welfareList;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public int getJobType() {
		return jobType;
	}

	public void setJobType(int jobType) {
		this.jobType = jobType;
	}

	public static String getAnalyzer() {
		return analyzer;
	}

	public String getJobContent() {
		return jobContent;
	}

	public void setJobContent(String jobContent) {
		this.jobContent = jobContent;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("JobESModel{");
		sb.append("jobId=").append(jobId);
		sb.append(", cityId=").append(cityId);
		sb.append(", areaId=").append(areaId);
		sb.append(", cateId=").append(cateId);
		sb.append(", jobType=").append(jobType);
		sb.append(", jobName='").append(jobName).append('\'');
		sb.append(", jobDesc='").append(jobDesc).append('\'');
		sb.append(", jobExperience='").append(jobExperience).append('\'');
		sb.append(", jobAddress='").append(jobAddress).append('\'');
		sb.append(", companyName='").append(companyName).append('\'');
		sb.append(", companyDesc='").append(companyDesc).append('\'');
		sb.append(", jobContent='").append(jobContent).append('\'');
		sb.append(", welfareList=").append(welfareList);
		sb.append(", minSalary=").append(minSalary);
		sb.append(", maxSalary=").append(maxSalary);
		sb.append(", experience=").append(experience);
		sb.append(", degree=").append(degree);
		sb.append(", createTimeMillis=").append(createTimeMillis);
		sb.append('}');
		return sb.toString();
	}
}
