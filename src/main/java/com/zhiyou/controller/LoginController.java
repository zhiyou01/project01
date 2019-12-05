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
	
	
	/**
	 * @��¼
	 * @param accounts
	 * @param password
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public void  login(String accounts,String password,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		User user = service.loginSelect(req, accounts, password);
		req.setAttribute("user", user);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	/**
	 * @�˺ŵ�ajax��֤
	 * @param name
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/loginjudge")
	public void  loginjudge(String name,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		 User user=new User();
         user.setAccounts(name);
	     boolean b = service.selectUser(user);
	     resp.getWriter().write(b+""); 	
	}
	/**
	 * @�����ajax��֤
	 * @param name
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/pwdjudge")
	public void  pwdjudge(String name1,String name2,HttpServletRequest req,HttpServletResponse resp) throws Exception {
         User user=new User();
         user.setPassword(name1);
         user.setAccounts(name2);
         System.out.println(user);
	     boolean b = service.selectUser(user);
	     resp.getWriter().write(b+""); 	
	}
	/**
	 * @ע��������˺�Ajax��֤
	 * @param name
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/validateEmail")
	public void  validateEmail(String name,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		User user=new User();
        user.setAccounts(name);
	    boolean b = service.selectUser(user);
	    resp.getWriter().write(b+""); 	
	}
	
	/**
	 * @�޸�����
	 * @param name
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/jsp/loginjudge")
	public void  jsploginjudge(String name,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		 User user=new User();
         user.setAccounts(name);
	     boolean b = service.selectUser(user);
	     resp.getWriter().write(b+""); 	
	}
	
	@RequestMapping("/jsp/pwdjudge")
	public void  jsppwdjudge(String name1,String name2,HttpServletRequest req,HttpServletResponse resp) throws Exception {
         User user=new User();
         user.setPassword(name1);
         user.setAccounts(name2);
         System.out.println(user);
	     boolean b = service.selectUser(user);
	     resp.getWriter().write(b+""); 	
	}
	
}
