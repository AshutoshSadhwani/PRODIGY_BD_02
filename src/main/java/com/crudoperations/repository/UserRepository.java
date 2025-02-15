package com.crudoperations.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudoperations.model.User;

public interface UserRepository extends JpaRepository<User,UUID> {
	


}
