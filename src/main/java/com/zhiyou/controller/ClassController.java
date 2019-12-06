package com.zhiyou.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.pojo.User;
import com.zhiyou.pojo.Video;
import com.zhiyou.service.CourseService;
import com.zhiyou.service.SpeakerService;
import com.zhiyou.service.UserService;
import com.zhiyou.service.VideoService;


@Controller
public class ClassController {
	@Autowired
	CourseService Service;
	@Autowired
	UserService service1;
	@Autowired
	SpeakerService speakerservice;
	@Autowired
	VideoService videoservice;
	
	
	@RequestMapping("/webClass")
	public  void  webClass(String accounts,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = service1.selectByAccounts(accounts);
		int	subject_id=1;
		//获取到该学科下所有课程
		List<Course> list = Service.selectBySubjectid(subject_id);	
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.setAttribute("subject_id", subject_id);
		req.getRequestDispatcher("jsp/classshow.jsp").forward(req, resp);
	}
	@RequestMapping("/uiClass")
	public  void  uiClass(String accounts,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = service1.selectByAccounts(accounts);
		int	subject_id=6;
		//获取到该学科下所有课程
		List<Course> list = Service.selectBySubjectid(subject_id);	
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.setAttribute("subject_id", subject_id);
		req.getRequestDispatcher("jsp/classshow.jsp").forward(req, resp);
	}
	@RequestMapping("/pyClass")
	public  void  pyClass(String accounts,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = service1.selectByAccounts(accounts);
		int	subject_id=10;
		//获取到该学科下所有课程
		List<Course> list = Service.selectBySubjectid(subject_id);	
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.setAttribute("subject_id", subject_id);
		req.getRequestDispatcher("jsp/classshow.jsp").forward(req, resp);
	}
	@RequestMapping("/phpClass")
	public  void  phpClass(String accounts,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		User user = service1.selectByAccounts(accounts);
		int	subject_id=11;
		//获取到该学科下所有课程
		List<Course> list = Service.selectBySubjectid(subject_id);	
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.setAttribute("subject_id", subject_id);
		req.getRequestDispatcher("jsp/classshow.jsp").forward(req, resp);
	}
	
	@RequestMapping("/playvideo")  //http://localhost:8080/VideoProject/login
	public  void  playvideo(Integer video_id,Integer subject_id,int id,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		/*
		 * List<Course> list = Service.selectBySubjectid(subject_id);
		 * 
		 * //查询video和老师 Video video = videoservice.selectByVideoid(video_id); Speaker
		 * speaker = speakerservice.selectBySpeakerid(video.getSpeaker_id());
		 * 
		 * req.setAttribute("video", video);
		 * 
		 * req.setAttribute("speaker", speaker);
		 * 
		 * req.setAttribute("list", list);
		 */
		User user = service1.selectById(id);
		
		
		req.setAttribute("user", user);
		/* req.setAttribute("subject_id", subject_id); */
		
		
		//获取视频地址和老师信息
		List<Video> video = videoservice.selectVideoUrl(video_id);
		
		//查询课程信息和教师信息
		List<Video> video2 = videoservice.selectAlls(subject_id);
		//创建一个集合用来接收以上两条数据
		List<List> list = new ArrayList<List>();
		list.add(video);
		list.add(video2);
		
		req.setAttribute("list",list);
		
		
		req.getRequestDispatcher("jsp/playvideo.jsp").forward(req, resp);
	}
	
	
}
