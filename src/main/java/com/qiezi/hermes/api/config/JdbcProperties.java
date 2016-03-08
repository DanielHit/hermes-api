package com.qiezi.hermes.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-08
 */
@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {

	private String jdbcUrl;
	private String jdbcUserName;
	private String jdbcPassword;
	private String jdbcDriverClassName;
	private int jdbcInitialSize;
	private int jdbcMinIdle;
	private int jdbcMaxActive;
	private int jdbcMaxWait;
	private int timeBetweenEvictionRunsMillis;
	private int minEvictableIdleTimeMillis;
	private boolean testWhileIdle;
	private boolean testOnBorrow;
	private String validationQuery;

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public String getJdbcUserName() {
		return jdbcUserName;
	}

	public String getJdbcPassword() {
		return jdbcPassword;
	}

	public String getJdbcDriverClassName() {
		return jdbcDriverClassName;
	}

	public int getJdbcInitialSize() {
		return jdbcInitialSize;
	}

	public int getJdbcMinIdle() {
		return jdbcMinIdle;
	}

	public int getJdbcMaxActive() {
		return jdbcMaxActive;
	}

	public int getJdbcMaxWait() {
		return jdbcMaxWait;
	}

	public int getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public int getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}


	public String getValidationQuery() {
		return validationQuery;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public void setJdbcUserName(String jdbcUserName) {
		this.jdbcUserName = jdbcUserName;
	}

	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}

	public void setJdbcDriverClassName(String jdbcDriverClassName) {
		this.jdbcDriverClassName = jdbcDriverClassName;
	}

	public void setJdbcInitialSize(int jdbcInitialSize) {
		this.jdbcInitialSize = jdbcInitialSize;
	}

	public void setJdbcMinIdle(int jdbcMinIdle) {
		this.jdbcMinIdle = jdbcMinIdle;
	}

	public void setJdbcMaxActive(int jdbcMaxActive) {
		this.jdbcMaxActive = jdbcMaxActive;
	}

	public void setJdbcMaxWait(int jdbcMaxWait) {
		this.jdbcMaxWait = jdbcMaxWait;
	}

	public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public boolean isTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(boolean testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public boolean isTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}
}
