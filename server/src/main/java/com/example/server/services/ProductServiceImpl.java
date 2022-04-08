package com.example.server.services;

import java.util.Optional;

import com.example.server.models.Product;
import com.example.server.repositories.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  ProductRepo productRepo;

  @Override
  public Optional<Product> getProductById(int productId) {
    return productRepo.findById(productId);
  }
  
  public Product addProduct(Product product) {
	  return productRepo.save(product);
  }
}
