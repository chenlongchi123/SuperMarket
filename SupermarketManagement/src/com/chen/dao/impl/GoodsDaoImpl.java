package com.chen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chen.bean.Cost;
import com.chen.bean.Goods;
import com.chen.dao.GoodsDao;
import com.chen.utils.JDBCUtils;



public class GoodsDaoImpl implements GoodsDao {
	public Cost SeeBill() {
		//�������
				Connection conn=JDBCUtils.getConnection();
				//sql���
				String sql="SELECT SUM(price) price FROM t_sellgoods";
				String sql1="SELECT SUM(price2) price2 FROM t_sellgoods";
				String sql2="SELECT SUM(money) money FROM t_othercost";
				
				//����prepare statement����
				PreparedStatement ps=null;
				ResultSet rs=null;
				Cost cost=new Cost();
				try {
					ps=conn.prepareStatement(sql);
					//ִ��sql
					rs=ps.executeQuery();
					while(rs.next()){
					cost.setCsprice(rs.getDouble("price"));
					}
					ps=conn.prepareStatement(sql1);
					//ִ��sql
					 rs=ps.executeQuery();
					while(rs.next()){
						cost.setJjprice(rs.getDouble("price2"));
					}
					ps=conn.prepareStatement(sql2);
					//ִ��sql
					 rs=ps.executeQuery();
					while(rs.next()){
						cost.setHfprice(rs.getDouble("money"));
					}
				
				}catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("��ѯ��Ʒʧ�ܣ�");
					
				}finally {
					//�ر���Դ
					JDBCUtils.close(conn, ps, rs);
				}
		return cost;
	}

	public List<Goods> getALL() {
		//�������
		Connection conn=JDBCUtils.getConnection();
		List<Goods> list=new ArrayList<Goods>();
		//sql���
		String sql="select * from t_goods";
		//����prepare statement����
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
		
		//ִ��sql
		 rs=ps.executeQuery();
		while(rs.next()){
			Goods goods=new Goods();
			goods.setName(rs.getString("name"));
			goods.setId(rs.getInt("id"));
			goods.setPrice(rs.getDouble("price"));
			goods.setPnum(rs.getInt("pnum"));
			goods.setType(rs.getString("type"));
			goods.setImgurl(rs.getString("imgurl"));
			goods.setDescription(rs.getString("description"));
			goods.setPrice2(rs.getDouble("price2"));
			list.add(goods);
		}
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ��Ʒʧ�ܣ�");
			
		}finally {
			//�ر���Դ
			JDBCUtils.close(conn, ps, rs);
		}
	}
	public List<Goods> getSellHistory() {
		//�������
		Connection conn=JDBCUtils.getConnection();
		List<Goods> list=new ArrayList<Goods>();
		//sql���
		String sql="select * from t_sellgoods";
		//����prepare statement����
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
		
		//ִ��sql
		 rs=ps.executeQuery();
		while(rs.next()){
			Goods goods=new Goods();
			goods.setName(rs.getString("name"));
			goods.setId(rs.getInt("id"));
			goods.setPrice(rs.getDouble("price"));
			goods.setType(rs.getString("type"));
			goods.setOdate(rs.getString("odate"));
			goods.setPrice2(rs.getDouble("price2"));
			list.add(goods);
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

	public void addGoods(Goods goods) {
		//1�������
		Connection conn=JDBCUtils.getConnection();
		//2׼��sql
		String sql= "INSERT INTO `t_goods` VALUES (NULL,?,?,?,?,?,?,?);";
		PreparedStatement ps=null;
		try {
			//3���prepareStatemetnt
			ps=conn.prepareStatement(sql);
			//4���ò���
			ps.setString(1, goods.getName());
			ps.setDouble(2, goods.getPrice());
			ps.setInt(3, goods.getPnum());
			ps.setString(4, goods.getDescription());
			ps.setString(5, goods.getType());
			ps.setString(6, goods.getImgurl());
			ps.setDouble(7, goods.getPrice2());
			
			//ִ��sql
			int rowcount=ps.executeUpdate();
			if(rowcount!=1){
				throw new RuntimeException("�����Ʒʧ�ܣ�");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
			//�ر���Դ
			JDBCUtils.close(conn, ps, null);
			}
		}
	public void sellGoods(Goods goods) {
		//1�������
		Connection conn=JDBCUtils.getConnection();
		//2׼��sql
		String sql= "INSERT INTO `t_sellgoods` VALUES (NULL,?,?,?,?,?,?);";
		PreparedStatement ps=null;
		try {
			//3���prepareStatemetnt
			ps=conn.prepareStatement(sql);
			//4���ò���
			ps.setString(1, goods.getName());
			ps.setDouble(2, goods.getPrice());
			ps.setString(3, goods.getType());
			ps.setString(4, goods.getOdate());
			ps.setInt(5, goods.getId());
			ps.setDouble(6, goods.getPrice2());
			//ִ��sql
			int rowcount=ps.executeUpdate();
			if(rowcount!=1){
				throw new RuntimeException("��ӳ�����Ʒʧ�ܣ�");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
			//�ر���Դ
			JDBCUtils.close(conn, ps, null);
			}
		}

	public Goods getById(int id) {
				Goods goods=new Goods();
		//�������
				Connection conn=JDBCUtils.getConnection();
				
				//sql���
				String sql="select * from t_goods where id=?";
				//����prepare statement����
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					ps=conn.prepareStatement(sql);
				//���ò���
					ps.setInt(1, id);
				//ִ��sql
				 rs=ps.executeQuery();
				if(rs.next()){
					
					goods.setName(rs.getString("name"));
					goods.setId(rs.getInt("id"));
					goods.setPrice(rs.getDouble("price"));
					goods.setPnum(rs.getInt("pnum"));
					goods.setType(rs.getString("type"));
					goods.setImgurl(rs.getString("imgurl"));
					goods.setDescription(rs.getString("description"));
					goods.setPrice2(rs.getDouble("price2"));
					
				}
				return goods;
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("����id��ѯ��Ʒʧ�ܣ�");
					
				}finally {
					//�ر���Դ
					JDBCUtils.close(conn, ps, rs);
				}	}


	public void update(Goods goods) {
		boolean flag=goods.getImgurl()!=null;
		//1�������
				Connection conn=JDBCUtils.getConnection();
				//2׼��sql
				String sql= "UPDATE `t_goods` SET  `name`=? ,`price`=? ,`pnum`=? ,`description`=?,`type`=? ";
						if(flag){
							sql+=",`imgurl`=?  WHERE  `id`=?";
							}else {
								sql+=" WHERE `id`=?";
							}
				PreparedStatement ps=null;
				try {
					//3���prepareStatemetnt
					ps=conn.prepareStatement(sql);
					//4���ò���
					ps.setString(1, goods.getName());
					ps.setDouble(2, goods.getPrice());
					ps.setInt(3, goods.getPnum());
					ps.setString(4, goods.getDescription());
					ps.setString(5, goods.getType());
					if(flag){
						ps.setString(6, goods.getImgurl());
						ps.setInt(7, goods.getId());
					}else {
						ps.setInt(6, goods.getId());
					}
					
					//ִ��sql
					int rowcount=ps.executeUpdate();
					
					if(rowcount!=1){
						throw new RuntimeException("�޸���Ʒʧ�ܣ�");
					}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
					//�ر���Դ
					JDBCUtils.close(conn, ps, null);
					}
		
	}
	public Goods getByName(String name) {
		Goods goods=new Goods();
//�������
		Connection conn=JDBCUtils.getConnection();
		
		//sql���
		String sql="select * from t_goods where name=?";
		//����prepare statement����
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
		//���ò���
			ps.setString(1, name);
		//ִ��sql
		 rs=ps.executeQuery();
		if(rs.next()){
			
			goods.setName(rs.getString("name"));
			goods.setId(rs.getInt("id"));
			goods.setPrice(rs.getDouble("price"));
			goods.setPnum(rs.getInt("pnum"));
			goods.setType(rs.getString("type"));
			goods.setImgurl(rs.getString("imgurl"));
			goods.setDescription(rs.getString("description"));
			
		}
		return goods;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����name��ѯ��Ʒʧ�ܣ�");
			
		}finally {
			//�ر���Դ
			JDBCUtils.close(conn, ps, rs);
		}	}


	public void delete(Goods goods) {
		
		//1�������
		Connection conn=JDBCUtils.getConnection();
		//2׼��sql
		String sql= "DELETE  FROM `t_goods` WHERE `id` = ?";
				
		PreparedStatement ps=null;
		try {
			//3���prepareStatemetnt
			ps=conn.prepareStatement(sql);
			//4���ò���
			ps.setInt(1, goods.getId());
			
			//ִ��sql
			int rowcount=ps.executeUpdate();
			if(rowcount!=1){
				throw new RuntimeException("ɾ����Ʒʧ�ܣ�");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
			//�ر���Դ
			JDBCUtils.close(conn, ps, null);
			}
	}
}
