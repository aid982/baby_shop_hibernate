package com.osetskiy.baby_shop.model;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Product  extends AbstractEntity{
	@Id	
	private String id;
	private String name;
	private int price;
	private Boolean featured;
	@ManyToOne
	private Category category;
	@ElementCollection(fetch=FetchType.EAGER)
	private Map<String,Integer> size_qty = new HashMap<String, Integer>();
	
	public int hashCode() {	
		return id.hashCode();
	}
	

	
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			Product prodObj = (Product)obj;
			return prodObj.id.equals(id);			
		} else
		{
			return false;			
		}			
	}


	public String getName() {
		return name;
	}
	
	
	public Map<String, Integer> getSize_qty() {
		return size_qty;
	}

	public void setSize_qty(Map<String, Integer> size_qty) {
		this.size_qty = size_qty;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



	@Override
	public String toString() {		
		return "[" +"]"+id;
	}



	public Boolean getFeatured() {
		return featured;
	}



	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}
	
	

	

}
