package com.productservice.service.implementation;


import com.productservice.entity.Product;
import com.productservice.repository.ProductRepository;
import com.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        return null;
    }

    @Override
    public Product getByIdProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with  id : " + id));
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public boolean deleteProductById(long id) {
        boolean ans = false;
        productRepository.deleteById(id);
        ans = true;
        return ans;
    }


    @Override
    public double getProductPrice(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return (product != null) ? product.getPrice() : 0.0;
    }

}



