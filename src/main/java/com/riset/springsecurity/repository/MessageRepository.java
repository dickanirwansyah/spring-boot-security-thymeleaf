package com.riset.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riset.springsecurity.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
