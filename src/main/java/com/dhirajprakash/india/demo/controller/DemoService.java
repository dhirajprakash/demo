package com.dhirajprakash.india.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	private Logger logger = LoggerFactory.getLogger(DemoService.class);

	@Autowired
	CorreioAddressRepository corRep;

	public String calculate() {
		logger.info("calculate called");
		return String.valueOf(2 * 3);
	}

	public ResponseEntity<CorreioAddress> create() {
		logger.info("create called");

		CorreioAddress correioAddress = new CorreioAddress();
		correioAddress.setCep("05364120");
		correioAddress.setCidade("Sao Paulo");
		correioAddress.setComplemento2("Casa 1");
		correioAddress.setEnd("Rua Lima Faria");
		correioAddress.setUf("SP");
		correioAddress.setBairro("Jardim Ivana");
		corRep.save(correioAddress);
		return new ResponseEntity<CorreioAddress>(correioAddress, HttpStatus.OK);
	}

}
