package com.ibnselam.codingchallenge.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibnselam.codingchallenge.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
}
