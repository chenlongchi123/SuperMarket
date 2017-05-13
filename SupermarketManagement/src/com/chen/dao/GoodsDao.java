package com.chen.dao;

import java.util.List;

import com.chen.bean.Cost;
import com.chen.bean.Goods;

public interface GoodsDao {
	public Cost SeeBill();
	//���ӻ���
	void addGoods(Goods goods);
	//��ѯ����
	List<Goods> getALL();
	Goods getById(int id);
	Goods getByName(String name);
	void update(Goods goods);
	void delete(Goods goods);
	void sellGoods(Goods goods);
	 List<Goods> getSellHistory();
	
}
