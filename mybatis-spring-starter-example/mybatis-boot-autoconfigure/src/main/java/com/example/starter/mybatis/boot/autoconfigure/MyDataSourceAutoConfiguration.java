/**
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.starter.mybatis.boot.autoconfigure;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@org.springframework.context.annotation.Configuration
@ConditionalOnClass({ DataSource.class })
@EnableConfigurationProperties(MyDataSourceProperties.class)
//@Import({ Registrar.class, DataSourcePoolMetadataProvidersConfiguration.class })
public class MyDataSourceAutoConfiguration {

	private static Logger logger = LogManager.getLogger(MybatisAutoConfiguration.class);

	private final MyDataSourceProperties dataSourceProperties;

	public MyDataSourceAutoConfiguration(MyDataSourceProperties dataSourceProperties) {
		this.dataSourceProperties = dataSourceProperties;
	}

	@Bean     //声明其为Bean实例
	@Primary  //在同样的DataSource中，首先使用被标注的DataSource
	@ConditionalOnClass(DruidDataSource.class)
	public DataSource druidDataSource() {
		DruidDataSource dataSource = new DruidDataSource();

		dataSource.setUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUser());
		dataSource.setPassword(dataSourceProperties.getPassword());
		//configuration
		dataSource.setInitialSize(dataSourceProperties.getInitialSize());
		dataSource.setMinIdle(dataSourceProperties.getMinIdle());
		dataSource.setMaxActive(dataSourceProperties.getMaxActive());
		dataSource.setMaxWait(dataSourceProperties.getMaxWait());
		dataSource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());
		dataSource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());
		dataSource.setValidationQuery(dataSourceProperties.getValidationQuery());
		dataSource.setTestWhileIdle(dataSourceProperties.isTestWhileIdle());
		dataSource.setTestOnBorrow(dataSourceProperties.isTestOnBorrow());
		dataSource.setTestOnReturn(dataSourceProperties.isTestOnReturn());
		dataSource.setPoolPreparedStatements(dataSourceProperties.isPoolPreparedStatements());
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(dataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
		try {
			dataSource.setFilters(dataSourceProperties.getFilters());
		} catch (SQLException e) {
			logger.error("druid configuration initialization filter", e);
		}

//		datasource.setConnectionProperties(connectionProperties);

		return dataSource;
	}
}
