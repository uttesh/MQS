package com.uttesh.mqs.dto;

/**
 * 
 * @author uttesh
 *
 */
public class MqsRequest {

	String QueueName;
	int limit;
	String payLoadQuery;

	public String getQueueName() {
		return QueueName;
	}

	public void setQueueName(String queueName) {
		QueueName = queueName;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getPayLoadQuery() {
		return payLoadQuery;
	}

	public void setPayLoadQuery(String payLoadQuery) {
		this.payLoadQuery = payLoadQuery;
	}

}
