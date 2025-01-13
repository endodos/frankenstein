
package com.endorodrigo.frankenstein.servicies;

import com.endorodrigo.frankenstein.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(Integer id);
    Customer save(Customer product);
    Optional<Customer> deleteById(Integer id);
    
}
