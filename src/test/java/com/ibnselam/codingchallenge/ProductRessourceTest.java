package com.ibnselam.codingchallenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.ibnselam.codingchallenge.model.Product;
import com.ibnselam.codingchallenge.model.repository.ProductRepository;
import com.ibnselam.codingchallenge.services.ProductService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRessourceTest {
	
    @Autowired
    private ProductService productService;
    
    @MockBean
    private ProductRepository productRepository;

       
     @Test
    public void getAllProductTest() throws Exception {
    	when(productRepository.findAll())
    		.thenReturn(Stream.of(
    				new Product("product 1 title", "product 1 subTitle", 40.0, "product 1 description", 4, "product 1 image"),
    				new Product("product 1 title", "product 1 subTitle", 40.0, "product 1 description", 4, "product 1 image"))
    		.collect(Collectors.toList()));
    	assertEquals(2, productService.retreiveAll().size());
    }
    
    @Test
    public void getProductByIdTest() throws Exception {
    	Long id = 1L;
    	Product product = new Product("product 1 title", "product 1 subTitle", 40.0, "product 1 description", 4, "product 1 image");
    	product.setId(1L);
    	
    	when(productRepository.findById(id))
    	.thenReturn(Stream.of(
    				new Product("product 1 title", "product 1 subTitle", 40.0, "product 1 description", 4, "product 1 image"))
    			.findAny());
    			
    	assertNotNull(productService.retrieveById(id));
    }
    
    @Test
    public void saveProductTest() {
    	Product product = new Product("product 1 title", "product 1 subTitle", 40.0, "product 1 description", 4, "product 1 image");
    	when(productRepository.save(product)).thenReturn(product);
    	
    	assertEquals(product, productService.create(product));
    	
    }
    
    @Test
    public void deleteProductTest() {
    	Product product = new Product("product 1 title", "product 1 subTitle", 40.0, "product 1 description", 4, "product 1 image");
    	product.setId(1L);
    	productService.delete(product.getId());
    	
    	verify(productRepository,times(1)).deleteById(product.getId());
    }
    
   
}
