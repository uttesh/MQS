package com.uttesh.mqs.mongodb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.uttesh.mqs.ConfigParamterLoader;
import com.uttesh.mqs.Constants;
import com.uttesh.mqs.Message;
import com.uttesh.mqs.connection.MqsConnectionManager;
import com.uttesh.mqs.domain.MqsMessageEntity;
import com.uttesh.mqs.dto.MqsRequest;
import com.uttesh.mqs.exception.MQSException;

public class MongoQueue {
	Logger logger = Logger.getLogger(MongoQueue.class.getName());
	MqsConnectionManager mqsConnectionManager = new MqsConnectionManager();
	MongoClient mongoClient = (MongoClient) mqsConnectionManager.getConnection();
	ConfigParamterLoader configParamterLoader = new ConfigParamterLoader();

	public boolean add(MqsMessageEntity entity) {
		try {
			MongoCollection<MqsMessageEntity> mongoCollection = getMongoCollection();
			mongoCollection.insertOne(entity);
			return true;
		} catch (Exception e) {
			throw new MQSException(e.getMessage(), e);
		}
	}

	public boolean remove(DBObject document) {
		try {
			remove(document.get("id").toString());
			return true;
		} catch (Exception e) {
			throw new MQSException(e.getMessage(), e);
		}
	}

	public boolean remove(String id) {
		try {
			MongoCollection mongoCollection = getMongoCollection();
			mongoCollection.deleteOne(Filters.eq("id", id));
			return true;
		} catch (Exception e) {
			throw new MQSException(e.getMessage(), e);
		}
	}

	public Message poll(String queueName) {
		Document filter = new Document();
		DBObject query = new BasicDBObject();
		List<BasicDBObject> andQuery = new ArrayList<BasicDBObject>();
		andQuery.add(new BasicDBObject("execution", false));
		andQuery.add(new BasicDBObject("name", queueName));
		andQuery.add(new BasicDBObject("created", new BasicDBObject("$lte", new Date())));
		query.put("$and", andQuery);
		System.out.println("query :: " + query.toString());
		filter.putAll(query.toMap());
		Document _update = new Document();
		_update.put("execution", true);
		_update.put("resetTimestamp", true);
		MongoCollection mongoCollection = getMongoCollection();
		Object payload = mongoCollection.findOneAndUpdate(filter, _update);
		// Message message = new Message(id, queueName, eventTS, name);
		return null;
	}

	public List<Message> peek(MqsRequest mqsRequest) {
		return null;
	}

	public Message pollAndDontRemove(String queueName) {
		return null;
	}

	public long count(String queueName) {
		return 0;
	}

	private MongoCollection getMongoCollection() {
		String collectionName = configParamterLoader.getPropertyValue(Constants.MQS_DB_COLLECTION_NAME);
		if (collectionName == null || collectionName.isEmpty()) {
			collectionName = Constants.MongoDB.DEFAULT_DB_COLLECTION_NAME;
		}
		String dbName = configParamterLoader.getPropertyValue(Constants.MQS_DB_NAME);
		if (dbName == null || dbName.isEmpty()) {
			dbName = Constants.MongoDB.DEFAULT_DB_NAME;
		}
		MongoDatabase mongoDatabase = mongoClient.getDatabase(dbName);
		return mongoDatabase.getCollection(collectionName);
	}

}
