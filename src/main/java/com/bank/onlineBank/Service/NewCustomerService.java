package com.bank.onlineBank.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.onlineBank.Entity.NewCustomer;
import com.bank.onlineBank.Repository.NewCustomerRepo;

@Service
public class NewCustomerService {
	
	@Autowired
	NewCustomerRepo  newCustomerRepo;
	//post
	public Long addData(NewCustomer data) {
		NewCustomer newCustomer = newCustomerRepo.saveAndFlush(data);
		
		return newCustomer.getAccount_number();	
		
	}
//delete
	public void deleteData(Long accountNumber) {
		// TODO Auto-generated method stub
		newCustomerRepo.deleteById(accountNumber);
		
	}
//get
	public List<NewCustomer> getData() {
		// TODO Auto-generated method stub
		List<NewCustomer>list=(List<NewCustomer>)this.newCustomerRepo.findAll();
		return list;
	}
//get
//	public NewCustomer getDataId(Long accountNumber) {
//		
//		NewCustomer detail=newCustomerRepo.findById(accountNumber);
//		return detail;
//	}
//	//get by id
	public NewCustomer getDataId(Long accountNumber) {
        Optional<NewCustomer> optionalDetail = newCustomerRepo.findById(accountNumber);
        return optionalDetail.orElse(null); // Returns the customer if found, null if not found
    }
	public String addMoney(NewCustomer money) {
		// TODO Auto-generated method stub
		if(newCustomerRepo.existsById(money.getAccount_number()))
		{
		Long Amount =newCustomerRepo.getMoney(money.getAccount_number())+money.getAmount();
	 newCustomerRepo.depositeMoney(money.getAccount_number(),Amount);
	 return "Amount deposite successfully";
		}
		else
		{
			return "Account number is not valid";
		}
		
	}
	public String withdrawalMoney(NewCustomer money) {
		// TODO Auto-generated method stub
		if(newCustomerRepo.existsById(money.getAccount_number()))
		{
			
			Long amount=newCustomerRepo.getMoney(money.getAccount_number())-money.getAmount();
			if(amount<=0)
			{
				return "Amount is not sufficient for withdraw your current balace is ="+newCustomerRepo.getMoney(money.getAccount_number());
			}
			
			
	 newCustomerRepo.depositeMoney(money.getAccount_number(), amount);

	 return "Amount deposite successfully withdrawalMoney  Amount="+amount;
		}
		else
		{
			return "Account number is not valid";
		}
		
		
		
	}
	public String transferMoney(Long accountNumber, NewCustomer transfer) {
		
		if(newCustomerRepo.existsById(accountNumber) && newCustomerRepo.existsById(transfer.getAccount_number()) )
		{
			
			Long amountdeducted =newCustomerRepo.getMoney(accountNumber)-transfer.getAmount();
			if(amountdeducted<0)
			{
				return "Amount is not sufficient for transfer your current balace is ="+newCustomerRepo.getMoney(transfer.getAccount_number());
			}
			
			
	 newCustomerRepo.depositeMoney(accountNumber, amountdeducted);
	 Long amountadded=newCustomerRepo.getMoney(transfer.getAccount_number())+transfer.getAmount();
	 newCustomerRepo.depositeMoney(transfer.getAccount_number(), amountadded);


	 return "Amount deposite successfully withdrawalMoney  Amount="+amountdeducted;
		}
		else
		{
			return "Account number is not valid";
		}
		
		
		
	}
//	
//	public boolean isUserExists(String username, String password) {
//		NewCustomer user = newCustomerRepo.findByUsername(username);
//        return user != null && user.getPassword().equals(password);
//    }
	
	public boolean loging(String password, String userName) {
		boolean user=(newCustomerRepo.existsByUserName(userName) && newCustomerRepo.existsByPassword(password));
		return user;
	}
	
}
	
	
	


