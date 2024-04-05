package com.example.Product.contronllers;


import com.example.Product.models.Product;
import com.example.Product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class ProductContronller {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    List<Product> getAll(){
            return  productService.getProducts();
    }
}
