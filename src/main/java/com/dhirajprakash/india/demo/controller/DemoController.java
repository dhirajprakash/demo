package com.dhirajprakash.india.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	DemoService demoService;

	@GetMapping("/demo/test")
	@CrossOrigin
	public String test() {
		return demoService.calculate();
	}

	@GetMapping("/demo/create")
	@CrossOrigin
	public ResponseEntity<CorreioAddress> create() {
		return demoService.create();
	}

	@GetMapping("/demo/read")
	@CrossOrigin
	public ResponseEntity<?> read() {
		return demoService.read();
	}

}
