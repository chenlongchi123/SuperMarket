package com.chen.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	static{
		
		try {
			//0��ȡ�����ļ�
			Properties prop  = new Properties();
			
			InputStream is = JDBCUtils.class.getResourceAsStream("/db.properties");
			
			//InputStream is = new FileInputStream("src/db.properties");
			prop.load(is);
			
			is.close();
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			
			//1 ע������
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//1 �������
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//2 �������
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��������ʧ��!");
		}
		
		return conn;
	}
	
	//2 �ͷ���Դ
		//1> ��������Ϊ��
		//2> ����close����Ҫ�׳��쳣,ȷ����ʹ�����쳣Ҳ�ܼ����ر�
		//3>�ر�˳��,��Ҫ��С����
	public  static void  close(Connection conn , Statement st , ResultSet rs){
		
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(st!=null){
				st.close();	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(conn!=null){
						conn.close();	
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
