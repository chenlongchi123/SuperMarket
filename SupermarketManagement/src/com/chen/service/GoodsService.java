package com.chen.service;

import java.util.List;

import com.chen.bean.Goods;


public interface GoodsService {
	
	public void addGoods(Goods goods);
	public List<Goods> getAll();
	public Goods getById(int id);
	public void update(Goods goods);
	public void delete(Goods goods);
}
