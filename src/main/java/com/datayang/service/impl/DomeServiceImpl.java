package com.datayang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.datayang.dao.DomeMapper;
import com.datayang.pojo.Dome;
import com.datayang.service.DomeService;

@Service
public class DomeServiceImpl implements DomeService {
	@Resource
	private DomeMapper domeMapper;

	@Override
	public Dome findDomeById(Integer id) {
		return domeMapper.selectByPrimaryKey(id);
	}

}
