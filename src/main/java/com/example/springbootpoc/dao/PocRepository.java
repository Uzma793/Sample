package com.example.springbootpoc.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.example.springbootpoc.model.PocEntity;

@Repository
public interface PocRepository extends PagingAndSortingRepository<PocEntity, Long> {

	public PocEntity getByAirportCode(String code);
}
