package com.osetskiy.baby_shop.controller;

import java.io.PrintWriter;
import java.nio.channels.GatheringByteChannel;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.osetskiy.baby_shop.DAO.Service;
import com.osetskiy.baby_shop.model.Category;
import com.osetskiy.baby_shop.model.Product;


/**
 * Handles requests from 1c programm
 */
@Controller

public class Controller_1c {	
	private static final Logger logger = LoggerFactory.getLogger(Controller_1c.class);	
	@Autowired
	private Service<Category> categoryService;
	@Autowired
	private Service<Product> productService;
	
	@RequestMapping(value = "/products", params = "register", method = RequestMethod.POST)	
	public void getProductFrom1c(HttpServletResponse resp, @RequestParam String id, @RequestParam String name,
			@RequestParam String category,@RequestParam String categoryId,@RequestParam String size, @RequestParam String qty,
			@RequestParam String price) throws Exception {
		PrintWriter out = resp.getWriter();					
			
		Product productObj = (Product)productService.getById(id);
		productObj.setId(id);
		productObj.setName(name);				
		productObj.setPrice(new Integer(price));		
		System.out.println("My mapp ::: "+productObj.getSize_qty());
		productObj.getSize_qty().put(size, new Integer(qty));		
		System.out.println("My mapp ::: "+productObj.getSize_qty());
		productService.add(productObj);		
		out.println("done");		
		
		Category categoryObj = (Category)categoryService.getById(categoryId);
		categoryObj.setId(categoryId);
		categoryObj.setName(category);
		productObj.setCategory(categoryObj);				
		System.out.println(categoryObj.getProducts());		
		categoryObj.getProducts().add(productObj);		
		System.out.println(categoryObj.getProducts());	
		
		categoryService.add(categoryObj);
		
	}
	//@RequestMapping(value = "/products", params = "register", method = RequestMethod.POST)
	public void getProductFrom1c_2(HttpServletResponse resp, @ModelAttribute Product prod)	
	{
		
		
	}
	
	
}
