package com.uttesh.mqs.connection;

import com.uttesh.mqs.ConfigParamterLoader;
import com.uttesh.mqs.ConnectionService;
import com.uttesh.mqs.Constants;
import com.uttesh.mqs.dto.MqsConfigBean;
import com.uttesh.mqs.mongodb.MongoConnectionService;
/**
 * 
 * @author uttesh
 *
 */
public class MqsConnectionManager{
	
	ConnectionService connectionService;

	public Object getConnection() {
		ConfigParamterLoader configParamterLoader = new ConfigParamterLoader();
		MqsConfigBean mqsConfigBean = configParamterLoader.getConfigBean();
		System.out.println("Constants.DatabaseType.MONGO_DB :: "+Constants.DatabaseType.MONGO_DB.name());
		System.out.println("mqsConfigBean.getDbType() :: "+mqsConfigBean.getDbType());
		switch (Constants.DatabaseType.valueOf(mqsConfigBean.getDbType())) {
		case MONGO_DB:
			connectionService = new MongoConnectionService();
			return connectionService.getConnection(mqsConfigBean);
		}
		return null;
	}
}
