package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.product.entity.Product;
import com.product.service.ProductService;

@Controller
public class ProductController

{
	@Autowired
	private ProductService service;
	
	@GetMapping("/insertForm")
	public String getInsertForm()
	{
		return "insert-form";
	}
	
	@PostMapping("/insertProduct")
	public String insertProductRecord(Product product)
	{
		//Call method of service and product object to that method
	service.saveProduct(product);
		return "insert-success";
	}
	
	@GetMapping("/productList")
	public ModelAndView getProductList()
	{
		List<Product> products = service.getList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("product-list");
		modelAndView.addObject("productList", products);
		return modelAndView;
	}
	
	@GetMapping("/searchForm")
	public String getSearchForm()
	{
		return "search-form";
	}
	
	@GetMapping("/searchRecord")
	public ModelAndView getSearchRecord(int pid)
	{
		ModelAndView modelAndView = new ModelAndView();
		Product product = service.getProduct(pid);
		if (product == null) 
		{
	        modelAndView.setViewName("search-form");
	        modelAndView.addObject("msg", "No product found with ID: " + pid);
	        return modelAndView;
		}
		modelAndView.addObject("product", product);
		modelAndView.setViewName("show-record");
		return modelAndView;
	}
	
	@GetMapping("/deleteForm")
	public String getDeleteForm()
	{
		return "delete-form";
	}
	
	@GetMapping("/confirmDelete")
	public ModelAndView getRecordToDelete(int pid)
	{
		ModelAndView modelAndView = new ModelAndView();
		Product product = service.getProduct(pid);
		if (product == null) 
		{
	        modelAndView.setViewName("delete-form");
	        modelAndView.addObject("msg", "No product found with ID: " + pid);
	        return modelAndView;
		}
		modelAndView.addObject("product", product);
		modelAndView.setViewName("confirm-delete");
		return modelAndView;
	}
	
	@GetMapping("/deleteRecord")
	public String deleteRecord(int pid)
	{
		service.deleteRecord(pid);
		return "delete-success";
	}
	
	@GetMapping("/editForm")
	public String getEditForm()
	{
		return "edit-form";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView getRecordToUpdate(int pid)
	{
		ModelAndView modelAndView = new ModelAndView();
		Product product = service.getProduct(pid);
		if (product == null) 
		{
	        modelAndView.setViewName("delete-form");
	        modelAndView.addObject("msg", "Product does not exit with ID: " + pid);
	        modelAndView.addObject("pid", pid);
	        return modelAndView;
		}
		modelAndView.addObject("product", product);
		modelAndView.setViewName("update-record-form");
		return modelAndView;
	}
	
	@PostMapping("/updateRecord")
	public String updateRecord(Product productUpdated, Model model)
	{
		service.updateProduct(productUpdated);
		model.addAttribute("pid", productUpdated.getPid());
		return "update-success";
	}
	
 
}
