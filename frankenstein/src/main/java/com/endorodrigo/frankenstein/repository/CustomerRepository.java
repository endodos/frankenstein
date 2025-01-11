
package com.endorodrigo.frankenstein.repositories;

import com.endorodrigo.frankenstein.entities.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author EndoRodrigoRodriguez
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    
}
