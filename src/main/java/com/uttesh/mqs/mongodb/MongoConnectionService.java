package com.uttesh.mqs.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.uttesh.mqs.AbstractConnection;
import com.uttesh.mqs.dto.ConnectionBean;
import com.uttesh.mqs.dto.MqsConfigBean;
import com.uttesh.mqs.validator.ConnectionValidation;

public class MongoConnectionService extends AbstractConnection {

	public static MongoClient mongoClient = null;

	/**
	 * Get the mongodb client
	 */
	@Override
	public MongoClient getConnection(MqsConfigBean mqsConfigBean) {
		if (mongoClient == null) {
			ConnectionBean connectionBean = new ConnectionBean(mqsConfigBean.getHost(), mqsConfigBean.getPort(),
					mqsConfigBean.getUsername(), mqsConfigBean.getPassword(), mqsConfigBean.getDbName());
			final ConnectionValidation hostPortValidation = ConnectionValidation.hostIsNotEmpty()
					.and(ConnectionValidation.portIsNotDefault());
			final ConnectionValidation userNamePasswordValidation = ConnectionValidation.userNameIsNotEmpty()
					.and(ConnectionValidation.passwordIsNotEmpty());
			if (hostPortValidation.apply(connectionBean) && userNamePasswordValidation.apply(connectionBean)) {
				ServerAddress serverAddress = new ServerAddress(mqsConfigBean.getHost(), mqsConfigBean.getPort());
				MongoCredential credential = MongoCredential.createCredential(mqsConfigBean.getUsername(),
						mqsConfigBean.getDbName(), mqsConfigBean.getPassword().toCharArray());
				MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().build();
				mongoClient = new MongoClient(serverAddress, credential, mongoClientOptions);
			} else {
				
				if (ConnectionValidation.hostIsNotEmpty().apply(connectionBean)) {
					return new MongoClient(mqsConfigBean.getHost(), mqsConfigBean.getPort());
				}
				return getDefaultConnection();
			}
		}
		return mongoClient;
	}

	// connects to default host and port i.e 127.0.0.1:27017
	private MongoClient getDefaultConnection() {
		this.mongoClient = new MongoClient();
		return this.mongoClient;
	}

	public Object getConnection(String host, int port) {
		ServerAddress serverAddress = new ServerAddress(host, port);
		mongoClient = new MongoClient(serverAddress);
		return mongoClient;
	}

	@Override
	public boolean getStatus() {
		return false;
	}

}
