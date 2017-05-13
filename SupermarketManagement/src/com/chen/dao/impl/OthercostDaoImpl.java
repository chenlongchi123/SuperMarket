package com.chen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chen.bean.Cost;
import com.chen.bean.Goods;
import com.chen.bean.Othercost;
import com.chen.dao.OthercostDao;
import com.chen.utils.JDBCUtils;

public class OthercostDaoImpl implements OthercostDao {

	public void addOthercost(Othercost othercost) {
		//1�������
				Connection conn=JDBCUtils.getConnection();
				//2׼��sql
				String sql= "INSERT INTO `t_othercost` VALUES (NULL,?,?,?);";
				PreparedStatement ps=null;
				try {
					//3���prepareStatemetnt
					ps=conn.prepareStatement(sql);
					//4���ò���
					ps.setString(1, othercost.getOname());
					ps.setDouble(2, othercost.getMoney());
					ps.setString(3, othercost.getOdate());
					//ִ��sql
					int rowcount=ps.executeUpdate();
					if(rowcount!=1){
						throw new RuntimeException("���֧��ʧ�ܣ�");
					}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
					//�ر���Դ
					JDBCUtils.close(conn, ps, null);
					}
	}
	public List<Othercost> getSeeOther() {
		//�������
		Connection conn=JDBCUtils.getConnection();
		List<Othercost> list=new ArrayList<Othercost>();
		//sql���
		String sql="select * from t_othercost";
		//����prepare statement����
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
		
		//ִ��sql
		 rs=ps.executeQuery();
		while(rs.next()){
			Othercost othercost=new Othercost();
			othercost.setOname(rs.getString("oname"));
			othercost.setId(rs.getInt("id"));
			othercost.setMoney(rs.getDouble("money"));
			othercost.setOdate(rs.getString("odate"));
			list.add(othercost);
		}
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ������ʷʧ�ܣ�");
			
		}finally {
			//�ر���Դ
			JDBCUtils.close(conn, ps, rs);
		}
	}

}
