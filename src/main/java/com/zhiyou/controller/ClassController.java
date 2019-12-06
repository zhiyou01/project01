package com.zhiyou.controller;

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
		//��ȡ����ѧ�������пγ�
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
		//��ȡ����ѧ�������пγ�
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
		//��ȡ����ѧ�������пγ�
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
		//��ȡ����ѧ�������пγ�
		List<Course> list = Service.selectBySubjectid(subject_id);	
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.setAttribute("subject_id", subject_id);
		req.getRequestDispatcher("jsp/classshow.jsp").forward(req, resp);
	}
	
	@RequestMapping("/playvideo")  //http://localhost:8080/VideoProject/login
	public  void  playvideo(Integer video_id,Integer subject_id,User user,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		
		List<Course> list = Service.selectBySubjectid(subject_id);	
		
		//��ѯvideo����ʦ
		Video video = videoservice.selectByVideoid(video_id);
		Speaker speaker = speakerservice.selectBySpeakerid(video.getSpeaker_id());
		
		req.setAttribute("video", video);
		req.setAttribute("speaker", speaker);
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.setAttribute("subject_id", subject_id);	
		req.getRequestDispatcher("jsp/playvideo.jsp").forward(req, resp);
	}
	
	
}