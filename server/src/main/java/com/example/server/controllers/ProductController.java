package com.example.server.controllers;

import com.example.server.models.Product;
//import com.example.server.models.Product;
import com.example.server.services.ProductServiceImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ProductController {

  @Autowired
  private ProductServiceImpl ps;

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
    Optional<Product> p = ps.getProductById(Integer.parseInt(id));
    return p.isPresent()
      ? new ResponseEntity<Product>(p.get(), HttpStatus.OK)
      : new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/products")
  @ResponseBody
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {

    // return ps.addProduct(product);
    return ResponseEntity.ok().body(ps.addProduct(product));
  }
  //  @PostMapping("/products")
  //  @ResponseBody
  //  public Product addProduct(@RequestBody Product product) {
  //	  return ps.addProduct(product);
  //  }

  // @GetMapping("/products/{id}")
  // @ResponseBody
  // public ResponseEntity<String> getProductById(@PathVariable("id") String id) {
  // 		return new ResponseEntity<String>("HI " + id, HttpStatus.OK);
  //  }
}
