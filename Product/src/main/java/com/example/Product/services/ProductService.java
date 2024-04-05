package com.example.Product.services;


import com.example.Product.models.Product;
import com.example.Product.repositories.ProductRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepositoty productRepositoty;

    @Autowired
    public ProductService(ProductRepositoty productRepositoty){
        this.productRepositoty =productRepositoty;
    }
    public List<Product> getProducts(){
        return productRepositoty.findAll();
    }
    public  Product getProductId(Long id){
        Product product = productRepositoty.findById(id).get();
        return product;
    }

}
