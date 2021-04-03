package com.schnarbiesnmeowers.jenkins.business;

import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.schnarbiesnmeowers.jenkins.exceptions.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import com.schnarbiesnmeowers.jenkins.dtos.JenkinsDTO;
import com.schnarbiesnmeowers.jenkins.pojos.Jenkins;
import com.schnarbiesnmeowers.jenkins.services.JenkinsRepository;

/**
 * this class retrieves data from the controller class
 * most business logic should be put in this class
 * @author Dylan I. Kessler
 *
 */
@Component
public class JenkinsBusiness {


	/**
	 * get all Jenkins records
	 * @return
	 * @throws Exception
	 */
	public List<JenkinsDTO> getAllJenkins() throws Exception {
	    System.out.println("Inside Mock Business Class");
		List<JenkinsDTO> jenkinsDTO = new ArrayList<JenkinsDTO>();
		return jenkinsDTO;
	}

	/**
	 * get Jenkins by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public JenkinsDTO findJenkinsById(int id) throws Exception {
		return new JenkinsDTO();
	}

	/**
	 * create a new Jenkins
	 * @param data
	 * @return
	 */
	public JenkinsDTO createJenkins(JenkinsDTO data) {
        data.setJenkinsId(1);
        return data;
	}

	/**
	 * update a Jenkins
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public JenkinsDTO updateJenkins(JenkinsDTO data) throws Exception {
		return data;
	}

	/**
	 * delete a Jenkins by primary key
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String deleteJenkins(int id) throws Exception {
		return "Successfully Deleted";
	}

}
