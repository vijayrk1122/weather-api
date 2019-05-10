package com.assignment.weather.configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.assignments.utils.Constants;

@Configuration
@EnableTransactionManagement
public class Config {

	private Logger log = Logger.getLogger(Config.class);

	@Autowired
	private Environment env;

	private Constants constants;

	private void init() throws GeneralSecurityException, IOException {
		if (constants == null) {
			constants = Constants.getInstance();

			constants.init(env.getProperty("server.port"), env.getProperty("driverClassName"), env.getProperty("url"),
					env.getProperty("usernamedb"), env.getProperty("password"), env.getProperty("hibernate.dialect"),
					env.getProperty("spring.datasource.max-wait"), env.getProperty("spring.datasource.max-active"));
		}
	}

	@Bean
	public BasicDataSource basicDataSource() throws GeneralSecurityException, IOException {
		init();
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(Constants.getInstance().getDriverClassName());
		basicDataSource.setUrl(Constants.getInstance().getUrl());
		basicDataSource.setUsername(Constants.getInstance().getUserName());
		basicDataSource.setPassword(Constants.getInstance().getPassword());
		basicDataSource.addConnectionProperty("spring.datasource.max-wait",
				Constants.getInstance().getSpringDatasourceMaxWait());
		basicDataSource.addConnectionProperty("spring.datasource.max-active",
				Constants.getInstance().getSpringDatasourceMaxActive());
		basicDataSource.addConnectionProperty("connection.autoReconnect", "true");
		basicDataSource.addConnectionProperty("connection.autoReconnectForPools", "true");
		basicDataSource.addConnectionProperty("connection.is-connection-validation-required", "true");
		basicDataSource.addConnectionProperty("show_sql", "false");
		
		basicDataSource.addConnectionProperty("MinLimit","0");
		basicDataSource.addConnectionProperty("MaxLimit","120");
		basicDataSource.addConnectionProperty("InitialLimit","1");
		basicDataSource.addConnectionProperty("ConnectionWaitTimeout","120");
		basicDataSource.addConnectionProperty("InactivityTimeout","180");
		basicDataSource.addConnectionProperty("ValidateConnection","true");
		basicDataSource.addConnectionProperty("PropertyCheckInterval","150");
		
		log.error("1. server.port ---> " + Constants.getInstance().getServerPort());
		log.error("2. driverClassName ---> " + Constants.getInstance().getDriverClassName());
		log.error("3. DB url -----> " + Constants.getInstance().getUrl());
		log.error("4. DB username -------> " + Constants.getInstance().getUserName());
		log.error("5. DB password -------> " + Constants.getInstance().getPassword());
		log.error("6. hibernateDialect ---> " + Constants.getInstance().getHibernateDialect());
		log.error("7. springDatasourceMaxWait ---> " + Constants.getInstance().getSpringDatasourceMaxWait());
		log.error("8. springDatasourceMaxActive ---> " + Constants.getInstance().getSpringDatasourceMaxActive());
		return basicDataSource;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws GeneralSecurityException, IOException {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setShowSql(false);
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(basicDataSource());
		entityManagerFactoryBean.setPackagesToScan("com.assignment.weather");
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactoryBean.afterPropertiesSet();
		return entityManagerFactoryBean;
	}
}
