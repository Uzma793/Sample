package com.example.springbootpoc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.slf4j.Logger;
//import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootpoc.dao.PocRepository;
import com.example.springbootpoc.model.PocEntity;



@Service
public class PocService {
	
	private static Logger logger = LoggerFactory.getLogger(PocService.class);

	@Autowired
	private PocRepository repository;

	public PocEntity save(PocEntity entity) {
		PocEntity result=null;
		try {
		 result = repository.save(entity);
		}catch(Exception e) {
		logger.info(e.toString());
	}
		return result;
	}

	public PocEntity update(PocEntity entity) {
		PocEntity result = null;
		PocEntity recordCheck = repository.getByAirportCode(entity.getAirportCode());
		if (recordCheck != null) {
			entity.setId(recordCheck.getId()); 
			result = repository.save(entity);
		}
		return result;
	}

	public PocEntity findByCode(String code) {
		PocEntity recordcode = repository.getByAirportCode(code);
		return recordcode;
	}

	public List<PocEntity> getAllAirportDetails() {
		List<PocEntity> list = (List<PocEntity>) repository.findAll();
		return list;
	}

}
