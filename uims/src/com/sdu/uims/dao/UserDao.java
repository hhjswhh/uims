package com.sdu.uims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sdu.uims.comm.DBUtil;
import com.sdu.uims.vo.User;

public class UserDao {
	DBUtil db = new DBUtil();
	 /**
	 * @param ph
	 *            根据手机号获取用户信息
	 * @return 返回一个User对象，对象获取了该手机号用户的信息
	 */
	public User getUser(String ph) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select * from T_SYS_USER where m_ph='" + ph + "';";
		try {
			pstm = db.getConPst(sql);
			rs = pstm.executeQuery();

			user = new User();
			if (rs.next()) {
				user.setAddr(rs.getString("m_addr"));
				user.setDeleteState(rs.getString("m_delete"));
				user.setImg(rs.getString("m_img"));
				user.setMail(rs.getString("m_mail"));
				user.setName(rs.getString("m_name"));
				user.setPassword(rs.getString("m_pwd"));
				user.setPhone(rs.getString("m_ph"));
				user.setSex(rs.getString("m_sex"));
				user.setType(rs.getString("m_type"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(pstm, rs);
		}
		return user;
	}
	
	/**
	 * 此方法负责验证是否能修改密码，分三部分：一、两次密码不同 二、可以修改 三、旧密码不对
	 * 
	 * @param ph
	 *            用户手机号
	 * @param oldPwd
	 *            以前的密码，用于验证
	 * @param newPwd1
	 *            新密码，需要替换原先的密码
	 * @param newPwd2
	 *            新密码，用于验证两次输入是否正确，防止输入出错
	 * @return 两次密码不正确返回 "NotSame" 原密码错误返回 "WrongPwd" 修改密码之后返回 "changeSuceed"
	 *         修改未成功返回 "changeFailed" 逻辑出错 "validatePwdFailed" "changeError"
	 */
	public String validatePwd(String ph, String oldPwd, String newPwd1,
			String newPwd2) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		if (!newPwd1.equals(newPwd2)) {// 两次密码输入不正确
			return "NotSame";
		} else {
			String sql = "select m_pwd from T_SYS_USER where m_ph='" + ph + "';";
			try {
				pstm = db.getConPst(sql);
				pstm.execute();
				rs = pstm.getResultSet();
				rs.next();
				String pwd = rs.getString(1);
				
				if (pwd != null && oldPwd.equals(pwd)) {
					return changePwd(ph, newPwd1);
				} else {
					return "WrongPwd";
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.close(pstm, rs);
			}
		}

		return "validatePwdFailed";

	}
	
	/**
	 * 若之前密码验证正确则使用此方法连接数据库修改密码
	 * 
	 * @param ph
	 *            用户手机号
	 * @param newPwd
	 *            新密码，需要替换原先的密码
	 * @return 修改密码之后返回 "changeSucceed" 修改未成功返回 "changeFailed" 逻辑出错"changeError"
	 */
	public String changePwd(String ph, String newPwd) {
		PreparedStatement pstm = null;
		int result = -10;
		String sql = "UPDATE T_SYS_USER SET m_pwd='" + newPwd
				+ "' WHERE m_ph='" + ph + "';";

		try {
			pstm = db.getConPst(sql);
			pstm.execute();
			result = pstm.getUpdateCount();
			if (result > 0) {
				return "changeSucceed";
			} else {
				return "changeFailed";
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			db.close(pstm, null);
		}

		return "changeError";
	}
	
	/**
	 * 对个人信息进行修改，接受从网页获取的参数。
	 * 
	 * @param username
	 *            新昵称
	 * @param userSex
	 *            新性别
	 * @param userPhn
	 *            主键用于查询
	 * @param userMail
	 *            新邮箱
	 * @param userAddr
	 *            新地址
	 * @param userImg
	 *            新头像位置
	 * 
	 * @return 修改资料成功之后返回 "changeSucceed" 修改未成功返回 "changeFailed"
	 *         逻辑出错"changeError"
	 */
	public String changeUserData(String username, String userSex,
			String userPhn, String userMail, String userAddr, String userImg) {

		PreparedStatement pstm = null;
		int result = -10;
		char sex = '1';
		if("male".equals(userSex)){
			sex = '0';
		}else{
			sex = '1';
		}
		String sql = "UPDATE T_SYS_USER SET m_name='" + username + "', m_sex='"
				+ sex + "', m_mail='" + userMail + "', m_addr='" + userAddr
				+ "', m_img='" + userImg + "' WHERE m_ph='" + userPhn + "';";

		try {
			pstm = db.getConPst(sql);
			pstm.execute();
			result = pstm.getUpdateCount();
			if (result > 0) {
				return "changeSucceed";
			} else {
				return "changeFailed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(pstm, null);
		}

		return "changeError";
	}
	public User login(User user){
		User resultUser=null;
		String sql="select * from T_SYS_USER where m_ph=? and m_pwd=? and m_type=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		try {
			con=DBUtil.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getType());
		    rs=ps.executeQuery();
			if (rs.next()) {
				resultUser=new User();
				resultUser.setName(rs.getString("m_name"));
				resultUser.setType(rs.getString("m_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(con, ps, rs);
		}
		return resultUser;
	}
	
	
	public boolean register(Connection con,User user) throws SQLException
	{
		User resultUser=null;
		String sql="select * from T_SYS_USER where m_ph=? and m_delete='0'";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user.getPhone());
		System.out.println(user.getPhone());
		ResultSet rs=ps.executeQuery();
		int i=0;
		if (rs.next()) {
			 resultUser=new User();
            resultUser.setPassword("1");
		}
		if (resultUser!=null) {
			return false;
		}
		else {
			String sql2="insert into T_SYS_USER values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps2=con.prepareStatement(sql2);
			ps2.setString(1, user.getPhone());
			ps2.setString(2, user.getImg());
			ps2.setString(3, user.getName());
			ps2.setString(4, user.getSex());
			ps2.setString(5, user.getMail());
			ps2.setString(6, user.getAddr());
			ps2.setString(7, user.getPassword());
			ps2.setString(8, user.getType());
			ps2.setString(9, user.getDeleteState());
			i=ps2.executeUpdate();
			System.out.println(i);
			return true;
		}
		
	}
}
