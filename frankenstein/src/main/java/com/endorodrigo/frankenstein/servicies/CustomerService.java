/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.endorodrigo.frankenstein.servicies;

import com.endorodrigo.frankenstein.entities.Customer;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author EndoRodrigoRodriguez
 */
public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(Integer id);
    Customer save(Customer product);
    Optional<Customer> deleteById(Integer id);
    
}
