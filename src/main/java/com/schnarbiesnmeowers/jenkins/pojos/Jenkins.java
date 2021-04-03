package com.schnarbiesnmeowers.jenkins.pojos;

import com.schnarbiesnmeowers.jenkins.dtos.JenkinsDTO;
import javax.persistence.*;
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
@Entity
@Table(name = "jenkins")
public class Jenkins implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "jenkins_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer jenkinsId;

	/**
	 * "brand type(n = name&!@ g = generic&!@ s = store)" 
	 */
	@Column(name = "jenkins_type")
	private String jenkinsType;

	/**
	 * "name of the brand" 
	 */
	@Column(name = "jenkins_name")
	private String jenkinsName;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public Jenkins() {
		super();
	}

	public Jenkins(Integer jenkinsId, String jenkinsType, String jenkinsName, String actv) {
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
		return "Jenkins [jenkinsId=" + jenkinsId + ", jenkinsType=" + jenkinsType + ", jenkinsName=" + jenkinsName + ", actv=" + actv + "]";
	}

	public static Jenkins fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Jenkins.class );
	}
	public JenkinsDTO toDTO() {
		return new JenkinsDTO(this.getJenkinsId(),this.getJenkinsType(),this.getJenkinsName(),this.getActv());
	}
}
