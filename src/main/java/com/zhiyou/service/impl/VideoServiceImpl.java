package com.zhiyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.VideoDao;
import com.zhiyou.pojo.Video;
import com.zhiyou.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService {
	@Autowired
	VideoDao dao;
	public Video selectByVideoid(int video_id) {
		
		return dao.selectByVideoid(video_id);
	}

}
