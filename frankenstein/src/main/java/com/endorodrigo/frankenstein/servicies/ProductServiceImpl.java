
package com.endorodrigo.frankenstein.servicies;

import com.endorodrigo.frankenstein.entity.Product;
import com.endorodrigo.frankenstein.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    
    final private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return  repository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Optional<Product> deleteById(Integer id) {
        Optional<Product> findUser = repository.findById(id);
        if (findUser.isPresent()) {
            repository.deleteById(id);
            return findUser;
        }
        return  Optional.empty();
    }
    

}
