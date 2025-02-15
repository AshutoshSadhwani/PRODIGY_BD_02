package com.crudoperations.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudoperations.model.User;
import com.crudoperations.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


    // Fetch all users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Find a user by ID
//    Optional<T> is a wrapper class introduced in Java 8 that
//    avoids null values and prevents NullPointerException (NPE).
//    Using Optional<User>, we can handle missing values safely.
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    // Add a new user
    public User createUser(User user) {
        user.setId(null); // Generate a new UUID
        return userRepository.save(user);
    }

    // Update an existing user
    public User update(UUID id, User user) {
      user.setId(id);
      return userRepository.save(user);
    }

    // Delete a user by ID
    public boolean delete(UUID id) {
    	if(userRepository.existsById(id)) {
    		userRepository.deleteById(id);
    		return true;
    	}
        return false;
    }
}
