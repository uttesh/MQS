package com.uttesh.mqs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.uttesh.mqs.dto.MqsConfigBean;

public class ConfigParamterLoader {

	Logger logger = Logger.getLogger(ConfigParamterLoader.class.getName());

	private static Properties configProperties = null;

	public void loadConfig() {
		InputStream is = null;
		try {
			if (configProperties == null) {
				configProperties = new Properties();
				is = this.getClass().getResourceAsStream("mqs.properties");
				if (is != null) {
					configProperties.load(is);
				}
			}
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	public MqsConfigBean getConfigBean() {
		MqsConfigBean bean = new MqsConfigBean();
		if (getPropertyValue(Constants.MQS_DB_NAME) != null)
			bean.setDbName(getPropertyValue(Constants.MQS_DB_NAME));
		if (getPropertyValue(Constants.MQS_DB_TYPE) != null)
			bean.setDbType(getPropertyValue(Constants.MQS_DB_TYPE));
		if (getPropertyValue(Constants.MQS_DB_COLLECTION_NAME) != null)
			bean.setCollectionName(getPropertyValue(Constants.MQS_DB_COLLECTION_NAME));
		if (getPropertyValue(Constants.MQS_DB_HOST) != null)
			bean.setHost(getPropertyValue(Constants.MQS_DB_HOST));
		if (getPropertyValue(Constants.MQS_DB_PORT) != null)
			bean.setPort(Integer.parseInt(getPropertyValue(Constants.MQS_DB_PORT)));
		if (getPropertyValue(Constants.MQS_USER_NAME) != null)
			bean.setUsername(getPropertyValue(Constants.MQS_USER_NAME));
		if (getPropertyValue(Constants.MQS_PASSWORD_NAME) != null)
			bean.setPassword(getPropertyValue(Constants.MQS_PASSWORD_NAME));
		return bean;
	}

	public String getPropertyValue(String key) {
		if (configProperties == null) {
			loadConfig();
		}
		String value = configProperties.getProperty(key);
		if (value == null || value.isEmpty()) {
			value = System.getenv(key);
		}
		if (value == null || value.isEmpty()) {
			logger.log(Level.WARNING, key + " : value is not set.");
		}
		return configProperties.getProperty(key);
	}
}
