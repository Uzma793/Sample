package com.example.springbootpoc.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.springbootpoc.model.PocEntity;
import com.example.springbootpoc.service.PocService;


@RunWith(MockitoJUnitRunner.class)
public class TestPocController {
	@Mock
	PocService service;
	@Mock
	PocEntity entity;
	@InjectMocks
	PocController controller;
	
	@Test
	public void testSaveAirportDetails() {
		Mockito.when(service.save(Mockito.any(PocEntity.class))).thenReturn(getEntity());
		controller.saveAirportDetails(entity);
	}
	
	private PocEntity getEntity() {		
		PocEntity entity=new PocEntity();
		entity.setAirportCode("jkhszk");
		entity.setAirportName("jhegs");
		entity.setCountryName("kjhszxj");
		
	return entity;		
	}
	
	@Test
	public void testUpdateAirportDetails() {
		Mockito.when(service.update(Mockito.any(PocEntity.class))).thenReturn(getUpdateEntity());
		controller.updateAirportDetails(entity);
	}
	
	private PocEntity getUpdateEntity() {		
		PocEntity entity=new PocEntity();
		entity.setId(1);
		entity.setAirportCode("jkh");
		entity.setAirportName("jhegs");
		entity.setCountryCode("INDDD");
		entity.setCountryName("kjhszxj");
		return entity;		
	}
	
	@Test
	public void testfindByAirportCode() {
		Mockito.when(service.findByCode(Mockito.anyString())).thenReturn(getEntity());
		controller.findByAirportCode("IND");		
	}
	
	@Test
	public void testGetAllAirportDetails() {
		Mockito.when(service.getAllAirportDetails()).thenReturn(testGetAllDetails());
		controller.getAllAirportDetails();		
	}
	private List<PocEntity> testGetAllDetails() {
		List<PocEntity> entity=new ArrayList<PocEntity>();
		entity.add(getEntity());
		entity.add(getUpdateEntity());
		return entity;
		
		
		
	}
	

	

}
