package com.qiezi.hermes.api.param;

/*
    筛选查询岗位请求参数
 */
public class JobListSelectRequestParam {

    private int cityId;
    private int areaId;
    private int cateId;
    private int salaryMin;
    private int salaryMax;
    private int salary;
    private int days;           // 已经发布的天数
    private int jobType;        // 职位类型 0 全职 1兼职 2实习
    private int degree;         // 学历  degree: 0-不限  1-高中  2-技校 3-专科 4-本科 5-硕士
    private int experience;     // 工作经验     0:不限制  1:1-2年 2:3-5年 3:5-10年  4: 10年以上
    private String sortType;    // default salaryUp salaryDown postTimeUp postTimeDown
	private String keyWord;
    private int limit;          //
    private int offset;         //  偏移量

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

    public int getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(int salaryMin) {
        this.salaryMin = salaryMin;
    }

    public int getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(int salaryMax) {
        this.salaryMax = salaryMax;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("JobListSelectRequestParam{");
		sb.append("cityId=").append(cityId);
		sb.append(", areaId=").append(areaId);
		sb.append(", cateId=").append(cateId);
		sb.append(", salaryMin=").append(salaryMin);
		sb.append(", salaryMax=").append(salaryMax);
		sb.append(", salary=").append(salary);
		sb.append(", days=").append(days);
		sb.append(", jobType=").append(jobType);
		sb.append(", degree=").append(degree);
		sb.append(", experience=").append(experience);
		sb.append(", sortType='").append(sortType).append('\'');
		sb.append(", keyWord='").append(keyWord).append('\'');
		sb.append(", limit=").append(limit);
		sb.append(", offset=").append(offset);
		sb.append('}');
		return sb.toString();
	}
}
