package com.dhirajprakash.india.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

	@Autowired
	CorreioAddress correioAddress;

	@Autowired
	EntityManager em;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public String calculate() {
		logger.info("calculate called");
		return String.valueOf(2 * 3);
	}

	public ResponseEntity<?> create() {
		logger.info("create called");
		CorreioAddress correioAddress = new CorreioAddress();
		correioAddress.setCep("05364120");
		correioAddress.setCidade("Sao Paulo");
		correioAddress.setComplemento2("Casa 1");
		correioAddress.setEnd("Rua Lima Faria");
		correioAddress.setUf("SP");
		correioAddress.setBairro("Jardim Ivana");
		corRep.save(correioAddress);
		return new ResponseEntity(corRep.getAddress(), HttpStatus.OK);
	}

	public ResponseEntity<?> read() {
		logger.info("read called");

		return new ResponseEntity(corRep.getAddress(), HttpStatus.OK);
	}

	public ResponseEntity<?> update() {
		logger.info("update called");
		correioAddress = corRep.findByIdManual(3);
		if (correioAddress != null) {
			correioAddress.setBairro("JARDIM");
			corRep.save(correioAddress);
		}
		return new ResponseEntity(corRep.getAddress(), HttpStatus.OK);
	}

	public ResponseEntity<?> delete() {
		logger.info("delete called");
		correioAddress = corRep.findByIdManual(3);
		if (correioAddress != null)
			corRep.delete(correioAddress);
		return new ResponseEntity(corRep.getAddress(), HttpStatus.OK);
	}

	public ResponseEntity<?> entityManagerUsage() {
		logger.info("Entity Manager called");
		Query corAddQuery = em.createNativeQuery("Select bairro,end from Correio_Address");
		List<?> lst = corAddQuery.getResultList();
		return new ResponseEntity(lst, HttpStatus.OK);
	}

	public ResponseEntity<?> entityManagerUsage2() {
		logger.info("Entity Manager Factory called");
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<CorreioAddress> criteria = builder.createQuery(CorreioAddress.class);
		Root<CorreioAddress> contactRoot = criteria.from(CorreioAddress.class);
		criteria.select(contactRoot);
		return new ResponseEntity(session.createQuery(criteria).getResultList(), HttpStatus.OK);
	}

}
