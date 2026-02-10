package com.product.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductService

{
	@Autowired
	private ProductRepository repository;
	
	public void saveProduct(Product product) 
	{
		repository.persistProduct(product);
		
	}

	public java.util.List<Product> getList() {
		
		return repository.findAllProduct();
	}

	public Product getProduct(int pid) 
	{
		Product product = repository.findById(pid);
		return product;
	}

	public void deleteRecord(int pid)
	{
		Product product = repository.findById(pid);
		repository.removeRecord(product);
	}

	public void updateProduct(Product productUpdated) 
	{
		Product productExisting = repository.findById(productUpdated.getPid());
		repository.updateRecord(productExisting, productUpdated);
		
	}

	

}
