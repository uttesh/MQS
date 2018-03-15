package com.uttesh.mqs.mongodb;

import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.uttesh.mqs.Constants;
import com.uttesh.mqs.MQueue;
import com.uttesh.mqs.Message;
import com.uttesh.mqs.domain.MqsMessageEntity;
import com.uttesh.mqs.dto.MqsRequest;

public class MongoService implements MQueue<Message> {

	MongoQueue mongoQueue;

	@Override
	public void init() {
		if (mongoQueue == null) {
			mongoQueue = new MongoQueue();
		}
	}

	@Override
	public boolean add(Message message) {
		MqsMessageEntity messageEntity = new MqsMessageEntity();
		if (message.getId() != null) {
			messageEntity.set_id(message.getId());
		}
		messageEntity.setQueueName(message.getQueueName());
		messageEntity.setPayload(message.getPayload());
		if (message.getVisibleOn() != 0) {
			messageEntity.setVisibleOn(message.getVisibleOn());
		} else {
			messageEntity.setVisibleOn(new Date().getTime());
		}

		messageEntity.setCreatedOn(new Date().getTime());
		messageEntity.setPopped(false);
		messageEntity.setPriority(0.0);
		messageEntity.setStatus(Constants.status.IN_QUEUE.name().toUpperCase());
		return this.mongoQueue.add(messageEntity);
	}

	@Override
	public boolean remove(Message message) {
		return false;
	}

	@Override
	public boolean remove(String id) {
		return false;
	}

	@Override
	public Message poll(String queueName) {
		return null;
	}

	@Override
	public Message pollAndDontRemove(String queueName) {
		return null;
	}

	@Override
	public List<Message> peek(MqsRequest mqsRequest) {
		return null;
	}

	@Override
	public long count(String queueName) {
		return 0;
	}


}
