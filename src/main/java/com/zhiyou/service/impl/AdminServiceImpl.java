package com.zhiyou.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.AdminDao;
import com.zhiyou.pojo.Admin;
import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Subject;
import com.zhiyou.pojo.User;
import com.zhiyou.service.AdminService;
import com.zhiyou.util.MD5Utils;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDao aDao;

	public int selectCount(String course_title) {
		
		return aDao.selectCount(course_title);
	}
	//查询所有的课程
	public List<Course> SelectAll(int page,int number,String course_title) {
		return aDao.selectAll(page,number,course_title);
	}
	
	public Course selectByID(Integer id) {
		return aDao.selectByID(id);
	}

	public Course selectCourseByID( Integer id) {
		
		return  aDao.selectCourseByID(id);
	}
	
	public void update(Course course) {
		aDao.update(course);
	}
	public void add(Course course) {
		aDao.add(course);
		
	}
	public List<Subject> selectSubject() {
		return aDao.selectSubject();
	}
	public Subject selectName(String subject_name) {
		
		return aDao.selectName(subject_name);
	}
	public void delCourse(Integer id, HttpServletResponse resp) {

		int number = aDao.delCourse(id);
		if(number==1) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void removeCourse(List<Integer> userIdList,HttpServletResponse resp) {
		
		int i = aDao.removeCourse(userIdList);
		if (i==userIdList.size()) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean select(String accounts, String pwd,HttpServletRequest req) {
		Admin admin  = aDao.select(accounts);
		if(admin!=null) {
			if (admin.getPassword().equals(pwd)) {
				req.getSession().setAttribute("admin", admin);			
				return true ;
			}else {
				return false ;
			}
		}else {
			return false;
		}
	
	}
	public boolean selectaccounts(String accounts) {
		Admin admin  = aDao.select(accounts);
		
		if(admin!=null) {
			return false ;
		}else {
			return true;
		}
	}
	
	
	

}
