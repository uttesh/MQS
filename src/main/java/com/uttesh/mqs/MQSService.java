package com.uttesh.mqs;

import java.util.List;

import com.uttesh.mqs.dto.MqsRequest;

public class MQSService {

	MqsHandler mqsHandler;

	public MQSService() {
		mqsHandler = new MqsHandler();
	}

	public boolean add(Message message) {
		return mqsHandler.getQueue().add(message);
	}

	public boolean remove(Message message) {
		return false;
	}

	public boolean remove(String id) {
		return false;
	}

	public Message poll(String queueName) {
		return null;
	}

	public Message pollAndDontRemove(String queueName) {
		return null;
	}

	public List<Message> peek(MqsRequest mqsRequest) {
		return null;
	}

	public long count(String queueName) {
		return 0;
	}

}
