package com.wipro.capstone.admin.dto;

public class Customer {

	private Long customerId;
    private String name;
    private String email;
    private String password; // Store the hashed password
    private String subscriptionType; // Weekly/Monthly
    private String contactInfo;
    private String address;
    
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long customerId, String name, String email, String password, String subscriptionType,
			String contactInfo, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.subscriptionType = subscriptionType;
		this.contactInfo = contactInfo;
		this.address = address;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", subscriptionType=" + subscriptionType + ", contactInfo=" + contactInfo + ", address="
				+ address + "]";
	}
        
    
	
}
