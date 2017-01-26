package com.ramso.restapi;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





//CRUD methods for databases can be found here:
// http://docs.spring.io/spring-data/data-commons/docs/current/api/org/springframework/data/repository/CrudRepository.html

@Repository
interface UserRepository extends JpaRepository<User,Long>{
	//fixed: java.lang.IllegalAccessError: tried to access class com.ramso.restapi.User from class com.sun.proxy.$Proxy63
	//Remember: I declared the interface public. Looks like it shouldn't be.
	
	void delete(User deleted);
	
	List<User> findAll();
	
	Optional<User> findOne(String id);
	
	User save(User saved);

}
