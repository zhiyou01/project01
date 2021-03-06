package com.zhiyou.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.pojo.Course;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.pojo.Subject;
import com.zhiyou.pojo.Video;
import com.zhiyou.service.VideoService;
import com.zhiyou.util.FtpUtil;
import com.zhiyou.util.FtpUtil1;

@Controller
public class VideoController {
	@Autowired
	VideoService videoService;
	
	@RequestMapping("VideoSelect")
	public String selectAll(HttpServletRequest request,HttpServletResponse resp) {
		String title = request.getParameter("title")==null?"":request.getParameter("title");
		int count = videoService.selectCount(title);
		int page=request.getParameter("page")==null||request.getParameter("page")==""? 1:Integer.valueOf(request.getParameter("page"));
		request.setAttribute("page", page);
		request.setAttribute("count", count);
		List<Video> list = videoService.selectAll((page-1)*5,5,title);
		if (count != 0) {
			request.setAttribute("title", title);
			request.setAttribute("list", list);
			return "Video";
		}else {
			return "NullVideo";
		}
		
	}
	//鐐瑰嚮娣诲姞鐨勯〉闈㈣烦杞�
	@RequestMapping("insertVideo")
	public String add(HttpServletRequest req,HttpServletResponse resp) {
		List<Subject> subjects = videoService.selectSubject();
		List<Speaker> speakers = videoService.selectSpeaker();
		req.setAttribute("speakers", speakers);
		req.setAttribute("subjects", subjects);
		return "addVideo";
	}
	//娣诲姞椤甸潰淇濆瓨鏁版嵁鐨勮烦杞�
	@RequestMapping("insertVideoShow")
	public String addVideo(String title,String speaker_name,
			String subject_name,Integer time,MultipartFile image_url,
			String detail,MultipartFile url,
			HttpServletRequest req,HttpServletResponse resp) throws IOException {
	  
		
		String image = FtpUtil.upload(image_url.getInputStream(), image_url.getOriginalFilename());
		String upload = FtpUtil1.upload(url, req, resp);	
		Subject subject = videoService.selectSubjectByName(subject_name);
		
		Integer course_id = subject.getSubject_id();
		Speaker speaker = videoService.selectSpeakerByName(speaker_name);
		Integer speaker_id = speaker.getId();
		Video video=new Video(null,title,detail,time,speaker_id,course_id,upload,image, 0, null, null);
		
		
		videoService.add(video);
		return "redirect:VideoSelect";
	}
	@RequestMapping("deleteVideo")
	public void delete(Integer id,HttpServletRequest req,HttpServletResponse resp) {
		videoService.delete(id,resp);
	}
	@RequestMapping("updateVideoshow")
	public String update(Integer video_id,Integer id,Integer course_id,HttpServletRequest req,HttpServletResponse resp) {
		req.setAttribute("id", id);
		req.setAttribute("course_id", course_id);
		List<Subject> subjects = videoService.selectSubject();
		List<Speaker> speakers = videoService.selectSpeaker();
		Video video = videoService.selectByID(video_id);
		req.setAttribute("video", video);
		req.setAttribute("speakers", speakers);
		req.setAttribute("subjects", subjects);
		return "updateVideo";
	}
	//娣诲姞椤甸潰淇濆瓨鏁版嵁鐨勮烦杞�
		@RequestMapping("VideoShow")
		public String updateVideo(Integer video_id,String title,Integer speaker_id,
				Integer subject_id,Integer time,String image_url,
				String video_url,String detail,
				HttpServletRequest req,HttpServletResponse resp) throws IOException {
			Video video=new Video(video_id,title,detail,time,speaker_id,subject_id,video_url,image_url, null, null, null);
			videoService.update(video);
			return "redirect:VideoSelect";
		}
		@RequestMapping("delAllVideo")
		public void deleteUser(@RequestParam("userIds[]") Integer[] userIds ,HttpServletResponse resp){
				List<Integer> userIdList = Arrays.asList(userIds);
				System.out.println(userIdList);
				videoService.removeCourse(userIdList, resp);
			
	}
}
