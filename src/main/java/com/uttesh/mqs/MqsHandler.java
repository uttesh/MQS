package com.uttesh.mqs;

import com.uttesh.mqs.mongodb.MongoService;

public class MqsHandler {

	private MQueue<Message> queue = null;

	public MQueue<Message> getQueue() {
		ConfigParamterLoader configParamterLoader = new ConfigParamterLoader();
		String db = configParamterLoader.getPropertyValue(Constants.MQS_DB_TYPE);
		if (db == null) {
			db = Constants.DatabaseType.MONGO_DB.name();
		}

		switch (Constants.DatabaseType.valueOf(db)) {
		case MONGO_DB:
			queue = new MongoService();
			break;
		}
		queue.init();
		return queue;
	}
}
