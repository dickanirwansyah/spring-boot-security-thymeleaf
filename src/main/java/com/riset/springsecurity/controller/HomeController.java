package com.riset.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.riset.springsecurity.entity.Message;
import com.riset.springsecurity.repository.MessageRepository;

@Controller
public class HomeController {

	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping(value = "/home")
	public String getHome(Model model) {
		model.addAttribute("msgs", messageRepository.findAll());
		return "userHome";
	}
	
	@PostMapping(value = "/message")
	public String getMessage(Message message) {
		messageRepository.save(message);
		return "redirect:/home";
	}
}
