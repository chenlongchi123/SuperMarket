package com.chen.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chen.bean.Goods;
import com.chen.service.GoodsService;
import com.chen.service.impl.GoodsServiceImpl;

public class ToEditServlet extends HttpServlet {
private GoodsService gService=new GoodsServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1获得参数id
		String id=request.getParameter("id");
		int pid=Integer.parseInt(id);
		//2根据id获得商品对象
		Goods goods=gService.getById(pid);
		//3将商品放入request域中
		request.setAttribute("goods", goods);
		//4转发到商品修改页面
		request.getRequestDispatcher("WEB-INF/page/edit.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
