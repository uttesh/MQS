package com.uttesh.mqs;

import com.uttesh.mqs.dto.MqsConfigBean;

/**
 * 
 * @author uttesh
 *
 */
public interface ConnectionService {
	
	public Object getConnection(MqsConfigBean configBean );
	
    public boolean getStatus();
    
}
