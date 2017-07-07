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
		//����request�ı��뷽ʽ
		request.setCharacterEncoding("utf-8");	
		//��ǰ̨�����Ӻ�����ŵĲ�������
		String type=request.getParameter("type");
		//�������в�ѯ���ݵ�list�б���󱣴浽���ö���request��
		request.setAttribute("RS",InfoDao.getRS(type));
		
		/**
		 * �ӵ�ǰҳ����ת��ǰ�˵Ľ���ҳ�棬����չʾ���ĳһ���͵���Ϣ����ʾ������Ϣ�����б�
		 */
		request.getRequestDispatcher("testRS.jsp").forward(request, response);
	    	    	
	} 
    
}
