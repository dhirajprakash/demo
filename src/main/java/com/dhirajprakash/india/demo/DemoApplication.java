package com.dhirajprakash.india.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dhirajprakash.india.demo.entity.Course;
import com.dhirajprakash.india.demo.entity.CourseRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository repository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Course course = repository.findById(10002L);
		Course course = new Course("Hibernate Course");
		repository.save(course);
		logger.info("course returned" + course.toString());

	}
}
