package com.dhirajprakash.india.demo.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "CORREIO_ADDRESS")
public class CorreioAddress {

	@Id
	@Column(name = "ID")
	String id;
	String bairro;
	String cep;
	String cidade;
	String complemento2;
	String end;
	String uf;

}
