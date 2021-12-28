package com.nagarro.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Users;

@Repository
@Transactional
public class UserDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	public List<Users> fetchUsers(String username, String password) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		@SuppressWarnings("unchecked")
		List<Users> user = (List<Users>) this.hibernateTemplate.findByCriteria(criteria);
		return user;
	}

	public void saveUser(Users user) {
		this.hibernateTemplate.save(user);
	}
}
