package com.sdu.uims.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.java2d.SunGraphicsEnvironment.TTFilter;

import com.sdu.uims.dao.InfoDao;
import com.sdu.uims.dao.MessageDao;
import com.sdu.uims.dao.UserDao;
import com.sdu.uims.vo.Info;
import com.sdu.uims.vo.Message;
import com.sdu.uims.vo.User;

/**
 * �������⣺ 1.���ݿ�ֵ�Ĵ��� 2.��ӻ�ȡ�ķ��� 3.ʵ��ע������
 * 
 * һЩ���⣺1.ͷ���·�����⣬����Ҫ��ô���
 * 
 * @author Cai_ywei
 * 
 */
public class PersonalServlet extends HttpServlet {

	private UserDao userdao = null;
	private InfoDao infodao = null;
	private MessageDao messagedao = null;
	private HttpSession session = null;
	private String ph = null;
	private String fileName = "default.jpg";
	private static final String UPLOAD_DIRECTORY = "uims\\images";
	private String result = "";

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * ���ݴ����methodNum����������doPost�����еĲ�ͬ���������ִ�в�ͬ�Ĳ���
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");
		// �ҵ��û���˭
		HttpSession session = request.getSession();
		ph = (String) session.getAttribute("loginPhone");
		
		// ---------------------------------��������---
		ph = "01234567890";
		// -----------------------------------------------
		
