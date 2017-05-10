package com.chen.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.chen.bean.Goods;
import com.chen.bean.Othercost;
import com.chen.service.GoodsService;
import com.chen.service.OthercostService;
import com.chen.service.impl.GoodsServiceImpl;
import com.chen.service.impl.OthercostServiceImpl;
import com.chen.utils.PathUtils;



public class OtherCostServlet extends HttpServlet {
	OthercostService os=new OthercostServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Othercost othercost=new Othercost();
		request.setCharacterEncoding("UTF-8");
		String format=request.getParameter("format");
		Map<String, String[]> parameterMap=new HashMap<String,String[]>();
		
		String odate=request.getParameter("odate");
		String oname=request.getParameter("oname");
		String money=request.getParameter("money");
		Double money1=Double.parseDouble(money);
		othercost.setMoney(money1);
		othercost.setOdate(odate);
		othercost.setOname(oname);
		//校验=> 非空校验
		
				//调用service保存
		os.addOthercost(othercost);
		//重定向到列表Servlet
				response.sendRedirect(request.getContextPath()+"/ListServlet");
		
						
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
