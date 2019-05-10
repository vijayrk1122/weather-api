package com.assignments.utils;

public class Constants {

	private static Constants constants;
	
	String serverPort;
	String driverClassName;
	String url;
	String userName;
	String password;
	String hibernateDialect;
	String springDatasourceMaxWait;
	String springDatasourceMaxActive;
	
	
	private Constants() {
	}

	public static synchronized Constants getInstance() {

		if (constants == null) {
			constants = new Constants();
		}
		return constants;
	}

	public void init(String serverPort, String driverClassName, String url, String userName, String password,
			String hibernateDialect, String springDatasourceMaxWait, String springDatasourceMaxActive) {
		this.serverPort = serverPort;
		this.driverClassName = driverClassName;
		this.url = url;
		this.userName = userName;
		this.password = password;
		this.hibernateDialect = hibernateDialect;
		this.springDatasourceMaxWait = springDatasourceMaxWait;
		this.springDatasourceMaxActive = springDatasourceMaxActive;

	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHibernateDialect() {
		return hibernateDialect;
	}

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public String getSpringDatasourceMaxWait() {
		return springDatasourceMaxWait;
	}

	public void setSpringDatasourceMaxWait(String springDatasourceMaxWait) {
		this.springDatasourceMaxWait = springDatasourceMaxWait;
	}

	public String getSpringDatasourceMaxActive() {
		return springDatasourceMaxActive;
	}

	public void setSpringDatasourceMaxActive(String springDatasourceMaxActive) {
		this.springDatasourceMaxActive = springDatasourceMaxActive;
	}
}
