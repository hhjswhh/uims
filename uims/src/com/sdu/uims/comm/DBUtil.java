package com.sdu.uims.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost/uims?useUnicode=true&characterEncoding=UTF-8&mysqlEncoding=utf8";
	private static final String USER="root";
	private static final String PASS="mysql";
	private static Connection con =null;
	static{
		//1.加载数据库驱动
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获得preparedStatement对象
	 * 
	 * @param sql 执行的sql语句
	 * @return 返回preparedStatement对象
	 */
	public static PreparedStatement getConPst(String sql){
		PreparedStatement pst = null;
		try {
			//2.建立连接
			if(con==null){
				con = DriverManager.getConnection(URL, USER, PASS);
			}
			//3.创建声明PreparedStatement对象
			pst = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pst;
	}
	
	/**
	 * 获得connection对象
	 * 
	 * @return
	 */
	public static Connection getCon() {
		//2.建立连接
		try {
			if(con==null){
				con = DriverManager.getConnection(URL, USER, PASS);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	/**
	 * 关闭数据相关的对象
	 * @param st1
	 * @param rs1
	 */
	public static void close(PreparedStatement st1,ResultSet rs1){
		close(con, st1, rs1);
	}
	/**
	 * 关闭数据相关的对象
	 * @param con1 连接对象
	 * @param st1 PreparedStatement 对象
	 * @param rs1 结果集对象，如果没有结果集对，就传null
	 */
	public static void close(Connection con1,PreparedStatement st1,ResultSet rs1){
		try {
			if(rs1!=null){
			rs1.close();
			}
			if(st1!=null){
				st1.close();
			}
			if(con1!=null){
				con1.close();
				con=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
