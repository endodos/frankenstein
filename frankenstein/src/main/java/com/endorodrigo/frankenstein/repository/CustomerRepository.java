
package com.endorodrigo.frankenstein.repository;

import com.endorodrigo.frankenstein.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author EndoRodrigoRodriguez
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    
}
