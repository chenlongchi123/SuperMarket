package com.chen.web;

import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chen.bean.Goods;
import com.chen.service.GoodsService;
import com.chen.service.impl.GoodsServiceImpl;

import net.sf.json.JSONArray;


public class ListServlet extends HttpServlet {
	private GoodsService gService=new GoodsServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1根据service获得商品列表
		List<Goods> list=gService.getAll();
		//2将商品列表放入request域
		String json=JSONArray.fromObject(list).toString();
		request.setAttribute("json", json);
		
		//3转发到list.jsp
		request.getRequestDispatcher("/WEB-INF/page/list.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
