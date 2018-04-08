package com.chen.service.impl;

import java.util.List;

import com.chen.bean.Goods;
import com.chen.dao.GoodsDao;
import com.chen.dao.impl.GoodsDaoImpl;
import com.chen.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDao gDao=new GoodsDaoImpl();
	public void addGoods(Goods goods){
		gDao.addGoods(goods);
	}

	public List<Goods> getAll() {
		return gDao.getALL();
	}

	public Goods getById(int id) {

		return gDao.getById(id);
	}

	public void update(Goods goods) {
		gDao.update(goods);
		
	}


	public void delete(Goods goods) {
		gDao.delete(goods);
		
	}
}
