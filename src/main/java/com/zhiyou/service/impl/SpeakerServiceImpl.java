package com.zhiyou.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.SpeakerDao;
import com.zhiyou.pojo.Speaker;
import com.zhiyou.service.SpeakerService;
@Service
public class SpeakerServiceImpl implements SpeakerService {
	@Autowired
	SpeakerDao dao;
	public Speaker selectBySpeakerid(int id) {
		// TODO Auto-generated method stub
		return dao.selectBySpeakerid(id);
	}

}
