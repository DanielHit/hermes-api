package com.qiezi.hermes.api.result;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Description: 搜索job返回的结果,目前只包括了数量和id列表
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-08
 */
public class JobSearchResult {
	// 命中总数
	private int total;
	// 返回的页面的id
	private List<Integer> jobIdList = Lists.newArrayList();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Integer> getJobIdList() {
		return jobIdList;
	}

	public void setJobIdList(List<Integer> jobIdList) {
		this.jobIdList = jobIdList;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("JobSearchResult{");
		sb.append("total=").append(total);
		sb.append(", jobIdList=").append(jobIdList);
		sb.append('}');
		return sb.toString();
	}
}
