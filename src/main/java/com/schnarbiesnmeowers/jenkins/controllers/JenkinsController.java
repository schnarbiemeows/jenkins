package com.schnarbiesnmeowers.jenkins.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.schnarbiesnmeowers.jenkins.business.*;
import com.schnarbiesnmeowers.jenkins.dtos.*;
import com.schnarbiesnmeowers.jenkins.pojos.*;

/**
 * this class is the main REST controller
 * @author Dylan I. Kessler
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path="/jenkins")
public class JenkinsController {

	private static final Logger FILE_LOGGER = LogManager.getLogger("FileAppender");

	/**
	 * JPA Repository handle
	 */
	@Autowired
	private JenkinsBusiness businessService;;

	/**
	 * get all Jenkins records
	 * @return Iterable<Jenkins>
	 */
	@GetMapping(path = "/all")
	public ResponseEntity<List<JenkinsDTO>> getAllJenkins() throws Exception {
		List<JenkinsDTO> jenkins = businessService.getAllJenkins();
		return ResponseEntity.status(HttpStatus.OK).body(jenkins);
	}

	/**
	 * get Jenkins by primary key
	 * @param id
	 * @return Jenkins
	 */
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<JenkinsDTO> findJenkinsById(@PathVariable int id) throws Exception {
		JenkinsDTO results = businessService.findJenkinsById(id);
		return ResponseEntity.status(HttpStatus.OK).body(results);
	}

	/**
	 * create a new Jenkins
	 * @param JenkinsDTO
	 * @return Jenkins
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<JenkinsDTO> createJenkins(@Valid @RequestBody JenkinsDTO data) throws Exception {
		try {
		    JenkinsDTO createdData = businessService.createJenkins(data);
		    return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * update a Jenkins
	 * @param JenkinsDTO
	 * @return Jenkins
	 */
	@PostMapping(path = "/update")
	public ResponseEntity<JenkinsDTO> updateJenkins(@Valid @RequestBody JenkinsDTO data) throws Exception {
		JenkinsDTO updatedData = businessService.updateJenkins(data);
		return ResponseEntity.status(HttpStatus.OK).body(updatedData);
	}

	/**
	 * delete a Jenkins by primary key
	 * @param id
	 */
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<ResponseMessage> deleteJenkins(@PathVariable int id) throws Exception {
		businessService.deleteJenkins(id);
		ResponseMessage rb = new ResponseMessage("successfully deleted");
		return ResponseEntity.status(HttpStatus.OK).body(rb);
	}

}
