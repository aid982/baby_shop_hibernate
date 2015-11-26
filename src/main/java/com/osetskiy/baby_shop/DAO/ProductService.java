package com.osetskiy.baby_shop.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osetskiy.baby_shop.model.Category;
import com.osetskiy.baby_shop.model.Product;

public class ProductService extends Service<Product>{
	
	public List<Product> getList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Product> productList = session.createQuery("from Product").list();
		session.getTransaction().commit();
		session.close();
		return productList;
	}
	
	
	public List<Product> getFeaturedProducts() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Product> productList = session.createQuery("from Product where featured = true").list();
		session.getTransaction().commit();
		session.close();
		return productList;
	}
	
	public Product getById(String id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Product product = (Product) session.get(Product.class, id);
		if (product != null) {
			System.err.println(product.getSize_qty());
		} else {
			product = new Product();
		}
		session.getTransaction().commit();
		session.close();
		return product;
	}
	
	public List<Product> getProductsByCategoryName(String name) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String queryString = "from Product where category.name = :name";		
		System.out.println(queryString);
		Query query = session.createQuery(queryString);		
		query.setString("name", name);
		List<Product> productList = query.list();	
		session.getTransaction().commit();
		session.close();
		return productList;
	}
	
	
}
