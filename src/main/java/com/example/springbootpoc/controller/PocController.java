package com.example.springbootpoc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootpoc.model.PocEntity;
import com.example.springbootpoc.service.PocService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping(value = "/poc")
@Api(value = "Spring Boot POC Application")
public class PocController {

	@Autowired
	private PocService service;

	@PostMapping
	@ApiOperation(value = "To Save The Airport Data")
	public PocEntity saveAirportDetails(@Valid @RequestBody PocEntity pocentity) {
		PocEntity result = service.save(pocentity);
		return result;
	}

	@PutMapping
	@ApiOperation(value = "To Update The Airport Data")
	public PocEntity updateAirportDetails(@Valid @RequestBody PocEntity pocentity) {
		PocEntity result = service.update(pocentity);
		return result;
	}

	@GetMapping(value = "/findbycode/{code}")
	@ApiOperation(value = "To get The Airport Data By Airport Code")
	public PocEntity findByAirportCode(@PathVariable String code) {
		PocEntity result = service.findByCode(code);
		return result;
	}

	@GetMapping
	@ApiOperation(value = "To Get All Airport Data")
	public List<PocEntity> getAllAirportDetails() {
		List<PocEntity> list = service.getAllAirportDetails();
		return list;
	}

}
