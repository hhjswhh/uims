package com.sdu.uims.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdu.uims.comm.DBUtil;
import com.sdu.uims.dao.UserDao;
import com.sdu.uims.vo.User;

public class LoginServlet extends HttpServlet{
	
	DBUtil dbUtil=new DBUtil();
	UserDao userDao=new UserDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action.equals("login")){
			login(req, resp);
		}else{
			System.out.println("ÍË³ö");
		}
	}
	
	/**
	 *  µÇÂ¼·½·¨
	 * @param req
	 * @param resp
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp){
		String loginPhone=req.getParameter("username");
		String loginPassword=req.getParameter("loginPassword");
		String loginType="0";
		HttpSession session=req.getSession();
		session.setAttribute("loginPhone", loginPhone);
		session.setAttribute("loginPassword", loginPassword);
		try {
			User user=new User(loginPhone,loginPassword,loginType);
			User currentUser=userDao.login(user);
			if (currentUser==null) {
				session.setAttribute("loginState", 0);
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			}
			else {
				session.setAttribute("loginState", 1);
				if (currentUser.getType().equals("1")) 
					session.setAttribute("userType", 1);
				else 
					session.setAttribute("userType", 0);
				session.setAttribute("userName", currentUser.getName());
				req.getRequestDispatcher("uims/main.jsp").forward(req, resp);
			}
		}catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
