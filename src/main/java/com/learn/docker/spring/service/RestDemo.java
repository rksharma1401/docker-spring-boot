package com.learn.docker.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemo {

	@Value("${message:Hello World}")
	private String message;

	@GetMapping(value = "/getMessage")
	public String getMessage() {
		return message;
	}
}
