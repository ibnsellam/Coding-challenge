package com.ibnselam.codingchallenge.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ibnselam.codingchallenge.model.Product;
import com.ibnselam.codingchallenge.model.exceptionsHandler.ProductNotFoundException;
import com.ibnselam.codingchallenge.model.repository.ProductRepository;
import com.ibnselam.codingchallenge.services.ProductServiceBridge;

import ch.qos.logback.core.helpers.ThrowableToStringArray;

@Service
public class ProductServiceImp implements ProductServiceBridge{

	@Autowired
	private ProductRepository productRepository;
		
	@Override
	public List<Product> retreiveAll() {
		return (List<Product>) productRepository.findAll();	
	}
	
	@Override
	public Product retrieveById(long id) {
		Optional<Product> product = productRepository.findById(id);

		if (!product.isPresent())
        	throw new ProductNotFoundException("Product id-" + id + " not found");


		return product.get();
	}
	
	@Override
	 public Product create(Product newProduct) {
		 return productRepository.save(newProduct);
	   }
	 
	@Override
	 public void delete(long id) {
	    	productRepository.deleteById(id);
	    
	  }
	 
	@Override
	 public Product update(Product newProductDetails, long id) {
		 
		 return productRepository.findById(id).map(product -> {
			 product.setTitle(newProductDetails.getTitle());
			 product.setSubTitle(newProductDetails.getSubTitle());
			 product.setDescription(newProductDetails.getDescription());
			 product.setPrice(newProductDetails.getPrice());
			 product.setRating(newProductDetails.getRating());
			 product.setImage(newProductDetails.getImage());
	            return productRepository.save(product);
	        }).orElseGet(() -> {
	        	
	        	throw new ProductNotFoundException("Product id-" + id + " not found");
	        });
	        
	  }
	 

}
