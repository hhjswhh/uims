package com.sdu.uims.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdu.uims.dao.InfoDao;

public class InfoServlet extends HttpServlet {

	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//设置request的编码方式
		request.setCharacterEncoding("utf-8");	
		//从前台的链接后面跟着的参数接收
		String type=request.getParameter("type");
		//将保存有查询内容的list列表对象保存到内置对象request中
		request.setAttribute("RS",InfoDao.getRS(type));
		
		/**
		 * 从当前页面跳转到前端的接收页面，用于展示点击某一类型的消息后，显示出的消息标题列表
		 */
		request.getRequestDispatcher("testRS.jsp").forward(request, response);
	    	    	
	} 
    
}
