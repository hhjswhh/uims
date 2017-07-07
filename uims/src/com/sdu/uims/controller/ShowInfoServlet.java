package com.sdu.uims.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sdu.uims.dao.InfoDao;

/**
 * 类的功能：
 * @version v1.0
 * @author 黄余杰
 * 
 *
 */
public class ShowInfoServlet extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		
		String type=request.getParameter("type");//获取所点击的消息的类型
		String id=request.getParameter("ID");//获取所点击的消息的ID
		/**
		 * 将获取到的具体信息内容结果集保存到内置对象name为SpInfo的request中
		 */
		  request.setAttribute("SpInfo", InfoDao.getRst(id));
		 	
		/**
		 * 将获取到的相似信息列表结果集保存到内置对象name为SimInfo的request中
		 */
		request.setAttribute("SimInfo",InfoDao.getSimRS(type,id));
		
		//跳转到前端处理页面，使用本跳转方式可以保留本页面的request中的信息内容
		request.getRequestDispatcher("testRS.jsp").forward(request, response);
	}

}
