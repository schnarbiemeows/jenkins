package com.schnarbiesnmeowers.jenkins.business;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.schnarbiesnmeowers.jenkins.exceptions.ResourceNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.schnarbiesnmeowers.jenkins.dtos.JenkinsDTO;
import com.schnarbiesnmeowers.jenkins.pojos.Jenkins;
import com.schnarbiesnmeowers.jenkins.services.JenkinsRepository;
import java.util.List;
/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Component
public class JenkinsBusiness {

	private static final Logger logger = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private JenkinsRepository service;

	/**
	 * get all Jenkins records
	 * @return
	 * @throws Exception
	 */
	public List<JenkinsDTO> getAllJenkins() throws Exception {
		Iterable<Jenkins> jenkins = service.findAll();
		Iterator<Jenkins> jenkinss = jenkins.iterator();
		List<JenkinsDTO> jenkinsdto = new ArrayList();
		while(jenkinss.hasNext()) {
			Jenkins item = jenkinss.next();
			jenkinsdto.add(item.toDTO());
		}
		return jenkinsdto;
	}

	/**
	 * get Jenkins by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public JenkinsDTO findJenkinsById(int id) throws Exception {
		Optional<Jenkins> jenkinsOptional = service.findById(id);
		if(jenkinsOptional.isPresent()) {
			Jenkins results = jenkinsOptional.get();
			return results.toDTO();
		} else {
			throw new ResourceNotFoundException("id = " + id + " not found");
		}
	}

	/**
	 * create a new Jenkins
	 * @param data
	 * @return
	 */
	public JenkinsDTO createJenkins(JenkinsDTO data) {
		try {
		    Jenkins createdData = data.toEntity();
		    createdData = service.save(createdData);
		    return createdData.toDTO();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Jenkins
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public JenkinsDTO updateJenkins(JenkinsDTO data) throws Exception {
		Optional<Jenkins> jenkinsOptional = service.findById(data.getJenkinsId());
		if(jenkinsOptional.isPresent()) {
		    Jenkins updatedData = data.toEntity();
			updatedData = service.save(updatedData);
			return updatedData.toDTO();
		} else {
			throw new ResourceNotFoundException("id = " + data.getJenkinsId() + " not found");
		}
	}

	/**
	 * delete a Jenkins by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteJenkins(int id) throws Exception {
		Optional<Jenkins> jenkinsOptional = service.findById(id);
		if(jenkinsOptional.isPresent()) {
			service.deleteById(id);
			return "Successfully Deleted";
		} else {
			throw new ResourceNotFoundException("id = " + id + " not found");
		}
	}

}
