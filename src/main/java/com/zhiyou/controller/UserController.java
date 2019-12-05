package com.zhiyou.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.zhiyou.pojo.User;
import com.zhiyou.service.UserService;
import com.zhiyou.util.FtpUtil;

@Controller
@RestController
public class UserController {
	@Autowired
	UserService Service;
	
	/**
	 * @�û�ע��
	 * @param user1
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertUser")
	public void insertUser(User user1,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		Service.addUser(user1);
		User user = Service.selectByAccounts(user1.getAccounts());
		req.setAttribute("user", user);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
//		Service.addUser(user1);
//		return new ResponseVo<User>(200, "", null);
		
	}
	/**
	 * @��������
	 * @param id
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/personalspace")
	public void personalspace(int id,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		//ͨ��id������û�
		User user = Service.selectById(id);
		req.setAttribute("user",user);
		req.getRequestDispatcher("jsp/personalspace.jsp").forward(req, resp);
	}
	/**
	 * @�޸�����
	 * @param id
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/updatedata")
	public void updatedata(int id,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		//ͨ��id������û�
		User user = Service.selectById(id);
		req.setAttribute("user",user);
		req.getRequestDispatcher("jsp/updatedata.jsp").forward(req, resp);
	}
	
	@RequestMapping("/updateuser")
	public void updateuser(User user1,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		Service.updateUser(user1);
		User user = Service.selectById(user1.getId());
		req.setAttribute("user", user);
		req.getRequestDispatcher("jsp/personalspace.jsp").forward(req, resp);
	}
	/**
	 * @�޸�����
	 * @param id
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/updatepwd")
	public void updatepwd(int id,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		//ͨ��id������û�
		User user = Service.selectById(id);
		req.setAttribute("user",user);
		req.getRequestDispatcher("jsp/updatepwd.jsp").forward(req, resp);
	}
	@RequestMapping("/updatepassword")
	public void updatepassword(User user1,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		//System.out.println(user1);
		Service.updateUser(user1);
		User user = Service.selectById(user1.getId());
		req.setAttribute("user",user);
		resp.sendRedirect("index.jsp");
	}
	@RequestMapping("/jsp/forgetpwd")
	public void forgetpwd(User user1,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		User user = Service.selectByAccounts(user1.getAccounts());
		user.setPassword(user1.getPassword());
		Service.updateUser(user);
//		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		resp.sendRedirect("index.jsp");
	}
	
	/**
	 * @�޸�ͷ��
	 * @param id
	 * @param req
	 * @param resp
	 * @throws Exception
	 */
	@RequestMapping("/updatephoto")
	public void updatephoto(int id,HttpServletRequest req,HttpServletResponse resp) throws Exception {
		//ͨ��id������û�
		User user = Service.selectById(id);
		req.setAttribute("user",user);
		req.getRequestDispatcher("jsp/updatephoto.jsp").forward(req, resp);
	}
	@RequestMapping("/upload")
	public void upload2(MultipartFile image_file,HttpServletRequest req,HttpServletResponse resp) throws Exception {
	    
		//ͷ���ϴ���������
		String url = FtpUtil.upload(image_file.getInputStream(), image_file.getOriginalFilename());
	   
		
	    User user = new User();
	    user.setImgurl(url);
	    user.setId(Integer.valueOf(req.getParameter("id")));
	    Service.updateUser(user);
	
	    User user1 = Service.selectById(Integer.valueOf(req.getParameter("id")));
		req.setAttribute("user", user1);
		req.getRequestDispatcher("jsp/personalspace.jsp").forward(req, resp);			
	}
}
