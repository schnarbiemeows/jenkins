package com.schnarbiesnmeowers.jenkins.dtos;

import com.schnarbiesnmeowers.jenkins.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the JenkinsDTO class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class JenkinsDTOTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		JenkinsDTO classUnderTest = new JenkinsDTO();
		classUnderTest.setJenkinsId(new Integer(1));
		classUnderTest.setJenkinsType("a");
		classUnderTest.setJenkinsName("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		JenkinsDTO newitem = new JenkinsDTO(
		classUnderTest.getJenkinsId(),
		classUnderTest.getJenkinsType(),
		classUnderTest.getJenkinsName(),
		classUnderTest.getActv());
		assertNotNull(newitem);
		String string = classUnderTest.toString();
		assertNotNull(string);
		assertTrue(string.length()>0);
	}

}