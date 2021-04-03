package com.schnarbiesnmeowers.jenkins.services;

import org.springframework.data.repository.CrudRepository;
import com.schnarbiesnmeowers.jenkins.pojos.Jenkins;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public interface JenkinsRepository extends CrudRepository<Jenkins, Integer>{


}
