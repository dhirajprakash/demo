package com.dhirajprakash.india.demo.entity;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class CourseRepository {

	@Autowired
	EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	// public Course save(Course course)-> insert or update

	// public void deleteById(Long id)

}
