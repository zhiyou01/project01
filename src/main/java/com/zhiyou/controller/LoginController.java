package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.pojo.User;
import com.zhiyou.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService service;
	//µÇÂ¼
	@RequestMapping("/login")
	public void  login(String accounts,String password,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		System.out.println("½øÀ´ÁË");
		
		User user = service.loginSelect(req, accounts, password);
		
		if(user==null) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}else {
			//req.getSession().getServletContext().setAttribute("nowuser", user);
			req.setAttribute("user", user);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	
	
}
