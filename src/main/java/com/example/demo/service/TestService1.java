package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.MyModel;

@Service
public class TestService1 {

	private TestService2 service2;

	public TestService1(TestService2 service2) {
		this.service2 = service2;
	}

	public MyModel getMessage(MyModel message) {

		return service2.getMessage(message);
	}

}
