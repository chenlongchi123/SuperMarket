package com.chen.service.impl;

import com.chen.bean.Othercost;
import com.chen.service.OthercostService;
import com.chen.dao.impl.OthercostDaoImpl;
import com.chen.dao.OthercostDao;

public class OthercostServiceImpl  implements OthercostService {
private OthercostDao othercostDao=new OthercostDaoImpl();
	@Override
	public void addOthercost(Othercost othercost) {
		othercostDao.addOthercost(othercost);
	}

}
