package com.ramso.restapi;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ramso.restapi.util.CantReachDatabaseException;
import com.ramso.restapi.util.UserNotFoundException;



/*
 * Implementation of UserService interface for saving objects in the MongoDB
 * 
 * Use of slf4j for method logging
 * 
 */


@Service
final class MySQLUserService implements UserService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MySQLUserService.class);
	
	private final UserRepository repository;
	
	@Autowired
	MySQLUserService(UserRepository repository){
		this.repository = repository;
	}
	
	
	@Override
	public UserDTO create(UserDTO user) {
		LOGGER.info("Creating a new user entry with data: {}", user);
		
		User persisted = User.getBuilder()
				.name(user.getName())
				.credits(user.getCredits())
				//.isAdmin(user.getIsAdmin())
				.build();
		LOGGER.info("After build: {}", persisted);
		//persisted = repository.save(persisted);
        LOGGER.info("Created a new user entry with data: {}", persisted);
		
		return convertToDTO(persisted);
	}

	@Override
	public UserDTO delete(String id) {
		LOGGER.info("Deleting user with id: {}", id);
		User deleted = findUserById(id);
		repository.delete(deleted);
		LOGGER.info("Deleted user with data: {}", deleted);
		
		return convertToDTO(deleted);
	}

	@Override
	public List<UserDTO> findAll() {
		try{
			
		LOGGER.info("Retrieving user list");
		List<User> userlist = repository.findAll();
		LOGGER.info("Retrieving user list");
		return convertToDTOs(userlist);
		
		}catch(Exception e){
				throw new CantReachDatabaseException();
		}
	}

	@Override
	public UserDTO findById(String id) {
		
		LOGGER.info("Finding user with id: {}", id);
		User found = findUserById(id);
		LOGGER.info("Found user with id: {}", id);
		
		return convertToDTO(found);
	}

	@Override
	public UserDTO update(UserDTO user) {
		LOGGER.info("Updating user with new data: {}", user);
		User updated = findUserById(user.getId());
		updated.update(user.getName(), user.getCredits());
		//updated = repository.save(updated);
		LOGGER.info("Updating user: {}", updated);
		
		return convertToDTO(updated);
	}

	 private UserDTO convertToDTO(User model) {
		 	UserDTO dto = new UserDTO();

	        dto.setId(model.getId());
	        dto.setName(model.getName());
	        dto.setCredits(model.getCredits());
	       // dto.setIsAdmin(model.getIsAdmin());

	        return dto;
	    }
	 
	 private List<UserDTO> convertToDTOs(List<User> model){
		 return model.stream().map(u -> convertToDTO(u)).collect(toList());

	 }
	 
	 private User findUserById(String id){
		// Optional<User> result = repository.findOne(id);
		// return result.orElseThrow(() -> new UserNotFoundException(id)); 
		 return null;
	 }
	
}
