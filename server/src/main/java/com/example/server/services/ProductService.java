package com.example.server.services;

import java.util.Optional;

import com.example.server.models.Product;

public interface ProductService {
  public Optional<Product> getProductById(int productId);
}
