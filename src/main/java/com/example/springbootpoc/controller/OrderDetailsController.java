package com.example.springbootpoc.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootpoc.dao.OrderDetailsDao;
import com.example.springbootpoc.model.CustomDate;
import com.example.springbootpoc.model.PocEntity;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsDao orderdetailsdao;
	
	@PostMapping
	public String saveCustomDate(CustomDate cDate) throws ParseException {

		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

		String futuredate = cDate.getFutureDate(); // thanks giving date
		String customdate = cDate.getCustomDate(); //

		Date fDate = sdformat.parse(futuredate);
		Date cusDate = sdformat.parse(customdate);

		if (fDate.before(sdformat.parse(getCurrentDate()))) {
			return "Current Date is Less than today Date";
		}

		if (cusDate.after(sdformat.parse(getCurrentDate()))) {
			return "Current Date is Greater than today Date";
		}

		orderdetailsdao.saveCustomDate(cDate);
		return "Date Saved";
	}
	
	public String getCurrentDate() {
		String cdate="";
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			cdate=dateFormat.format(date).toString();

		}catch (Exception e) {
			e.printStackTrace();
		}
		return cdate;
	}
	
	

}
