package org.springboot.microservices.learn.microservices.repository;

import org.springboot.microservices.learn.microservices.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
}
