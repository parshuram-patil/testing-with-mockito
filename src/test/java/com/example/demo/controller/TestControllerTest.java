package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.example.demo.model.MyModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class TestControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testGet() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/get")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
	}

	@Test
	public void testPost() throws Exception {

		MyModel message = new MyModel();
		message.setMessage("Hello Post");

		mvc.perform(MockMvcRequestBuilders.post("/post").content(objectMapper.writeValueAsString(message))
				.contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers.print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.message", CoreMatchers.is("Hello Post"))).andExpect(status().isOk());
	}
	
	@Test
	public void testPostUsingService() throws Exception {

		MyModel message = new MyModel();
		message.setMessage("Hello Post");

		mvc.perform(MockMvcRequestBuilders.post("/post/service").content(objectMapper.writeValueAsString(message))
				.contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers.print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.message", CoreMatchers.is("Hello Post"))).andExpect(status().isOk());
	}

}
