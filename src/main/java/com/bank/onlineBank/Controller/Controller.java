package com.bank.onlineBank.Controller;

import java.util.List;

//import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.onlineBank.Entity.NewCustomer;
import com.bank.onlineBank.Service.NewCustomerService;

@RestController
public class Controller {
	 
	@Autowired
	private NewCustomerService obj;
	
	@PostMapping("/addDetail")
	 public String addDetail(@RequestBody NewCustomer data)
	 { 
		System.out.println(data.toString());
	
		Long AccountNumber = obj.addData(data);
		System.out.println(data.toString());
		
		return "Successfully Account Created AccountNumber Is=" + AccountNumber;	 
	 }
	
	@DeleteMapping("/delete/{accountNumber}")
	public String deleteDetail(@PathVariable("accountNumber") Long accountNumber) {
	    this.obj.deleteData(accountNumber);
	    return "Account is Deleted";
	}
	
	
	@GetMapping("/show")
    public List<NewCustomer> getDetail() {
        List<NewCustomer> list = obj.getData();
        System.out.println(list);
        return list;
    }
	
//	@GetMapping("/show/{accountNumber}")
//	public List<NewCustomer> getdetailId(@PathVariable Long accountNumber)
//	{
//   NewCustomer data=obj.getDataId(accountNumber);
//   return (List<NewCustomer>) data; 
//   //only retrun id
////return ResponseEntity.Status(HttpStatus.CREATED).body(detail);
//	}
	
	 @GetMapping("/show/{accountNumber}") // Include the path variable
	    public ResponseEntity<NewCustomer> getDetailId(@PathVariable Long accountNumber) { // Define accountNumber as a parameter
	        NewCustomer detail = obj.getDataId(accountNumber);
	        
	        if (detail != null) {
	            return ResponseEntity.ok(detail); // 200 OK with customer data
	        } else {
	            return ResponseEntity.notFound().build(); // 404 Not Found if customer is not found
	        }
	    }
	 
	 @PostMapping("/deposite")
	    public String  depositeMoney(@RequestBody NewCustomer Money) {
	     
	        return obj.addMoney(Money);
	    }
	 
	 @PostMapping("/withdrawal")
	    public String  withdrawalMoney(@RequestBody NewCustomer Money) {
	     
	        return obj.withdrawalMoney(Money);
	    }
	 
//	 @PostMapping("/transferMoney/{my accountNumber}")
//	 public String transferMoney(@PathVariable Long accountNumber, @RequestBody NewCustomer transfer )
//	 {
//		return obj.transferMoney(accountNumber,transfer);
//		
//		 
//	 }
	 @PostMapping("/transferMoney/{myAccountNumber}")
	    public String transferMoney(@PathVariable Long myAccountNumber, @RequestBody NewCustomer transfer) {
	        return obj.transferMoney(myAccountNumber, transfer);
	    }
	 

	 @PostMapping("/login")
	 public String loging(@RequestBody NewCustomer login)
	 {
		 
		 boolean b=obj.loging(login.getPassword(),login.getUserName());
		 
		 if(b)
		 { 
			 return "user exits";
		 }
		 else {
	            return "not exist";
	        }
		 

	 }
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 






