package com.chen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chen.bean.Goods;
import com.chen.dao.GoodsDao;
import com.chen.utils.JDBCUtils;



public class GoodsDaoImpl implements GoodsDao {

	public List<Goods> getALL() {
		//获得连接
		Connection conn=JDBCUtils.getConnection();
		List<Goods> list=new ArrayList<Goods>();
		//sql语句
		String sql="select * from t_goods";
		//创建prepare statement对象
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
		
		//执行sql
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
			list.add(goods);
		}
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询商品失败！");
			
		}finally {
			//关闭资源
			JDBCUtils.close(conn, ps, rs);
		}
	}

	public void addGoods(Goods goods) {
		//1获得连接
		Connection conn=JDBCUtils.getConnection();
		//2准备sql
		String sql= "INSERT INTO `t_goods` VALUES (NULL,?,?,?,?,?,?);";
		PreparedStatement ps=null;
		try {
			//3获得prepareStatemetnt
			ps=conn.prepareStatement(sql);
			//4设置参数
			ps.setString(1, goods.getName());
			ps.setDouble(2, goods.getPrice());
			ps.setInt(3, goods.getPnum());
			ps.setString(4, goods.getDescription());
			ps.setString(5, goods.getType());
			ps.setString(6, goods.getImgurl());
			//执行sql
			int rowcount=ps.executeUpdate();
			if(rowcount!=1){
				throw new RuntimeException("添加商品失败！");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
			//关闭资源
			JDBCUtils.close(conn, ps, null);
			}
		}


	public Goods getById(int id) {
				Goods goods=new Goods();
		//获得连接
				Connection conn=JDBCUtils.getConnection();
				
				//sql语句
				String sql="select * from t_goods where id=?";
				//创建prepare statement对象
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					ps=conn.prepareStatement(sql);
				//设置参数
					ps.setInt(1, id);
				//执行sql
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
					throw new RuntimeException("根据id查询商品失败！");
					
				}finally {
					//关闭资源
					JDBCUtils.close(conn, ps, rs);
				}	}


	public void update(Goods goods) {
		boolean flag=goods.getImgurl()!=null;
		//1获得连接
				Connection conn=JDBCUtils.getConnection();
				//2准备sql
				String sql= "UPDATE `t_goods` SET  `name`=? ,`price`=? ,`pnum`=? ,`description`=?,`type`=? ";
						if(flag){
							sql+=",`imgurl`=?  WHERE  `id`=?";
							}else {
								sql+=" WHERE `id`=?";
							}
				PreparedStatement ps=null;
				try {
					//3获得prepareStatemetnt
					ps=conn.prepareStatement(sql);
					//4设置参数
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
					
					//执行sql
					int rowcount=ps.executeUpdate();
					if(rowcount!=1){
						throw new RuntimeException("修改商品失败！");
					}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
					//关闭资源
					JDBCUtils.close(conn, ps, null);
					}
		
	}


	public void delete(Goods goods) {
		
		//1获得连接
		Connection conn=JDBCUtils.getConnection();
		//2准备sql
		String sql= "DELETE  FROM `t_goods` WHERE `id` = ?";
				
		PreparedStatement ps=null;
		try {
			//3获得prepareStatemetnt
			ps=conn.prepareStatement(sql);
			//4设置参数
			ps.setInt(1, goods.getId());
			
			//执行sql
			int rowcount=ps.executeUpdate();
			if(rowcount!=1){
				throw new RuntimeException("删除商品失败！");
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
			//关闭资源
			JDBCUtils.close(conn, ps, null);
			}
	}
}
