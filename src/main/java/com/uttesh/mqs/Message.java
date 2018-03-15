package com.uttesh.mqs;

import java.util.Date;

public class Message {

	private String id;

	private String queueName;

	private Object payload;

	private long visibleOn = new Date().getTime();

	public Message(String id, Object payload, String name) {
		this.id = id;
		this.payload = payload;
		this.queueName = name;
	}

	public String getId() {
		return id;
	}


	public Object getPayload() {
		return payload;
	}

	public long getVisibleOn() {
		return visibleOn;
	}

	public String getQueueName() {
		return queueName;
	}

}
