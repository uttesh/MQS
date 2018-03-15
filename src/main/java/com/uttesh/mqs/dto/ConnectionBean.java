package com.uttesh.mqs.dto;

import com.uttesh.mqs.Constants;

public class ConnectionBean {

	String host=Constants.MongoDB.DEFAULT_HOST;
	long port = Constants.MongoDB.DEFAULT_PORT;
	String userName = "";
	String password = "";
	String dataBaseName="mqs";
	
	public ConnectionBean(String host, int port, String userName, String password, String dataBaseName) {
		super();
		this.host = host;
		this.port = port;
		this.userName = userName;
		this.password = password;
		this.dataBaseName = dataBaseName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public long getPort() {
		return port;
	}

	public void setPort(long port) {
		this.port = port;
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

	public String getDataBaseName() {
		return dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
	
	

}
