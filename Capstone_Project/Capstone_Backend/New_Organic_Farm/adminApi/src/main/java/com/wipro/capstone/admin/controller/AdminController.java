package com.wipro.capstone.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.capstone.admin.dto.AdminDTO;
import com.wipro.capstone.admin.dto.Customer;
import com.wipro.capstone.admin.dto.FarmPartner;
import com.wipro.capstone.admin.entity.Admin;
import com.wipro.capstone.admin.service.IAdminService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    // Admin CRUD endpoints
    @PostMapping("/createAdmin")
    public AdminDTO createAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.createAdmin(adminDTO);
    }

    @GetMapping("/getAllAdmins")
    public List<AdminDTO> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/getAdminById/{id}")
    public AdminDTO getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/updateAdmin/{id}")
    public AdminDTO updateAdmin(@PathVariable Long id, @RequestBody AdminDTO adminDTO) {
        return adminService.updateAdmin(id, adminDTO);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "Admin with ID: " + id + " deleted successfully.";
    }

    // Customer management endpoints
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @GetMapping("/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return adminService.getCustomerById(id);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomerById(@PathVariable Long id) {
        adminService.deleteCustomerById(id);
        return "Customer with ID: " + id + " deleted successfully.";
    }
    
    @GetMapping("/getAllFarmpPartners")
    public List<FarmPartner> getAllFarmPArtners() {
    	
    	return adminService.getAllFarmPartner();
    }
    
    @GetMapping("/getFarmPartById/{id}")
    public FarmPartner getFarmPartnerById(@PathVariable Long id) {
    	
    	return adminService.getFarmPartnerById(id);
    }
    
    @DeleteMapping("/deleteFarmPartById/{id}")
    public String deleteFarmPartnerById(@PathVariable Long id) {
    	
    	return adminService.deleteFarmPartnerById(id);
    }
    
    @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        Admin admin = adminService.login(email, password);

        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Invalid credentials
        }
    }
    
}
