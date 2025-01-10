
package com.endorodrigo.frankenstein.controllers;

import com.endorodrigo.frankenstein.servicies.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    final private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }
    
    
    @GetMapping("/customers")
    public ResponseEntity getListCustomer(){
        return ResponseEntity.ok(service.findAll());
    }
    
}
