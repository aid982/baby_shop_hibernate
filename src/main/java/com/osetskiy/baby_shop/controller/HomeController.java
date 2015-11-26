package com.osetskiy.baby_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.osetskiy.baby_shop.DAO.CategoryService;
import com.osetskiy.baby_shop.DAO.ProductService;
import com.osetskiy.baby_shop.DAO.Service;
import com.osetskiy.baby_shop.model.Category;
import com.osetskiy.baby_shop.model.Product;

@Controller
@RequestMapping("/")
public class HomeController {	
	@Autowired
	private Service<Category> categoryService;
	@Autowired
	private Service<Product> productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCategories(Model model)	
	{	
		System.out.println("eeeeeeeeeeeeeeeee");
		model.addAttribute("categoryList",categoryService.getList());
		model.addAttribute("productList",productService.getFeaturedProducts());
		return "category/productsList";		
	}

}
