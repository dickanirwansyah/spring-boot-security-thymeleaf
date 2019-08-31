package com.riset.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riset.springsecurity.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findUsersByEmail(String email);
	
}
