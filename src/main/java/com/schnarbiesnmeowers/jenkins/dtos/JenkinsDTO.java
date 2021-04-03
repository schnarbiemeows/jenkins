package com.schnarbiesnmeowers.jenkins.dtos;

import com.schnarbiesnmeowers.jenkins.pojos.Jenkins;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public class JenkinsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer jenkinsId;

	/**
	 * "brand type(n = name&!@ g = generic&!@ s = store)" 
	 */
	private String jenkinsType;

	/**
	 * "name of the brand" 
	 */
	private String jenkinsName;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public JenkinsDTO() {
		super();
	}

	public JenkinsDTO(Integer jenkinsId, String jenkinsType, String jenkinsName, String actv) {
		super();
		this.jenkinsId = jenkinsId;
		this.jenkinsType = jenkinsType;
		this.jenkinsName = jenkinsName;
		this.actv = actv;
	}

	public Integer getJenkinsId() {
		return jenkinsId;
	}

	public void setJenkinsId(Integer jenkinsId) {
		this.jenkinsId=jenkinsId;
	}

	public String getJenkinsType() {
		return jenkinsType;
	}

	public void setJenkinsType(String jenkinsType) {
		this.jenkinsType=jenkinsType;
	}

	public String getJenkinsName() {
		return jenkinsName;
	}

	public void setJenkinsName(String jenkinsName) {
		this.jenkinsName=jenkinsName;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "JenkinsDTO [jenkinsId=" + jenkinsId + ", jenkinsType=" + jenkinsType + ", jenkinsName=" + jenkinsName + ", actv=" + actv + "]";
	}

	public static JenkinsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, JenkinsDTO.class );
	}
	public Jenkins toEntity() {
		return new Jenkins(this.getJenkinsId(),this.getJenkinsType(),this.getJenkinsName(),this.getActv());
	}
}
