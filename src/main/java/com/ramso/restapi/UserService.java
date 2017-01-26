package com.ramso.restapi;

import java.util.List;

interface UserService {

	 
		
			    UserDTO create(UserDTO user);

			    UserDTO delete(String id);

			    List<UserDTO> findAll();

			    UserDTO findById(String id);

			    UserDTO update(UserDTO user);
}
