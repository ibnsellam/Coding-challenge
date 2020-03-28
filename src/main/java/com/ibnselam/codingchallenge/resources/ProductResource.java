package com.ibnselam.codingchallenge.resources;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibnselam.codingchallenge.model.Product;
import com.ibnselam.codingchallenge.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	//Find all products
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.retreiveAll());
	}
	
	 // Find product by id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
    	Product product = productService.retrieveById(id);
    	if (product == null) {
            return ResponseEntity.badRequest().build();
        }
    	return ResponseEntity.ok(product);
    }
	
	 // Save product
    @PostMapping("/products/create")
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createNewProduct(@Valid @RequestBody Product newProduct) {
    	
    	productService.create(newProduct);
    	return new ResponseEntity<>("Product has been created!", HttpStatus.CREATED);

        
    }

    // update product
    @PutMapping("/products/update/{id}")
    public ResponseEntity<String> updateProduct(@Valid @RequestBody Product product, @PathVariable @Min(1) Long id) {
    	productService.update(product, id);
    	return new ResponseEntity<>("Product has been updated!", HttpStatus.OK);    

    }
    
    //delete product
    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable @Min(1) Long id) {
    	productService.delete(id);
    	return new ResponseEntity<>("Product has been deleted!", HttpStatus.OK);    
    }

}
