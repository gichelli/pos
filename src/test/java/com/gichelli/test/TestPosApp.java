package com.gichelli.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = PosApplicationTests.class)

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class, WebAppContext.class})
@WebAppConfiguration
public class TestPosApp {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testEmployee() throws Exception {
		System.out.println("here");
		mockMvc.perform(get("/employees")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				//.andExpect(jsonPath("$.employee_id").value("1"))
				.andExpect(jsonPath("$.[0].firstName").value("Gichelli")).andExpect(jsonPath("$.[0].lastName").value("Munoz"))
				.andExpect(jsonPath("$.[0].streetName").value("ceylan")).andExpect(jsonPath("$.[0].streetNumber").value("6395"));
				//.andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").value(3000));

		System.out.println("here2");
	}



}
