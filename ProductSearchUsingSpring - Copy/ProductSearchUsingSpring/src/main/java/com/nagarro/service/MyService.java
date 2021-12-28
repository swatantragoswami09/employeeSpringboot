package com.nagarro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.ProductDao;
import com.nagarro.dao.UserDao;
import com.nagarro.model.Products;
import com.nagarro.model.Users;
import com.nagarro.readcsv.ReadCSV;
import com.nagarro.thread.Watcher;

@Service("myService")
public class MyService {
	@Autowired
	UserDao userDao;
	@Autowired
	ProductDao productDao;

	public boolean check(String username, String password) {
		List<Users> list = this.userDao.fetchUsers(username, password);
		for (Users user : list) {
			if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}

		return false;
	}

	public List<Products> matchedProducts(String color, String size, String gender, String sort) {
		List<Products> result = this.productDao.fetchProducts(color, size, gender, sort);
//		List<Products> result=new List<>();
		return result;
	}

	public List<Products> saveProduct() {
		ReadCSV read = new ReadCSV();
		Watcher watch = new Watcher(read);
		watch.start();
		List<Products> p = read.readCSV();
//		List<String> s;
		for (Products f : p) {
			this.productDao.saveProduct(f);
//			System.out.println(f.getId()+" "+ f.getName());
		}
		return p;
	}

	public void saveUser(Users user) {
		this.userDao.saveUser(user);
	}

}
