package com.dhirajprakash.india.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dhirajprakash.india.demo.controller.DemoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	DemoService demoService;

	private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Test
	public void contextLoads() {
		logger.info("test called");
		demoService.calculate();

	}

}
