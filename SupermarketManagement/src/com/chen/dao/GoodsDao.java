package com.chen.dao;

import java.util.List;

import com.chen.bean.Goods;

public interface GoodsDao {
	//增加货物
	void addGoods(Goods goods);
	//查询货物
	List<Goods> getALL();
	Goods getById(int id);
	void update(Goods goods);
	void delete(Goods goods);
}
