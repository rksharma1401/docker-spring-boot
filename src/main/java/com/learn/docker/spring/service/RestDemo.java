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
	
	@Value("${message2:Hello Code}")
	private String message2;

	@GetMapping(value = "/getMessage2")
	public String getMessage2() {
		
		try {
			message2 =message2+ "-" + java.net.InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) { 
			e.printStackTrace();
		}
		return message2;
	}
}
