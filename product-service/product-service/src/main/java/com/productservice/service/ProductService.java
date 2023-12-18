package com.productservice.service;


import com.productservice.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product saveProduct(Product product);
    Product updateProduct(Long id,Product updatedProduct);
    Product getByIdProduct(Long id);
    List<Product> getAllProduct();
    boolean deleteProductById(long id);

    double getProductPrice(Long id);

}
