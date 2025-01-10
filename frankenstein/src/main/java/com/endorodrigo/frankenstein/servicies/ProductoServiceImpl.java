
package com.endorodrigo.frankenstein.servicies;

import com.endorodrigo.frankenstein.entities.Customer;
import com.endorodrigo.frankenstein.repositories.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements CustomerService{
    
    final private CustomerRepository repository;

    public ProductoServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }
    

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return  repository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Optional<Customer> deleteById(Integer id) {
        Optional<Customer> findUser = repository.findById(id);
        if (findUser.isPresent()) {
            repository.deleteById(id);
            return findUser;
        }
        return  Optional.empty();
    }
    
}
