package com.chen.dao;

import java.util.List;

import com.chen.bean.Goods;

public interface GoodsDao {
	//���ӻ���
	void addGoods(Goods goods);
	//��ѯ����
	List<Goods> getALL();
	Goods getById(int id);
	void update(Goods goods);
	void delete(Goods goods);
}
