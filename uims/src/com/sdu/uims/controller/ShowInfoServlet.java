package com.sdu.uims.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sdu.uims.dao.InfoDao;

/**
 * ��Ĺ��ܣ�
 * @version v1.0
 * @author �����
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
		
		String type=request.getParameter("type");//��ȡ���������Ϣ������
		String id=request.getParameter("ID");//��ȡ���������Ϣ��ID
		/**
		 * ����ȡ���ľ�����Ϣ���ݽ�������浽���ö���nameΪSpInfo��request��
		 */
		  request.setAttribute("SpInfo", InfoDao.getRst(id));
		 	
		/**
		 * ����ȡ����������Ϣ�б��������浽���ö���nameΪSimInfo��request��
		 */
		request.setAttribute("SimInfo",InfoDao.getSimRS(type,id));
		
		//��ת��ǰ�˴���ҳ�棬ʹ�ñ���ת��ʽ���Ա�����ҳ���request�е���Ϣ����
		request.getRequestDispatcher("testRS.jsp").forward(request, response);
	}

}
