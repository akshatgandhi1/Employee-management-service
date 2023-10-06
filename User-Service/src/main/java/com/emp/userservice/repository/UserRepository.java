package com.emp.userservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emp.userservice.entity.User;

public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findByUserEmail(String userEmail);

}
