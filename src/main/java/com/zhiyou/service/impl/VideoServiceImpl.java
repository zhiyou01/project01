package com.zhiyou.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.VideoDao;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.pojo.Subject;
import com.zhiyou.pojo.Video;
import com.zhiyou.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService {
	@Autowired
	VideoDao vDao;
	public Video selectByVideoid(int video_id) {
		
		return vDao.selectByVideoid(video_id);
	}

	public void add(Video video) {
		vDao.add(video);

	}

	public void update(Video video) {
		vDao.update(video);

	}
	public void delete(Integer id,HttpServletResponse resp) {
		int number=vDao.delete(id);
		if (number==1) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Video> selectAll(int page, int number, String title) {
		return vDao.selectAll(page,number,title);
	}

	public Video selectByID(Integer video_id) {
		
		return vDao.selectByID(video_id);
	}

	public List<Subject> selectSubject() {
		return vDao.selectSubject();
	}

	public List<Speaker> selectSpeaker() {
		return vDao.selectSpeaker();
	}

	public Subject selectSubjectByName(String subject_name) {
		return vDao.selectSubjectByName(subject_name);
	}

	public Speaker selectSpeakerByName(String speaker_name) {
		return vDao.selectSpeakerByName(speaker_name);
	}

	public int selectCount(String title) {
		return vDao.selectCount(title);
	}

	public void removeCourse(List<Integer> userIdList, HttpServletResponse resp) {
		int i = vDao.removeCourse(userIdList);
		if (i==userIdList.size()) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			};
		}
	}
	
	//获取视频地址和教师信息
	public List<Video> selectVideoUrl(Integer video_id){
		return vDao.selectVideoUrl(video_id);
	}
		
	//查询课程信息和教师信息
	public List<Video> selectAlls(Integer id){
		return vDao.selectAlls(id);
	}
}
