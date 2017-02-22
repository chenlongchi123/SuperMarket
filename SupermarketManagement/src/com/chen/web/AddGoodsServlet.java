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
import com.chen.service.GoodsService;
import com.chen.service.impl.GoodsServiceImpl;
import com.chen.utils.PathUtils;



public class AddGoodsServlet extends HttpServlet {
	GoodsService gs=new GoodsServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Goods goods=new Goods();
		request.setCharacterEncoding("UTF-8");
		String format=request.getParameter("format");
		Map<String, String[]> parameterMap=new HashMap<String,String[]>();
		if("json".equals(format)){
	//�������ù���
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//����������
		ServletFileUpload upload=new ServletFileUpload(factory);
		//����request
		List<FileItem> list=null;
		try {
			list =  upload.parseRequest(request);
		} catch (FileUploadException e) {
			throw new RuntimeException("����������");
		}
		//����fileitem
		if(list!=null){
			for(FileItem item :list){
				if (!item.isFormField()) {
					//�ļ��ϴ�
					//���ļ����浽��Ŀ��Ŀ¼�µ�upload�ļ�����
					//���upload�ļ���·��
					String uploadPath=getServletContext().getRealPath("/upload");
					//��������Ŀ¼
					String datePath=PathUtils.getDatePath(uploadPath);
					//����ͼƬ����
					String filename=UUID.randomUUID().toString();
					//����ͼƬ
					InputStream iStream=item.getInputStream();
					FileOutputStream oStream=new FileOutputStream(uploadPath+datePath+filename);
					IOUtils.copy(iStream,oStream);
					//�������·����product������
					goods.setImgurl("/upload"+datePath+filename);
					iStream.close();
					oStream.close();
					item.delete();	
				}else {
					//����ͨ��
					//��ÿ����ͨ����ļ�ֵ�Զ���ȡ��
					String key=item.getFieldName();
					String value = item.getString("UTF-8");
					//�����Ƿ�װ��Map��
					parameterMap.put(key, new String[]{value});
				}
			}
		}
		//����beanutils��������װ��goods������
		try {
			BeanUtils.populate(goods, parameterMap);
		}  catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//У��=> �ǿ�У��
		
				//����service����
		gs.addGoods(goods);
		//�ض����б�Servlet
				response.sendRedirect(request.getContextPath()+"/ListServlet");
		}else {
			request.setCharacterEncoding("UTF-8");
			try {
				BeanUtils.populate(goods, request.getParameterMap());
				gs.addGoods(goods);
				response.sendRedirect(request.getContextPath()+"/ListServlet");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
						
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
