package com.chen.dao;

import java.util.List;

import com.chen.bean.Othercost;

public interface OthercostDao {
	//����֧��
		void addOthercost(Othercost othercost);
		public List<Othercost> getSeeOther();
}
