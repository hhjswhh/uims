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
 * 代办问题： 1.传递空值的处理 2.添加获取的方法 3.实现注销功能
 * 
 * 一些问题：1.头像的路径问题，到底要怎么解决
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
	 * 根据传入的methodNum参数，调用doPost方法中的不同的条件语句执行不同的操作
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
		// 找到用户是谁
		HttpSession session = request.getSession();
		ph = (String) session.getAttribute("loginPhone");
		
		// ---------------------------------测试数据---
		ph = "01234567890";
		// -----------------------------------------------
		
		// 判断用户是否登录，如果未登录则跳转到登录页面
		if (ph == null || ph.equals("")) {
			response.sendRedirect("/uims/homePage/homePage.jsp");//----------------改地址---
		} else {
			String methodNum = request.getParameter("methodNum");

			if ("1".equals(methodNum))// 登出
			{
				logout(request, response);
				
			} else if ("2".equals(methodNum))// 修改用户资料的方法
			{
				changeUserData(request, response);

			} else if ("3".equals(methodNum))// 修改密码
			{
				changePassword(request, response);

			} else if ("4".equals(methodNum))// 获取历史消息列表
			{
				getInformationList(request, response);

			} else if ("5".equals(methodNum))// 获取消息列表
			{
				getMessageList(request, response);

			} else if ("6".equals(methodNum)) // 获取用户信息
			{
				getUserData(request, response);
			} else if ("7".equals(methodNum)) // 切换用户头像
			{
				changeIconImg(request, response);
				
			} else// 未传入可用参数，没有找到相应方法
			{
				System.out.println("PersonalServlet use method failed");
			}
		}
	}

	
	/**
	 * 登出的方法 ，，在doPost方法中按参数调用1
	 * 若未登录则跳转到login.jsp
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		System.out.println("user method 1");
		//获取登录状态，并判断
		String loginState = (String) session.getAttribute("loginState");
		if (loginState == null || loginState.equals("")) {
			response.sendRedirect("/uims/homePage/homePage.jsp");//----------------------改位置
		}
		// 登出操作,设置状态为登出状态，设置电话为空
		if (loginState.equals("1")) {
			session.setAttribute("loginState", "0");
			session.setAttribute("loginPhone", "");
			response.sendRedirect("/uims/homePage/homePage.jsp");//--------------------改位置
		}
		
	}

	/**
	 * 
	 * 更改用户数据，在doPost方法中按参数调用2
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 
	 * 给页面返回结果
	 * 共有：userNameNull userSexNull userMailNull userAddrNull 
	 * changeSucceed changeFailed changeError
	 */
	private void changeUserData(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		

	
		System.out.println("user method 2");
		// 接收新消息
		String userName = request.getParameter("userName");
		String userSex = request.getParameter("userSex");
		// 默认登录名不能修改 String userPhn = request.getParameter("userPhn");
		String userMail = request.getParameter("userMail");
		String userAddr = request.getParameter("userAddr");
//		String userImg = (String) session.getAttribute("userImg");
		
		// ---------------------------------测试数据---
		ph = "01234567890";
		String userImg = "";
		// ------------------------------------------

		//判断传入值是否为空。
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
		// 若新的图片地址为空则设置图片地址为默认地址
		if (userImg == null || userImg.equals("")) {
			userImg = getServletContext().getRealPath("./") + File.separator
					+ UPLOAD_DIRECTORY + File.separator + fileName;
		}
		
		System.out.println(userImg);
		result = userdao.changeUserData(userName, userSex, ph, userMail,
				userAddr, userImg);
		// 给页面返回结果
		// 共有：userNameNull userSexNull userMailNull userAddrNull 
		// changeSucceed changeFailed changeError
		request.setAttribute("changeResult", result);// 在页面中查询这个变量的值，如果有值则按照提示进行提醒，如果没有？为某个值？，则正常显示
		request.getRequestDispatcher(
				"/servlet/PersonalServlet?methodNum=6").forward(
				request, response);
	}

	/**
	 * 修改密码的方法，在doPost方法中按参数调用3
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 
	 * 给页面返回结果
	 * 共有：oldPwdNull newPwd1Null newPwd2Null NotSame WrongPwd 
	 * validatePwdFailed changeSucceed changeFailed changeError
	 */
	private void changePassword(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("user method 3");
		// 获取参数
		String oldPwd = null; oldPwd = request.getParameter("oldPwd");
		String newPwd1 = null; newPwd1 = request.getParameter("newPwd1");
		String newPwd2 = null; newPwd2 = request.getParameter("newPwd2");
		
		// ---------------------------------测试数据---
		ph = "01234567890";
		// oldPwd="123456";
		// newPwd1 = "1234567";
		// newPwd2 = "1234567";
		// ------------------------------------------

		// 给前端返回changeResult属性，值为oldPwdNull,表明输入的旧密码为空
		if (oldPwd == null || oldPwd.equals("")) {
			result = "oldPwdNull";
			request.setAttribute("changeResult", result);
			request.getRequestDispatcher("/uims/pages/personalCenter/modifyPassword.jsp");
		}
		// 给前端返回changeResult属性，值为newPwd2Null,表明输入的新密码为空
		if (newPwd1 == null || newPwd1.equals("")) {
			result = "newPwd1Null";
			request.setAttribute("changeResult", result);
			request.getRequestDispatcher("/uims/pages/personalCenter/modifyPassword.jsp");
		}
		// 给前端返回changeResult属性，值为newPwd2Null,表明重复输入的密码为空
		if (newPwd2 == null || newPwd2.equals("")) {
			result = "newPwd2Null";
			request.setAttribute("changeResult", result);
			request.getRequestDispatcher("/uims/pages/personalCenter/modifyPassword.jsp");
		}
		// 调用方法验证密码
		result = userdao.validatePwd(ph, oldPwd, newPwd1, newPwd2);
		// 给页面返回结果
		// 共有：oldPwdNull newPwd1Null newPwd2Null NotSame WrongPwd 
		// validatePwdFailed changeSucceed changeFailed changeError
		request.setAttribute("changeResult", result);// 在页面中查询这个变量的值，如果有值则按照提示进行提醒，如果没有？为某个值？，则正常显示
		request.getRequestDispatcher(
				"/uims/pages/personalCenter/modifyPassword.jsp").forward(
				request, response);
	}

	/**
	 * 获取历史发布信息的方法，在doPost方法中按参数调用4
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getInformationList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		// ---------------------------------测试数据---
		ph = "01234567890";
		// ------------------------------------------
		
		System.out.println("user method 4");
		// show this in page HistoryMessage.jsp
		String page = null;
		page = (String)request.getParameter("page");// 从 HistoryMessage.jsp 页面获得的参数
											// page表明当前页
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
				infodao.findByPage(Integer.parseInt(page), ph));// 给属性info一个ArrayList的值
		request.setAttribute("pagenum", pagenum);// 总页数
		request.setAttribute("page", page);// 当前页
											// 在jsp中实现对Page的更改操作，按下一页则传递的page+1
		request.getRequestDispatcher(
				"/uims/pages/personalCenter/historyMessage.jsp").forward(
				request, response);
	}

	/**
	 * 获取审核消息列表的方法，在doPost方法中按参数调用5
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getMessageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// ---------------------------------测试数据---
		ph = "01234567890";
		// ------------------------------------------
		
		System.out.println("user method 5");
		// show this in InteractMessage.jsp page
		String page = null;
		int pagenum = messagedao.messageCount(ph)/5 + 1;
		page = request.getParameter("page");// 从 HistoryMessage.jsp 页面获得的参数
											// page表明当前页
		if (page == null || page == "" || Integer.parseInt(page)<=0) {
			page = "1";
		}
		if(Integer.parseInt(page) > pagenum){
			page = Integer.toString(pagenum);
		}
		MessageDao messagedao = new MessageDao();
		request.setAttribute("message",
				messagedao.findByPage(Integer.parseInt(page), ph));// 给属性info一个ArrayList的值
		request.setAttribute("pagenum", pagenum);// 总页数
		request.setAttribute("page", page);// 当前页
											// 在jsp中实现对Page的更改操作，按下一页则传递的page+1
		request.getRequestDispatcher(
				"/uims/pages/personalCenter/interactMessage.jsp").forward(
				request, response);
	}

	/**
	 * 
	 * 获取用户数据的方法，在doPost方法中按参数调用6
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getUserData(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ---------------------------------测试数据---
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

		// -------------------------------------测试用例----
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
