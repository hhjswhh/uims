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

public class RegisterServlet extends HttpServlet{

	DBUtil dbUtil=new DBUtil();
	UserDao userDao=new UserDao();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); 
  	  	req.setCharacterEncoding("UTF-8"); 
  	  	HttpSession session=req.getSession();
  	    String registerPhone=req.getParameter("registerPhone");
  	    String registerPassword=req.getParameter("registerPassword"); 
  	    String registerName=req.getParameter("registerName");
  	    String registerSex=req.getParameter("registerSex");
  	    String registerMail=req.getParameter("registerMail");
  	    String registerAddr=req.getParameter("registerAddr");
  	    User user=new User(registerPhone, "1", registerName, registerPassword, "0", registerSex,registerMail, registerAddr, "0");
  	    boolean a=false;
  	    try {
 	    	Connection con=dbUtil.getCon();
 	  	    boolean registerState=userDao.register(con, user);
  	  	    if (registerState) {
  	  	    	session.setAttribute("loginPhone", registerPhone);
  	  	    	session.setAttribute("loginState","1");
  	  	    	session.setAttribute("userType", 0);
  	  	    	session.setAttribute("userName",user.getName());
  	  	    	a=true;
			}
  	  	    else {
  	  	    	session.setAttribute("loginState","0");
  	  	    	a=false;
			}
		} 
  	    catch (SQLException e) {
			e.printStackTrace();
		}
		if (a) 
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
	}
}

