package com.endorodrigo.frankenstein.controller;

import com.endorodrigo.frankenstein.dto.ApiResponse;
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

    @GetMapping
    public ResponseEntity<ApiResponse<List<Customer>>> listCustomers() {
        List<Customer> customers = customerService.findAll();
        ApiResponse<List<Customer>> response = new ApiResponse<>(
                "success",
                "Clientes obtenidos correctamente.",
                customers
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Customer>> saveCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        ApiResponse<Customer> response = new ApiResponse<>(
                "success",
                "Cliente guardado correctamente.",
                savedCustomer
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Customer>> editCustomer(@RequestBody Customer data) {
        Optional<Customer> findUser = customerService.findById(data.getId());
        if (findUser.isPresent()) {
            findUser.get().setName(data.getName());
            findUser.get().setLastName(data.getLastName());
            findUser.get().setCellNumber(data.getCellNumber());
            findUser.get().setAddress(data.getAddress());
            findUser.get().setStatus(data.isStatus());
            Customer updatedCustomer = customerService.save(findUser.get());
            ApiResponse<Customer> response = new ApiResponse<>(
                    "success",
                    "Cliente actualizado correctamente.",
                    updatedCustomer
            );
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            ApiResponse<Customer> response = new ApiResponse<>(
                    "error",
                    "Cliente no encontrado.",
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Customer>> deleteCustomer(@PathVariable("id") Integer id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            customerService.deleteById(id);
            ApiResponse<Customer> response = new ApiResponse<>(
                    "success",
                    "Cliente eliminado correctamente.",
                    null
            );
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } else {
            ApiResponse<Customer> response = new ApiResponse<>(
                    "error",
                    "Cliente no encontrado.",
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
