package com.schnarbiesnmeowers.jenkins.pojos;

import java.io.Serializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResponseMessage implements Serializable {

	private static final Logger FILE_LOGGER = LogManager.getLogger("FileAppender");
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseMessage(String message) {
		super();
		this.message = message;
	}
}