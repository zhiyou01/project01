package com.zhiyou.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.SpeakerDao;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.service.SpeakerService;
@Service
public class SpeakerServiceImpl implements SpeakerService {
	@Autowired
	SpeakerDao sDao;
	
	
	
	
	public Speaker selectBySpeakerid(int id) {
		// TODO Auto-generated method stub
		return sDao.selectBySpeakerid(id);
	}
	public void add(Speaker speaker) {
		sDao.add(speaker);
	}

	public void update(Speaker speaker) {
		sDao.update(speaker);
	}

	public void delete(Integer id, HttpServletResponse resp) {
		int number=sDao.delete(id);
		if (number==1) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Speaker selectByID(Integer id) {
		return sDao.selectByID(id);
	}

	public int selectCount(String speaker_name) {
		
		return sDao.selectCount(speaker_name);
	}


	public List<Speaker> SelectAll(int page, int number, String speaker_name) {
		return sDao.selectAll(page,number,speaker_name);
	}

	public void removeCourse(List<Integer> userIdList,HttpServletResponse resp) {
		
		int i = sDao.removeCourse(userIdList);
		if (i==userIdList.size()) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
