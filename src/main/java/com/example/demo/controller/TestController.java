package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MyModel;
import com.example.demo.service.TestService1;
import com.example.demo.service.TestService2;

@RestController
public class TestController {

	private TestService1 service1;
	private TestService2 service2;

	public TestController(TestService1 service1, TestService2 service2) {

		this.service1 = service1;
		this.service2 = service2;

	}

	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public String get() {

		return "{\"message\":\"Hello Get\"}";
	}

	@PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
	public MyModel post(@RequestBody MyModel message) {

		return message;
	}

	@PostMapping(value = "/post/service", produces = MediaType.APPLICATION_JSON_VALUE)
	public MyModel postUsingService(@RequestBody MyModel message) {

		return service2.getMessage(message);
	}

	@PostMapping(value = "/post/nested/service", produces = MediaType.APPLICATION_JSON_VALUE)
	public MyModel postUsingNestedService(@RequestBody MyModel message) {

		return service1.getMessage(message);
	}

}
