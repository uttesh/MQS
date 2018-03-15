package com.uttesh.mqs;

import java.util.List;

import com.uttesh.mqs.dto.MqsRequest;
/**
 * 
 * @author uttesh
 *
 */
public interface MQueue<T> {
	
	public void init();
	
	/**
	 * 
	 * @param mqsMessage
	 * @return
	 */
	public boolean add(T mqsMessage);
	
	/**
	 * 
	 * @param mqsMessage
	 * @return
	 */
	public boolean remove(T mqsMessage);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean remove(String id);
	
	/**
	 * 
	 * This method is almost same as remove() method. The only difference between
	 * poll() and remove() is that poll() method returns null if the Queue is empty
	 * 
	 * @param name
	 * @param all
	 * @return
	 */
	public T poll(String queueName);
	
	/**
	 * 
	 * @param queueName
	 * @return
	 */
	public T pollAndDontRemove(String queueName);
	
	/**
	 * This method is almost same as element() method. 
	 * The only difference between peek() and element() is that peek() method returns null if the Queue is empty.
	 * @param queueName
	 * @return
	 */
	public List<T> peek(MqsRequest mqsRequest);
	
	/**
	 * 
	 * @param queueName
	 * @param limit
	 * @return
	 */
	public long count(String queueName);

}
