package com.osetskiy.baby_shop.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osetskiy.baby_shop.model.AbstractEntity;


public abstract class Service <E extends AbstractEntity> {
	@Autowired
	SessionFactory sessionFactory;
	abstract public List<E> getList();
	abstract  public AbstractEntity getById(String id);
	
	public void add(AbstractEntity entity){		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		session.close();
		
	}
	public List<E> getProductsByCategoryName(String categotyName) {
		return null;		
	}
	public List<E> getFeaturedProducts(){
		return null;
	}
	

}
