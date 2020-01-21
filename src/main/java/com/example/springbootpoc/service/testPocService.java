package com.example.springbootpoc.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.springbootpoc.dao.PocRepository;
import com.example.springbootpoc.model.PocEntity;

@RunWith(MockitoJUnitRunner.class)
public class testPocService {

	@Mock
	PocRepository repository;

	@Mock
	PocEntity pocentity;

	@InjectMocks
	PocService testService;

	@Test
	public void testsaveEntity() {
		Mockito.when(repository.save(Mockito.any(PocEntity.class))).thenReturn(saveEntity());
		testService.save(pocentity);
	}

	private PocEntity saveEntity() {
		PocEntity entity = new PocEntity();
		entity.setAirportName("hssd");
		entity.setAirportCode("jh");
		entity.setCountryName("skmdk");
		entity.setCountryCode("dc");
		return entity;
	}

	@Test
	public void testUpdateEntity() {
		Mockito.when(repository.save(Mockito.any(PocEntity.class))).thenReturn(updateEntity());
		Mockito.when(pocentity.getAirportCode()).thenReturn("IND");
		Mockito.when(repository.getByAirportCode(Mockito.anyString())).thenReturn(updateEntity());
		testService.update(pocentity);
	}

	@Test
	public void testUpdateEntityWhenAirportCodeNull() {
		Mockito.when(repository.save(Mockito.any(PocEntity.class))).thenReturn(updateEntity());
		// Mockito.when(repository.getByAirportCode(Mockito.anyString())).thenReturn(updateEntity());
		testService.update(pocentity);
	}

	private PocEntity updateEntity() {
		PocEntity entity = new PocEntity();
		entity.setId(1);
		entity.setAirportName("hssd");
		entity.setAirportCode("jh");
		entity.setCountryName("skmdk");
		entity.setCountryCode("dc");
		return entity;
	}
	
	@Test
	public void testGetByAirportCode() {
		Mockito.when(repository.getByAirportCode(Mockito.anyString())).thenReturn(saveEntity());
		testService.findByCode("JHJ");
	}
	
	@Test
	public void testGetAllDetails() {
		Mockito.when(repository.findAll()).thenReturn(getEntityList());
		testService.getAllAirportDetails();
	}
	
	private List<PocEntity> getEntityList(){
		List<PocEntity> list = new ArrayList<PocEntity>();
		list.add(saveEntity());
		list.add(updateEntity());
		return list;
		
	}
	
	
	
	
	

}
