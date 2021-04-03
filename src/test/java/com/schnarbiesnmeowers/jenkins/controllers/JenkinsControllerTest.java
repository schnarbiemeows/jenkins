package com.schnarbiesnmeowers.jenkins.controllers;

import static org.junit.Assert.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.math.*;
import java.util.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.schnarbiesnmeowers.jenkins.pojos.Jenkins;
import com.schnarbiesnmeowers.jenkins.dtos.JenkinsDTO;
import com.schnarbiesnmeowers.jenkins.business.JenkinsBusiness;
import com.schnarbiesnmeowers.jenkins.utilities.Randomizer;

/**
 * this class tests the JenkinsController class
 * these tests we want to run in order
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JenkinsControllerTest {

	/**
	 * generate a random port for testing
	 */
	@LocalServerPort
	int randomServerPort;

	/**
	 * create a Mock Business object
	 */
	@Mock
	private JenkinsBusiness jenkinsBusiness;

	/**
     * inject the Mock into the RestTemplate
     */
    @InjectMocks
    private RestTemplate restTemplate = new RestTemplate();

	/**
	 * test creating a new Jenkins
	 * @throws URISyntaxException
	 */
	@Test
	public void testA_CreateJenkins() throws URISyntaxException
	{
	    JenkinsDTO jenkins = generateRandomJenkins();
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		System.out.println(jenkins.toString());
		final String createUrl = "http://localhost:" + randomServerPort + "/jenkins/create";
		URI uri = new URI(createUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<JenkinsDTO> request = new HttpEntity<>(jenkins,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testCreate + " + result.getBody().toString());
		assertEquals(201, result.getStatusCodeValue());
    }

    /**
	 * test getting all Jenkins
	 * @throws URISyntaxException
	 */
	@Test
	public void testB_GetAllJenkins() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		final String baseUrl = "http://localhost:" + randomServerPort + "/jenkins/all";
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test getting a single Jenkins by primary key
	 * @throws URISyntaxException
	 */
	@Test
	public void testC_GetJenkins() throws URISyntaxException
	{
		System.out.println("RANDOM SERVER PORT = " + randomServerPort);
		int num = 1;
		final String baseUrl = "http://localhost:" + randomServerPort + "/jenkins/findById/" + num;
		URI uri = new URI(baseUrl);
		HttpEntity<String> request = new HttpEntity<>(new String());
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}

    /**
	 * test updating a Jenkins
	 * @throws URISyntaxException
	 */
	@Test
	public void testD_UpdateJenkins() throws URISyntaxException
	{
	    JenkinsDTO jenkins = generateRandomJenkins();
		final String updateUrl = "http://localhost:" + randomServerPort + "/jenkins/update";
		URI uri = new URI(updateUrl);
		HttpEntity<JenkinsDTO> request = new HttpEntity<>(jenkins);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		// Verify request succeed
		System.out.println("FINISHED testUpdate + " + result.getBody().toString());
		assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * test deleting a Jenkins
	 * @throws URISyntaxException
	 */
	@Test
	public void testE_DeleteJenkins() throws URISyntaxException
	{
		JenkinsDTO jenkins = generateRandomJenkins();
		int num = 1;
		final String deleteUrl = "http://localhost:" + randomServerPort + "/jenkins/delete/" + num;
		URI uri = new URI(deleteUrl);
		HttpEntity<JenkinsDTO> request = new HttpEntity<>(jenkins);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
		System.out.println("FINISHED testDelete");
		// Verify request succeed
		assertEquals(200, result.getStatusCodeValue());
	}


	public static JenkinsDTO generateRandomJenkins() {
		JenkinsDTO record = new JenkinsDTO();
		record.setJenkinsType(Randomizer.randomString(1));
		record.setJenkinsName(Randomizer.randomString(20));
		record.setActv(Randomizer.randomString(1));
		return record;
	}
}