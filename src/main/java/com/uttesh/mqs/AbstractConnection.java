package com.uttesh.mqs;

import com.uttesh.mqs.dto.MqsConfigBean;

/**
 * 
 * @author uttesh
 *
 */
public abstract class AbstractConnection implements ConnectionService {

	@Override
	public Object getConnection(MqsConfigBean configBean) {
		throw new NoClassDefFoundError("Not implemented by any database provider");
	}
	
	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}
}
