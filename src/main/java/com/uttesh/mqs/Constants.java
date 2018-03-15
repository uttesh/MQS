package com.uttesh.mqs;

public interface Constants {

	enum Process {
		IN_QUEUE, IN_PROGRESS, COMPLETED, NOT_STARTED
	};

	enum DatabaseType {
		MONGO_DB
	}

	enum status {
		IN_QUEUE, IN_PROGRESS, COMPLETED
	}

	String MQS_DB_HOST = "MQS_DB_HOST";
	String MQS_DB_PORT = "MQS_DB_PORT";
	String MQS_DB_NAME = "MQS_DB_NAME";
	String MQS_USER_NAME = "MQS_USER_NAME";
	String MQS_PASSWORD_NAME = "MQS_PASSWORD_NAME";
	String MQS_DB_TYPE = "MQS_DB_TYPE";
	String MQS_DB_COLLECTION_NAME = "MQS_DB_COLLECTION_NAME";

	interface MongoDB {
		long DEFAULT_PORT = 27017;
		String DEFAULT_DB_NAME = "msq_queue";
		String DEFAULT_DB_COLLECTION_NAME = "message";
		String DEFAULT_HOST = "localhost";
	}

}
