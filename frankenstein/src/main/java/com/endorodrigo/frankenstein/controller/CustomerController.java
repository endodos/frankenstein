
package com.endorodrigo.frankenstein.controllers;

import com.endorodrigo.frankenstein.entities.Customer;
import com.endorodrigo.frankenstein.servicies.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/demo")
public class CustomerController {
    final private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }
    
    
    @GetMapping("/customers")
    public ResponseEntity getListCustomer(){
        return ResponseEntity.ok(service.findAll());
    }
    
    @PostMapping("/crear/custumer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer ){
         return ResponseEntity.status(HttpStatus.CREATED).body(service.save(customer));
    }
    
}
