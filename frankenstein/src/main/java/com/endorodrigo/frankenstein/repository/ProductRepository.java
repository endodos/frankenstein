/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.endorodrigo.frankenstein.repository;

import com.endorodrigo.frankenstein.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author EndoRodrigoRodriguez
 */
public interface ProductRepository extends CrudRepository<Product, Integer>{
    
}
