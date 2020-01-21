package com.example.springbootpoc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Poc_Table")
@ApiModel
//@Table(uniqueConstraints={@UniqueConstraint(columnNames={"airportCode"})})--For Multiple columns uniqueness we need to use @uniqueConstraints at class level.
public class PocEntity {
	
	@Id
	@GeneratedValue
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ApiModelProperty(value="Airport Name")
	private String airportName;
	
	@Size(max=3,min=3,message="Airportcode should be 3 digits only")
	@ApiModelProperty(value="Airport Code")
	@Column(unique=true)   // if single coloumn uniqueness use this.
	private String airportCode;
	
	@ApiModelProperty(value="Country Name")
	private String countryName;
	
	@Size(max=3,min=3,message="Countrycode should be 3 digits only")
	@ApiModelProperty(value="Country Code")
	private String countryCode;
	
	
	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
}
	
	