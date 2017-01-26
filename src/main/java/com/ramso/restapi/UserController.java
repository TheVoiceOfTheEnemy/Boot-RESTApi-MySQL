package com.ramso.restapi;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/users/")
final class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private final UserService service;
	
	@Autowired
	UserController(UserService service){
		this.service = service;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	UserDTO create(@RequestBody @Valid UserDTO newEntry){
		LOGGER.info("Creating a new user entry with information: {}", newEntry);
		
		UserDTO created = service.create(newEntry);
		
		LOGGER.info("Created a new user with information: {}", created);
		
		return newEntry;
		
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	UserDTO delete(@PathVariable("id") String id){
		LOGGER.info("Deleting user with id: {}", id);
		
		UserDTO deleted = service.delete(id);
		
		LOGGER.info("Deleted user: {}", deleted);
		
		return deleted;
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	UserDTO findById(@PathVariable("id") String id){
		LOGGER.info("Looking for user with id: {}", id);
		
		UserDTO found = service.findById(id);
		LOGGER.info("Found user: {}", found);
		
		return found;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.FOUND)
	List<UserDTO> findAll(){
		LOGGER.info("Retrieving user list");

			List<UserDTO> userlist =  service.findAll();
		
		LOGGER.info("Retrieved userlist contains {} users", userlist.size());
		
		return userlist;
		
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	UserDTO update(@RequestBody @Valid UserDTO newEntry){
		LOGGER.info("Updating user entry with information: {}", newEntry);
		
		UserDTO updated = service.update(newEntry);
		
		LOGGER.info("Updated User information: {}", updated);
		
		return updated;
		
	}
	
}
