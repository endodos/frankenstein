package com.endorodrigo.frankenstein.controller;

import com.endorodrigo.frankenstein.entity.Customer;
import com.endorodrigo.frankenstein.servicies.CustomerService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Mostrar todos los clientes
    @GetMapping
    public ResponseEntity<List<Customer>> listCustomers() {
        List<Customer> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Guardar un nuevo cliente o actualizar uno existente
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> editCustomer(@RequestBody Customer data) {
        Optional<Customer> findUser = customerService.findById(data.getId());
        if (findUser.isPresent()) {
            findUser.get().setName(data.getName());
            findUser.get().setLastName(data.getLastName());
            findUser.get().setCellNumber(data.getCellNumber());
            findUser.get().setAddress(data.getAddress());
            findUser.get().setStatus(data.isStatus());
            return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(findUser.get()));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un cliente
    @DeleteMapping
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            customerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
