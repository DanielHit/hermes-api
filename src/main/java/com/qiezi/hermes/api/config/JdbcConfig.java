package com.qiezi.hermes.api.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2016-03-08
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableConfigurationProperties(JdbcProperties.class)
@MapperScan("com.qiezi.hermes.api.dao")
public class JdbcConfig {

	@Autowired
	private JdbcProperties jdbcProperties;

	@Bean(destroyMethod = "close")
	public DruidDataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(jdbcProperties.getJdbcUrl());
		dataSource.setUsername(jdbcProperties.getJdbcUserName());
		dataSource.setPassword(jdbcProperties.getJdbcPassword());
		dataSource.setDriverClassName(jdbcProperties.getJdbcDriverClassName());
		dataSource.setInitialSize(jdbcProperties.getJdbcInitialSize());
		dataSource.setMinIdle(jdbcProperties.getJdbcMinIdle());
		dataSource.setMaxActive(jdbcProperties.getJdbcMaxActive());
		dataSource.setMaxWait(jdbcProperties.getJdbcMaxWait());
		dataSource.setTimeBetweenConnectErrorMillis(jdbcProperties.getTimeBetweenEvictionRunsMillis());
		dataSource.setMinEvictableIdleTimeMillis(jdbcProperties.getMinEvictableIdleTimeMillis());
		dataSource.setTestWhileIdle(jdbcProperties.isTestWhileIdle());
		dataSource.setTestOnBorrow(jdbcProperties.isTestOnBorrow());
		dataSource.setValidationQuery(jdbcProperties.getValidationQuery());
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}


	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mybatis/mapper/*.xml"));
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/sqlmap-config.xml"));
		return sqlSessionFactoryBean;
	}
//	@Bean
//	public SqlSessionFactory sessionFactory() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource());
//		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mybatis/mapper/*.xml"));
//		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/sqlmap-config.xml"));
//		return sqlSessionFactoryBean.getObject();
//	}

//	@Bean
//	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactoryBean());
//	}
//
//	@Bean
//	public MapperScannerConfigurer mapperScannerConfigurer() {
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//		mapperScannerConfigurer.setBasePackage("com.qiezi.hermes.api.dao");
//		mapperScannerConfigurer.setSqlSessionTemplateBeanName("sqlSessionTemplate");
//		return mapperScannerConfigurer;
//	}

}
