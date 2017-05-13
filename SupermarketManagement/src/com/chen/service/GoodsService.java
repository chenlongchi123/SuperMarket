package com.chen.service;

import java.util.List;

import com.chen.bean.Cost;
import com.chen.bean.Goods;


public interface GoodsService {
	public Cost SeeBill();
	public void addGoods(Goods goods);
	public List<Goods> getAll();
	public Goods getById(int id);
	public void update(Goods goods);
	public void delete(Goods goods);
	public void sellGoods(int  id,String odate);
	public List<Goods> getSellHistory();
	
}
