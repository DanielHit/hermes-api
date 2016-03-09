package com.qiezi.hermes.api.job;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-09
 */
@Entity
public class GanjiJob {
	@Id
	private int id;
	private String jobId;
	private String title;
	private Date modTime;
	private String salary;
	private String address;
	private String companyDetail;
	private int cityId;

	public GanjiJob() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyDetail() {
		return companyDetail;
	}

	public void setCompanyDetail(String companyDetail) {
		this.companyDetail = companyDetail;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
}
