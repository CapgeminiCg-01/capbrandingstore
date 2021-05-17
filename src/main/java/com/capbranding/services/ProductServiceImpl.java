package com.capbranding.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capbranding.entities.Product;
import com.capbranding.exceptions.ProductNotFoundException;
import com.capbranding.repositories.CategoryRepository;
import com.capbranding.repositories.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired(required = true)
	ProductRepository productRepo;
	@Autowired(required = true)
	CategoryRepository categoryRepo;

	@Override
	public List<Product> viewAllProducts() {
		logger.info("Entered viewAllProducts()");
		List<Product> allProducts = productRepo.findAll();
		if(allProducts.isEmpty()) {
			throw new ProductNotFoundException("No Products Found");
		}

		return allProducts;
	}

	@Override
	public Product addProduct(Product product) {
		logger.info("Entered addProduct()");
		if(product == null)
			throw new ProductNotFoundException("No Products Found");
		else {
			productRepo.save(product);

			return  product;
		}
	}

	@Override
	public Product updateProduct(Product product) {
		logger.info("Entered updatedProducts()");
		if(product == null) {
			throw new ProductNotFoundException("No Products Found");
		}else {
			productRepo.save(product);
			return product;
		}
	}

	@Override
	public Product viewProduct(int id) {
		logger.info("Entered viewProductById()");
		Optional<Product> product = productRepo.findById(id);
		if(!product.isPresent()) {
			throw new ProductNotFoundException("No Products Found");
		}
		return product.get();
	}

	@Override
	public List<Product> viewProductsByCategory(int catId) {
		logger.info("Entered viewProductByCategory()");
		List<Product> list = productRepo.viewAllProductsByCategory(catId);
		if(list.isEmpty()) 
			throw new ProductNotFoundException("No Products Found");
		else
			return list;		

	}

	@Override
	public Product removeProduct(int productId) {
		logger.info("removeProduct()");
		Optional<Product> product = productRepo.findById(productId);
		if(!product.isPresent()) {
			throw new ProductNotFoundException("No Products Found");
		}
		else {
			productRepo.deleteById(productId);
			return product.get();
		}
	}

}