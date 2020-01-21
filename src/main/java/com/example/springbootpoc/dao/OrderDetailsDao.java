package com.example.springbootpoc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootpoc.model.CustomDate;
@Service
public class OrderDetailsDao {
	
	@PersistenceContext
	private EntityManager entityManager;	
	 
	private static final Logger logger = LogManager.getLogger(OrderDetailsDao.class);
	
	@Transactional 
	public boolean saveCustomDate(CustomDate customDate) {
		try {
			String insertquery = "INSERT INTO test.CUSTOM_DATE ( FUTURE_DATE , CUST_DATE ) VALUES ('" + customDate.getFutureDate() + "','" + customDate.getCustomDate() + "');";
			Query customDatesql = entityManager.createNativeQuery(insertquery);
			customDatesql.executeUpdate();
		} catch (ConstraintViolationException cv) {
			logger.info("Duplicate records");
			return false;
		} catch (RollbackException re) {
			logger.info("Store already exists......");
			return false;
		} catch (TransactionSystemException e) {
			// Other SQL Exception
			logger.info("Store already exists......");
			return false;
		} catch (Exception eee) {
			logger.info("DB error while adding records..." + eee.getMessage());
			return false;
		} finally {
			entityManager.close();
		}
		logger.info("Records updated successfully into store table..");
		return true;
	}

}
