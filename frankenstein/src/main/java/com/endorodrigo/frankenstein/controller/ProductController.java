
package com.endorodrigo.frankenstein.controller;

import com.endorodrigo.frankenstein.dto.ApiResponse;
import com.endorodrigo.frankenstein.entity.Product;
import com.endorodrigo.frankenstein.servicies.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> listCustomers() {
        List<Product> customers = productService.findAll();
        ApiResponse<List<Product>> response = new ApiResponse<>(
                "success",
                "Clientes obtenidos correctamente.",
                customers
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> saveCustomer(@RequestBody Product customer) {
        Product savedCustomer = productService.save(customer);
        ApiResponse<Product> response = new ApiResponse<>(
                "success",
                "Cliente guardado correctamente.",
                savedCustomer
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Product>> editCustomer(@RequestBody Product data) {
        Optional<Product> findUser = productService.findById(data.getId());
        if (findUser.isPresent()) {
            findUser.get().setName(data.getName());
            findUser.get().setPrice(data.getPrice());
            findUser.get().setDescription(data.getDescription());
            Product updatedCustomer = productService.save(findUser.get());
            ApiResponse<Product> response = new ApiResponse<>(
                    "success",
                    "Cliente actualizado correctamente.",
                    updatedCustomer
            );
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            ApiResponse<Product> response = new ApiResponse<>(
                    "error",
                    "Cliente no encontrado.",
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> deleteCustomer(@PathVariable("id") Integer id) {
        Optional<Product> customer = productService.findById(id);
        if (customer.isPresent()) {
            productService.deleteById(id);
            ApiResponse<Product> response = new ApiResponse<>(
                    "success",
                    "Cliente eliminado correctamente.",
                    null
            );
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
        } else {
            ApiResponse<Product> response = new ApiResponse<>(
                    "error",
                    "Cliente no encontrado.",
                    null
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