		// �ж��û��Ƿ��¼�����δ��¼����ת����¼ҳ��
		if (ph == null || ph.equals("")) {
			response.sendRedirect("/uims/homePage/homePage.jsp");//----------------�ĵ�ַ---
		} else {
			String methodNum = request.getParameter("methodNum");

			if ("1".equals(methodNum))// �ǳ�
			{
				logout(request, response);
				
			} else if ("2".equals(methodNum))// �޸��û����ϵķ���
			{
				changeUserData(request, response);

			} else if ("3".equals(methodNum))// �޸�����
			{
				changePassword(request, response);

			} else if ("4".equals(methodNum))// ��ȡ��ʷ��Ϣ�б�
			{
				getInformationList(request, response);

			} else if ("5".equals(methodNum))// ��ȡ��Ϣ�б�
			{
				getMessageList(request, response);

			} else if ("6".equals(methodNum)) // ��ȡ�û���Ϣ
			{
				getUserData(request, response);
			} else if ("7".equals(methodNum)) // �л��û�ͷ��
			{
				changeIconImg(request, response);
				
			} else// δ������ò�����û���ҵ���Ӧ����
			{
				System.out.println("PersonalServlet use method failed");
			}
		}
	}

	
	/**
	 * �ǳ��ķ��� ������doPost�����а���������1
	 * ��δ��¼����ת��login.jsp
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("user method 1");
		//��ȡ��¼״̬�����ж�
		String loginState = (String) session.getAttribute("loginState");
		if (loginState == null || loginState.equals("")) {
			response.sendRedirect("/uims/homePage/homePage.jsp");//----------------------��λ��
		}
		// �ǳ�����,����״̬Ϊ�ǳ�״̬�����õ绰Ϊ��
		if (loginState.equals("1")) {
			session.setAttribute("loginState", "0");
			session.setAttribute("loginPhone", "");
			response.sendRedirect("/uims/homePage/homePage.jsp");//--------------------��λ��
		}
		
	}

	/**
	 * 
	 * �����û����ݣ���doPost�����а���������2
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 
	 * ��ҳ�淵�ؽ��
	 * ���У�userNameNull userSexNull userMailNull userAddrNull 
	 * changeSucceed changeFailed changeError
	 */
	private void changeUserData(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

	
		System.out.println("user method 2");
		// ��������Ϣ
		String userName = request.getParameter("userName");
		String userSex = request.getParameter("userSex");
		// Ĭ�ϵ�¼�������޸� String userPhn = request.getParameter("userPhn");
		String userMail = request.getParameter("userMail");
		String userAddr = request.getParameter("userAddr");
//		String userImg = (String) session.getAttribute("userImg");
		
		// ---------------------------------��������---
		ph = "01234567890";
		String userImg = "";
		// ------------------------------------------

		//�жϴ���ֵ�Ƿ�Ϊ�ա�
		if (userName == null || userName.equals("")){
			result = "userNameNull";
			request.setAttribute("changeResult", result);
		}
		if (userSex == null || userSex.equals("")){
			result = "userSexNull";
			request.setAttribute("changeResult", result);
		}
		if (userMail == null || userMail.equals("")){
			result = "userMailNull";
			request.setAttribute("changeResult", result);
		}
		if (userAddr == null || userAddr.equals("")){
			result = "userAddrNull";
			request.setAttribute("changeResult", result);
		}
		// ���µ�ͼƬ��ַΪ��������ͼƬ��ַΪĬ�ϵ�ַ
		if (userImg == null || userImg.equals("")) {
			userImg = getServletContext().getRealPath("./") + File.separator
					+ UPLOAD_DIRECTORY + File.separator + fileName;
		}
		
		System.out.println(userImg);
		result = userdao.changeUserData(userName, userSex, ph, userMail,
				userAddr, userImg);
		// ��ҳ�淵�ؽ��
		// ���У�userNameNull userSexNull userMailNull userAddrNull 
		// changeSucceed changeFailed changeError
		request.setAttribute("changeResult", result);// ��ҳ���в�ѯ���������ֵ�������ֵ������ʾ�������ѣ����û�У�Ϊĳ��ֵ������������ʾ
		request.getRequestDispatcher(
				"/servlet/PersonalServlet?methodNum=6").forward(
				request, response);
	}

	/**
	 * �޸�����ķ�������doPost�����а���������3
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 
	 * ��ҳ�淵�ؽ��
	 * ���У�oldPwdNull newPwd1Null newPwd2Null NotSame WrongPwd 
	 * validatePwdFailed changeSucceed changeFailed changeError
	 */
	private void changePassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("user method 3");
		// ��ȡ����
		String oldPwd = null; oldPwd = request.getParameter("oldPwd");
		String newPwd1 = null; newPwd1 = request.getParameter("newPwd1");
		String newPwd2 = null; newPwd2 = request.getParameter("newPwd2");
		
		// ---------------------------------��������---
		ph = "01234567890";
		// oldPwd="123456";
		// newPwd1 = "1234567";
		// newPwd2 = "1234567";
		// ------------------------------------------

		// ��ǰ�˷���changeResult���ԣ�ֵΪoldPwdNull,��������ľ�����Ϊ��
		if (oldPwd == null || oldPwd.equals("")) {
			result = "oldPwdNull";
			request.setAttribute("changeResult", result);
			request.getRequestDispatcher("/uims/pages/personalCenter/modifyPassword.jsp");
		}
		// ��ǰ�˷���changeResult���ԣ�ֵΪnewPwd2Null,���������������Ϊ��
		if (newPwd1 == null || newPwd1.equals("")) {
			result = "newPwd1Null";
			request.setAttribute("changeResult", result);
			request.getRequestDispatcher("/uims/pages/personalCenter/modifyPassword.jsp");
		}
		// ��ǰ�˷���changeResult���ԣ�ֵΪnewPwd2Null,�����ظ����������Ϊ��
		if (newPwd2 == null || newPwd2.equals("")) {
			result = "newPwd2Null";
			request.setAttribute("changeResult", result);
			request.getRequestDispatcher("/uims/pages/personalCenter/modifyPassword.jsp");
		}
		// ���÷�����֤����
		result = userdao.validatePwd(ph, oldPwd, newPwd1, newPwd2);
		// ��ҳ�淵�ؽ��
		// ���У�oldPwdNull newPwd1Null newPwd2Null NotSame WrongPwd 
		// validatePwdFailed changeSucceed changeFailed changeError
		request.setAttribute("changeResult", result);// ��ҳ���в�ѯ���������ֵ�������ֵ������ʾ�������ѣ����û�У�Ϊĳ��ֵ������������ʾ
		request.getRequestDispatcher(
				"/uims/pages/personalCenter/modifyPassword.jsp").forward(
				request, response);
	}

	/**
	 * ��ȡ��ʷ������Ϣ�ķ�������doPost�����а���������4
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getInformationList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		// ---------------------------------��������---
		ph = "01234567890";
		// ------------------------------------------
		
		System.out.println("user method 4");
		// show this in page HistoryMessage.jsp
		String page = null;
		page = (String)request.getParameter("page");// �� HistoryMessage.jsp ҳ���õĲ���
											// page������ǰҳ
		int pagenum = infodao.infoCount(ph)/5 + 1;
		if (page == null || page == "" || Integer.parseInt(page)<=0) {
			page = "1";
		}
		System.out.println("total: "+pagenum);
		if(Integer.parseInt(page) > pagenum){
			page = Integer.toString(pagenum);
		}
		InfoDao infodao = new InfoDao();
		System.out.println("current page: "+page);
		request.setAttribute("info",
				infodao.findByPage(Integer.parseInt(page), ph));// ������infoһ��ArrayList��ֵ
		request.setAttribute("pagenum", pagenum);// ��ҳ��
		request.setAttribute("page", page);// ��ǰҳ
											// ��jsp��ʵ�ֶ�Page�ĸ��Ĳ���������һҳ�򴫵ݵ�page+1
		request.getRequestDispatcher(
				"/uims/pages/personalCenter/historyMessage.jsp").forward(
				request, response);
	}

	/**
	 * ��ȡ�����Ϣ�б�ķ�������doPost�����а���������5
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getMessageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// ---------------------------------��������---
		ph = "01234567890";
		// ------------------------------------------
		
		System.out.println("user method 5");
		// show this in InteractMessage.jsp page
		String page = null;
		int pagenum = messagedao.messageCount(ph)/5 + 1;
		page = request.getParameter("page");// �� HistoryMessage.jsp ҳ���õĲ���
											// page������ǰҳ
		if (page == null || page == "" || Integer.parseInt(page)<=0) {
			page = "1";
		}
		if(Integer.parseInt(page) > pagenum){
			page = Integer.toString(pagenum);
		}
		MessageDao messagedao = new MessageDao();
		request.setAttribute("message",
				messagedao.findByPage(Integer.parseInt(page), ph));// ������infoһ��ArrayList��ֵ
		request.setAttribute("pagenum", pagenum);// ��ҳ��
		request.setAttribute("page", page);// ��ǰҳ
											// ��jsp��ʵ�ֶ�Page�ĸ��Ĳ���������һҳ�򴫵ݵ�page+1
		request.getRequestDispatcher(
				"/uims/pages/personalCenter/interactMessage.jsp").forward(
				request, response);
	}

	/**
	 * 
	 * ��ȡ�û����ݵķ�������doPost�����а���������6
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getUserData(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ---------------------------------��������---
		ph = "01234567890";
		// ------------------------------------------
		System.out.println("use method 6 get user data");
		User user = new User();
		user = userdao.getUser(ph);
		System.out.println("Method 6 User name "+user.getName());
		request.setAttribute("userdata", user);
		request.getRequestDispatcher("/uims/pages/personalCenter/modifyPersonalInfo.jsp").forward(request, response);
	}

	private void changeIconImg(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// -------------------------------------��������----
		request.setAttribute("loginPhone", "01234567890");
		// ----------------------------------------------
		System.out.println("use method 6");
		request.getRequestDispatcher("/servlet/UploadServlet").forward(request,
				response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		userdao = new UserDao();
		infodao = new InfoDao();
		messagedao = new MessageDao();
	}

}
