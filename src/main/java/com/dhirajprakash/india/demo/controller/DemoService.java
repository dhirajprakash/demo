package com.dhirajprakash.india.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	private Logger logger = LoggerFactory.getLogger(DemoService.class);

	public String calculate() {
		logger.info("calculate called");
		return String.valueOf(2 * 3);
	}

}
