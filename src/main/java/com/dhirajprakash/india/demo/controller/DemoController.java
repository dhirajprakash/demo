package com.dhirajprakash.india.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;

@RestController
public class DemoController {

	@Autowired
	DemoService demoService;

	@GetMapping("/demo/test2")
	@CrossOrigin
	public String test2(Integer x, Integer y) {
		return String.valueOf(x * y);
	}

	@GetMapping("/demo/test")
	@CrossOrigin
	public String test() {
		return demoService.calculate();
	}

	@GetMapping("/demo/create")
	@CrossOrigin
	public ResponseEntity<?> create() {
		return demoService.create();
	}

	@PostMapping("/demo/create")
	@CrossOrigin
	public ResponseEntity<?> createp(
			@ApiParam(name = "message", value = "Message to send", required = true) @RequestBody CorreioAddress cor) {
		return demoService.create();
	}

	@GetMapping("/demo/read")
	@CrossOrigin
	public ResponseEntity<?> read() {
		return demoService.read();
	}

	@GetMapping("/demo/update")
	@CrossOrigin
	public ResponseEntity<?> update() {
		return demoService.update();
	}

	@GetMapping("/demo/delete")
	@CrossOrigin
	public ResponseEntity<?> delete() {
		return demoService.delete();
	}

	@GetMapping("/demo/em")
	@CrossOrigin
	public ResponseEntity<?> em() {
		return demoService.entityManagerFactoryUsage();
	}

}
