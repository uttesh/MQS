package com.uttesh.mqs.domain;

import org.bson.Document;

/**
 * 
 * @author uttesh
 *
 */
public class MqsMessageEntity extends Document {


	public String getQueueName() {
		return get("queueName").toString();
	}

	public void setQueueName(String queueName) {
		put("queueName", queueName);
	}

	public Object getPayload() {
		return get("payload");
	}

	public void setPayload(Object payload) {
		put("payload", payload);
	}

	public boolean isPopped() {
		return Boolean.parseBoolean(get("popped").toString());
	}

	public void setPopped(boolean popped) {
		put("popped", popped);
	}

	public long getVisibleOn() {
		return Long.parseLong(get("visibleOn").toString());
	}

	public void setVisibleOn(long visibleOn) {
		put("visibleOn", visibleOn);
	}

	public double getPriority() {
		return Double.parseDouble(get("priority").toString());
	}

	public void setPriority(double priority) {
		put("priority", priority);
	}

	public long getCreatedOn() {
		return Long.parseLong(get("createdOn").toString());
	}

	public void setCreatedOn(long createdOn) {
		put("createdOn", createdOn);
	}

	public String getStatus() {
		return get("status").toString();
	}

	public void setStatus(String status) {
		put("status", status);
	}

	public String get_id() {
		return get("_id").toString();
	}

	public void set_id(String _id) {
		put("_id", _id);
	}

}
