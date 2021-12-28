package com.nagarro.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Products;


@Repository
@Transactional
public class ProductDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	public List<Products> fetchProducts(String color, String size, String gender, String sort) {
//		String formattedDate = null;
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
////			formattedDate = sdf.format(sdf2.parse(date));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		DetachedCriteria criteria = DetachedCriteria.forClass(Products.class);
		criteria.add(Restrictions.eq("color", color));
		criteria.add(Restrictions.eq("size", size));
		criteria.add(Restrictions.eq("gender_rec", gender));
		
		criteria.addOrder(Order.asc(sort));
		List<Products> products = (List<Products>) this.hibernateTemplate.findByCriteria(criteria);
//		this.hibernateTemplate.getSessionFactory().getCurrentSession().createSQLQuery("from products")
//				.executeUpdate();
//		List<Products> products=(List<Products>) this.hibernateTemplate.get(Products.class, criteria);
		
		return products;
	}

	public void saveProduct(Products f) {
		this.hibernateTemplate.save(f);
		
	}

}
