package com.dhirajprakash.india.demo.controller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CorreioAddressRepository extends CrudRepository<CorreioAddress, Integer> {

	@Query("Select ca from CorreioAddress ca")
	List<CorreioAddress> getAddress();

	@Query("select ca from CorreioAddress ca where ca.id = :id")
	CorreioAddress findByIdManual(@Param("id") Integer id);

}
