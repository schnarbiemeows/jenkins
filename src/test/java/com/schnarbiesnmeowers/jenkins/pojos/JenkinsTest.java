package com.schnarbiesnmeowers.jenkins.pojos;

import com.schnarbiesnmeowers.jenkins.utilities.Randomizer;
import static org.junit.Assert.*;
import java.util.*;
import java.sql.Timestamp;
import org.junit.Test;
import java.math.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * class to test the Jenkins class
 * @author Dylan I. Kessler
 *
 */
@RunWith(SpringRunner.class)
public class JenkinsTest {

	/**
	 * test both constructors, getters and setters, and toString() method
	 */
	@Test
	public void testClass() {
		Jenkins classUnderTest = new Jenkins();
		classUnderTest.setJenkinsId(new Integer(1));
		classUnderTest.setJenkinsType("a");
		classUnderTest.setJenkinsName("a");
		classUnderTest.setActv("a");
		assertTrue(true);
		Jenkins newitem = new Jenkins(
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