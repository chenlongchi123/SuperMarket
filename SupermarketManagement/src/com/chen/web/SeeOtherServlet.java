package com.chen.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chen.bean.Goods;
import com.chen.bean.Othercost;
import com.chen.bean.User;
import com.chen.service.GoodsService;
import com.chen.service.OthercostService;
import com.chen.service.impl.GoodsServiceImpl;
import com.chen.service.impl.OthercostServiceImpl;

import net.sf.json.JSONArray;

public class SeeOtherServlet extends HttpServlet {
	private OthercostService othercostService=new OthercostServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=(User)request.getSession().getAttribute("user");
		request.setCharacterEncoding("UTF-8");
//		if(u==null){
//			response.sendRedirect("/login.jsp");
//			return;
//		}
		String format=request.getParameter("format");
		//1����service�����Ʒ�б�
		List<Othercost> list=othercostService.getSeeOther();
		if("json".equals(format)){
		
		//2����Ʒ�б����request��
		String json=JSONArray.fromObject(list).toString();
		request.setAttribute("json", json);
		
		//3ת����list.jsp
		request.getRequestDispatcher("/WEB-INF/page/seeOther.jsp").forward(request, response);
		}else {
            request.setAttribute("list", list);
           request.getRequestDispatcher("/list5.jsp").forward(request, response);
          
        }

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
