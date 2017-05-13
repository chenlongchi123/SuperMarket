package com.chen.service.impl;

import java.util.List;

import com.chen.bean.Cost;
import com.chen.bean.Goods;
import com.chen.dao.GoodsDao;
import com.chen.dao.impl.GoodsDaoImpl;
import com.chen.service.GoodsService;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDao gDao=new GoodsDaoImpl();
	public Cost SeeBill() {
		return gDao.SeeBill(); 
	}
	public void addGoods(Goods goods){
		gDao.addGoods(goods);
	}

	public List<Goods> getAll() {
		return gDao.getALL();
	}
	public List<Goods> getSellHistory() {
		return gDao.getSellHistory();
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
	public void  sellGoods(int id,String odate) {
	Goods goods=gDao.getById(id);
	int num=goods.getPnum();
	num=num-1;
	goods.setPnum(num);
	goods.setOdate(odate);
	if(num>0){gDao.update(goods);
	}else{
		gDao.delete(goods);
	}
	gDao.sellGoods(goods);
	}
}
