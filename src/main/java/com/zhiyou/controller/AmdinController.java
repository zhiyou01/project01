package com.zhiyou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.pojo.Course;
import com.zhiyou.service.AdminService;

@Controller
public class AmdinController {
	@Autowired
	AdminService service;
	
	@RequestMapping("admin")
	public String login(String accounts,String password,HttpServletRequest req,HttpServletResponse resp) {
		int i = service.select(accounts, password, req);
		if (i==1) {
			return "redirect:selectAll";
		}else if (i==2) {
			req.setAttribute("me", "密码错误");
		}else {
			req.setAttribute("me", "用户名不存在");
		}
		return "index";
	}
	@RequestMapping("selectAll")
	public String selectAll(HttpServletRequest req,HttpServletResponse resp) {
		List<Course> list = service.selectAll();
		System.out.println(list);
		req.setAttribute("list", list);
		return "spporter";
	}
}
