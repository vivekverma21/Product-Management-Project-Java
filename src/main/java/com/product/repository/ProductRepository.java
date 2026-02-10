package com.product.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.entity.Product;
import java.util.List;

@Repository
public class ProductRepository 
{
	private Session session;
	private Transaction trn;
	
	@Autowired
	public ProductRepository(SessionFactory factory)
	{
		session=factory.openSession();
		trn = session.getTransaction();
	}
	
	public void persistProduct(Product product) 
	{
		trn.begin();
		session.save(product);
		trn.commit();
	}

	public List<Product> findAllProduct() 
	{
		Query<Product> query=session.createQuery("from Product",Product.class);
		List<Product> plist = query.list();
		return plist;
	}

	public Product findById(int pid)
	{
		Product product = session.get(Product.class, pid);
		return product;
	}

	public void removeRecord(Product product) 
	{
		trn.begin();
		session.delete(product);
		trn.commit();
	}

	public void updateRecord(Product productExisting, Product productUpdated) 
	{
		trn.begin();
		productExisting.setName(productUpdated.getName());
		productExisting.setBrand(productUpdated.getBrand());
		productExisting.setPrice(productUpdated.getPrice());
		trn.commit();
		
		
	}

}
