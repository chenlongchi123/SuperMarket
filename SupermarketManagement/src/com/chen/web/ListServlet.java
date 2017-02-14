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
		//1����service�����Ʒ�б�
		List<Goods> list=gService.getAll();
		//2����Ʒ�б����request��
		String json=JSONArray.fromObject(list).toString();
		request.setAttribute("json", json);
		
		//3ת����list.jsp
		request.getRequestDispatcher("/WEB-INF/page/list.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
