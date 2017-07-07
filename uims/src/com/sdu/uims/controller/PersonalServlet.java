package com.sdu.uims.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdu.uims.dao.InfoDao;
import com.sdu.uims.dao.MessageDao;
import com.sdu.uims.dao.UserDao;
import com.sdu.uims.vo.Info;
import com.sdu.uims.vo.Message;
import com.sdu.uims.vo.User;

public class PersonalServlet extends HttpServlet {

	UserDao userdao;
	InfoDao infodao;
	MessageDao messagedao;

	
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

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String methodNum = request.getParameter("methodNum");
		if("1".equals(methodNum))//Logout
		{
			
		}else if("2".equals(methodNum))//change User Data
		{
			//找到用户是谁
			HttpSession session = request.getSession();
			String ph = (String) session.getAttribute("loginPhone");
			//接收新消息
			String username = request.getParameter("username");
			String userSex = request.getParameter("userSex");
		//默认登录名不能修改		String userPhn = request.getParameter("userPhn");
			String userMail = request.getParameter("userMail");
			String userAddr = request.getParameter("userAddr");
			String userImg = request.getParameter("userImg");
			
			String result = userdao.changeUserData(username, userSex, ph, userMail, userAddr, userImg);
			//给页面返回结果
			request.setAttribute("changeResult", result);//在页面中查询这个变量的值，如果有值则按照提示进行提醒，如果没有？为某个值？，则正常显示
			request.getRequestDispatcher("ModifyPersonalInfo.jsp").forward(request, response);
			
		}else if("3".equals(methodNum))//change Password
		{
			//找到用户是谁
			HttpSession session = request.getSession();
			String ph = (String) session.getAttribute("loginPhone");
			//获取参数
			String oldPwd = request.getParameter("oldPwd");//??? I don't need it!
			String newPwd1 = request.getParameter("newPwd1");
			String newPwd2 = request.getParameter("newPwd2");
			//调用方法验证密码
			String result = userdao.validatePwd(ph, oldPwd, newPwd1,newPwd2);
			//给页面返回结果
			request.setAttribute("changeResult", result);//在页面中查询这个变量的值，如果有值则按照提示进行提醒，如果没有？为某个值？，则正常显示
			request.getRequestDispatcher("ModifyPassword.jsp").forward(request, response);
			
		}else if("4".equals(methodNum))//get history information list
		{
			//get username??? id??  from cookie??
			HttpSession session = request.getSession();
			String ph = (String) session.getAttribute("loginPhone");
			//show this in page HistoryMessage.jsp
			/**
			 * 
			 * ----------------------------------------------------------------------------------
			 */
			 String page = null;
		        page = request.getParameter("page");//从 HistoryMessage.jsp 页面获得的参数 page表明当前页
		        if(page == null || page==""){
		            page = "1";
		        }
		        InfoDao infodao = new InfoDao();
		        request.setAttribute("info",infodao.findByPage(Integer.parseInt(page),ph));//给属性info一个ArrayList的值
		        request.setAttribute("pagenum",infodao.infoCount()/5+1);//总页数
		        request.setAttribute("page", page);//当前页     在jsp中实现对Page的更改操作，按下一页则传递的page+1
		        request.getRequestDispatcher("HistoryMessage.jsp").forward(request, response);    
		        
		        /**
		         * -------------------------------------------------------------------------
		         *
		         *配合使用的jsp
		         *
		         *<table id="t_stu" border="1" cellpadding="2" cellspacing="0">
    <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>电话</th>
            <th>成绩</th>
        </tr>
    </thead>
    <c:forEach items="${student}" var="st">
        <tr>
            <td>${st.getId()}</td>
            <td>${st.getName()}</td>
            <td>${st.getAge()}</td>
            <td>${st.getPhone()}</td>
            <td>${st.getScore()}</td>
        </tr>
    </c:forEach>
</table>
<br>
共 ${pagenum}页   当前 第${page}页 
<c:choose>
    <c:when test="${page>1}">
        <a href="getSutent?page=${page-1}"><input type="button" value="上一页" ></a>
    </c:when>
    <c:otherwise>
        <input type="button" value="上一页"  disabled="disabled" />
    </c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${page!=pagenum}">
        <a href="getSutent?page=${page+1}"><input type="button" value="下一页"></a>
    </c:when>
    <c:otherwise>
        <input type="button" value="下一页" disabled="disabled" />
    </c:otherwise>
</c:choose>
		         */
		        /**
		         * 
		         * 
		         * -------------------------------------------------------------------------
		         */
			
		}else if("5".equals(methodNum))//get message list
		{
			//get username??  from cookie??
			HttpSession session = request.getSession();
			String ph = (String) session.getAttribute("loginPhone");
			//show this in InteractMessage.jsp page 
			 String page = null;
		        page = request.getParameter("page");//从 HistoryMessage.jsp 页面获得的参数 page表明当前页
		        if(page == null || page==""){
		            page = "1";
		        }
		        MessageDao messagedao = new MessageDao();
		        request.setAttribute("message",messagedao.findByPage(Integer.parseInt(page),ph));//给属性info一个ArrayList的值
		        request.setAttribute("pagenum",messagedao.messageCount()/5+1);//总页数
		        request.setAttribute("page", page);//当前页     在jsp中实现对Page的更改操作，按下一页则传递的page+1
		        request.getRequestDispatcher("InteractMessage.jsp").forward(request, response);    
			
		}else//error
		{
			System.out.println("selecting method happend error");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		userdao = new UserDao();
		infodao = new InfoDao();
		messagedao = new MessageDao();
	}
	
}
