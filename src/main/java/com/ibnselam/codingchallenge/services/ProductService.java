package com.ibnselam.codingchallenge.services;

import java.util.List;

import com.ibnselam.codingchallenge.model.Product;

public interface ProductService {

	public List<Product> retreiveAll();
	public Product retrieveById(long id);
	public Product create(Product newProduct);
	public void delete(long id);
	public Product update(Product newProductDetails, long id);
}
