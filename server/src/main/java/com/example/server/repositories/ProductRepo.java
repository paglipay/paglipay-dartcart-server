package com.example.server.repositories;

import java.util.List;

import com.example.server.models.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
  public List<Product> findByCategories(String category);
}