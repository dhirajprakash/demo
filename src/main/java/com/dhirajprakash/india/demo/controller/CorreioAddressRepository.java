package com.dhirajprakash.india.demo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CorreioAddressRepository extends CrudRepository<CorreioAddress, Integer> {

	@Query("Select ca from CorreioAddress ca")
	List<CorreioAddress> getAddress();

}
