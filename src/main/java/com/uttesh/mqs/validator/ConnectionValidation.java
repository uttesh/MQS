package com.uttesh.mqs.validator;

import java.util.function.Function;

import com.uttesh.mqs.Constants;
import com.uttesh.mqs.dto.ConnectionBean;

public interface ConnectionValidation extends Function<ConnectionBean, Boolean> {

	static ConnectionValidation hostIsNotEmpty() {
        return connectionBean -> connectionBean.getHost() == null || connectionBean.getHost().trim().isEmpty()  ? true : false;
    }
	
	static ConnectionValidation portIsNotDefault() {
        return connectionBean ->   connectionBean.getPort() != Constants.MongoDB.DEFAULT_PORT;
    }
	
	static ConnectionValidation userNameIsNotEmpty() {
        return connectionBean -> connectionBean.getUserName() !=null && !connectionBean.getUserName().isEmpty() ? true : false;
    }
	
	static ConnectionValidation passwordIsNotEmpty() {
        return connectionBean -> connectionBean.getPassword()!=null && !connectionBean.getPassword().isEmpty() ? true : false;
    }
	
	default ConnectionValidation and(ConnectionValidation other) {
        return connectionBean -> this.apply(connectionBean) && other.apply(connectionBean);
    }
	
	default ConnectionValidation or(ConnectionValidation other) {
        return connectionBean -> this.apply(connectionBean) || other.apply(connectionBean);
    }
}
