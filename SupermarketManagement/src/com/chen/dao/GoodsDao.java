package com.chen.dao;

import java.util.List;

import com.chen.bean.Cost;
import com.chen.bean.Goods;

public interface GoodsDao {
	public Cost SeeBill();
	//增加货物
	void addGoods(Goods goods);
	//查询货物
	List<Goods> getALL();
	Goods getById(int id);
	Goods getByName(String name);
	void update(Goods goods);
	void delete(Goods goods);
	void sellGoods(Goods goods);
	 List<Goods> getSellHistory();
	
}
