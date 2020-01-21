package com.example.springbootpoc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.springbootpoc.dao.OrderDetailsDao;
import com.example.springbootpoc.model.CustomDate;

@RunWith(MockitoJUnitRunner.class)
public class TestOrderDetailsController {
	
	@Mock
	CustomDate customDate;
	@Mock
	OrderDetailsDao dao;
	@Mock
	SimpleDateFormat sdf;
	
	@InjectMocks
	OrderDetailsController controller;
	
	@Test
	public void testCustomDate() throws ParseException {
		Mockito.when(customDate.getFutureDate()).thenReturn("21-12-2019");
		Mockito.when(customDate.getCustomDate()).thenReturn("20-12-2019");
		Mockito.when(sdf.parse(Mockito.anyString())).thenReturn(new Date());
		Mockito.when(sdf.parse(Mockito.anyString())).thenReturn(new Date());
		Mockito.when(dao.saveCustomDate(Mockito.any(CustomDate.class))).thenReturn(true);
		controller.saveCustomDate(customDate);		
	}
	
	

}
