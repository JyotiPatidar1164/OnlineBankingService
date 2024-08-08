package com.bank.onlineBank.Entity;



import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NewCustomer {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "accountNumberGenerator")
	 @GenericGenerator(
	     name = "accountNumberGenerator",
	     strategy = "org.hibernate.id.enhanced.TableGenerator",
	     parameters = {
	         @Parameter(name = "table_name", value = "your_sequence_table"),
	         @Parameter(name = "segment_value", value = "accountNumber"),
	         @Parameter(name = "increment_size", value = "1"),
	         @Parameter(name = "optimizer", value = "pooled"),
	         @Parameter(name = "initial_value", value = "100000000")
	     }
	 )
	@Column(name = "accountNumber")
	 private long account_number;
	// @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Password must contain at least 8 characters including uppercase, lowercase, numbers, and special characters")
	private String password;
	 // @Pattern(regexp = "^\\+91[1-9][0-9]{9}$", message = "Please enter a valid Indian phone number")
    private String phone_number;
	private String email;
    private String address;
  //  @Pattern(regexp = "^[a-zA-Z]+$", message = "Name should only contain alphabetic characters")
    private String userName;
   private String branch;
    private String gender;
    @Column(columnDefinition = "bigint default 0")
    private long amount;


		public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
		
	    public String getBranch() {
	        return branch;
	    }

	    public void setBranch(String branch) {
	        this.branch = branch;
	    }

	    // Getter and Setter for gender
	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }
		
		@Override
		public String toString() {
			return "NewCustomer [password=" + password + ", phone_number=" + phone_number + ", account_number="
					+ account_number + ", email=" + email + ", address=" + address + ", userName=" + userName
					+ ", branch=" + branch + ", Gender=" + gender + ", amount=" + amount + "]";
		}
	 
	   

}
