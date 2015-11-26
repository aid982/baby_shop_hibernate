package com.osetskiy.baby_shop.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.osetskiy.baby_shop.model.Category;
import com.osetskiy.baby_shop.model.Product;

public class CategoryService  extends Service<Category>{	
	public List<Category> getList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Category> category = session.createQuery("from Category").list();
		session.getTransaction().commit();
		session.close();
		return category;
	}
	
	public Category getById(String id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Category category = (Category) session.get(Category.class, id);
		if (category == null) {
			category = new Category();
		}
		// category.getProducts();
		session.getTransaction().commit();
		session.close();
		return category;
	}
	
	

}
