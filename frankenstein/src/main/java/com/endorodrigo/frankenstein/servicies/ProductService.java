
package com.endorodrigo.frankenstein.servicies;

import com.endorodrigo.frankenstein.entity.Customer;
import com.endorodrigo.frankenstein.entity.Product;
import java.util.List;
import java.util.Optional;


public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Integer id);
    Product save(Product product);
    Optional<Product> deleteById(Integer id);
}
