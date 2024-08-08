package com.bank.onlineBank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.bank.onlineBank.Entity.NewCustomer;

import jakarta.transaction.Transactional;


public interface NewCustomerRepo extends JpaRepository<NewCustomer,Long> {

	 @Modifying
	    @Transactional
	    @Query(nativeQuery = true, value = "UPDATE new_customer SET amount =?2 WHERE account_number = ?1")
	    void depositeMoney(long accountNumber, long amount);
	 
	 
	 @Query(nativeQuery = true, value = "select amount from new_customer where account_number=:accountNumber")
	    Long getMoney(long accountNumber);


	  




			boolean existsByUserName(String userName);


			boolean existsByPassword(String password);
		

	 
	 

	

	
	 
	 
	 
	 
	 
	}
	
	


