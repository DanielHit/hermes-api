package com.qiezi.hermes.api.domain;

import java.util.Date;

/**
 * Description: 一个申请记录
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-08
 */
public class ApplicationDO {
	private int id;
	private int jobId;
	private int userId;
	private Date date;
	private int stage;
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ApplicationDO{");
		sb.append("id=").append(id);
		sb.append(", jobId=").append(jobId);
		sb.append(", userId=").append(userId);
		sb.append(", date=").append(date);
		sb.append(", stage=").append(stage);
		sb.append(", status=").append(status);
		sb.append('}');
		return sb.toString();
	}
}
