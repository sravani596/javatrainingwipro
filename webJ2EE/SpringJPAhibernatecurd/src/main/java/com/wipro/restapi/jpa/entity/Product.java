package com.wipro.restapi.jpa.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Component
@Entity
public class Product {
	@Id
	 private int pid;
	@NotEmpty
	@NotNull
	  private String pname;
	
	@Min(value = 5000)
	@Max(value = 99000)
	   private double price;
	   
	    private LocalDate date;
	   
	    @Email
	    private String SPmail_id;
	    
	    @Pattern(regexp = "[A-Z][a-z]{4,15}" )
	    private String Branch_name;
	  
		
		public Product() {
			super();
		}
		
		
		public Product(int pid,  String pname,double price, LocalDate date,
				String sPmail_id, String branch_name) {
			super();
			this.pid = pid;
			this.pname = pname;
			this.price = price;
			this.date = date;
			SPmail_id = sPmail_id;
			Branch_name = branch_name;
		}

		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public LocalDate getdate() {
			return date;
		}
		public void setdate(LocalDate date) {
			this.date = date;
		}
		  
				public String getSPmail_id() {
					return SPmail_id;
				}
				public void setSPmail_id(String sPmail_id) {
					SPmail_id = sPmail_id;
				}
				public String getBranch_name() {
					return Branch_name;
				}
				public void setBranch_name(String branch_name) {
					Branch_name = branch_name;
				}




				@Override
				public String toString() {
					return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", date=" + date
							+ ", SPmail_id=" + SPmail_id + ", Branch_name=" + Branch_name + "]";
				}
		
		}



