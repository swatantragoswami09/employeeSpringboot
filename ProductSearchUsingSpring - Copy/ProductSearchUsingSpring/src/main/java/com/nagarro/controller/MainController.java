package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.Products;
import com.nagarro.model.Users;
import com.nagarro.service.MyService;

@Controller
public class MainController {
	@Autowired
	MyService myService;

	@RequestMapping("/login")
	public String displayLoginPage() {
		System.out.println("this is controller");
		return "login";
	}

	@RequestMapping("/register")
	public String displayRegisterPage() {
		return "register";
	}

	@RequestMapping("/registerUser")
	public String saveUser(@ModelAttribute Users user) {
		this.myService.saveUser(user);
		return "login";
	}

	@RequestMapping("/search")
	public String login(@ModelAttribute Users user, HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		System.out.println(user.getUsername());
		if (this.myService.check(user.getUsername(), user.getPassword())) {
			session.setAttribute("username", user.getUsername());
			return "search";
		} else {
			req.getSession().setAttribute("error", "*Username or password incorrect");
			return "login";
		}

	}

	@RequestMapping("/result")
	public ModelAndView search(@ModelAttribute Products product, @RequestParam("sort") String value) {

//		List<Products> p=this.myService.saveProduct();
		this.myService.saveProduct();
		List<Products> result = this.myService.matchedProducts( product.getColor(),	product.getSize(), product.getGender_rec(), value);
//		for(Products l:result) {
//			System.out.println(l);
//			
//		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("resultedproducts", result);
		mv.setViewName("result");
		return mv;
	}

	@RequestMapping("/logout")
	public void logout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("username");
		res.sendRedirect("login");
	}

	@RequestMapping("/searchPage")
	public String goBackToSearchPage() {
		return "search";
	}
}
