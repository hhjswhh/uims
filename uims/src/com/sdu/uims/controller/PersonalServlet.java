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
			//�ҵ��û���˭
			HttpSession session = request.getSession();
			String ph = (String) session.getAttribute("loginPhone");
			//��������Ϣ
			String username = request.getParameter("username");
			String userSex = request.getParameter("userSex");
		//Ĭ�ϵ�¼�������޸�		String userPhn = request.getParameter("userPhn");
			String userMail = request.getParameter("userMail");
			String userAddr = request.getParameter("userAddr");
			String userImg = request.getParameter("userImg");
			
			String result = userdao.changeUserData(username, userSex, ph, userMail, userAddr, userImg);
			//��ҳ�淵�ؽ��
			request.setAttribute("changeResult", result);//��ҳ���в�ѯ���������ֵ�������ֵ������ʾ�������ѣ����û�У�Ϊĳ��ֵ������������ʾ
			request.getRequestDispatcher("ModifyPersonalInfo.jsp").forward(request, response);
			
		}else if("3".equals(methodNum))//change Password
		{
			//�ҵ��û���˭
			HttpSession session = request.getSession();
			String ph = (String) session.getAttribute("loginPhone");
			//��ȡ����
			String oldPwd = request.getParameter("oldPwd");//??? I don't need it!
			String newPwd1 = request.getParameter("newPwd1");
			String newPwd2 = request.getParameter("newPwd2");
			//���÷�����֤����
			String result = userdao.validatePwd(ph, oldPwd, newPwd1,newPwd2);
			//��ҳ�淵�ؽ��
			request.setAttribute("changeResult", result);//��ҳ���в�ѯ���������ֵ�������ֵ������ʾ�������ѣ����û�У�Ϊĳ��ֵ������������ʾ
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
		        page = request.getParameter("page");//�� HistoryMessage.jsp ҳ���õĲ��� page������ǰҳ
		        if(page == null || page==""){
		            page = "1";
		        }
		        InfoDao infodao = new InfoDao();
		        request.setAttribute("info",infodao.findByPage(Integer.parseInt(page),ph));//������infoһ��ArrayList��ֵ
		        request.setAttribute("pagenum",infodao.infoCount()/5+1);//��ҳ��
		        request.setAttribute("page", page);//��ǰҳ     ��jsp��ʵ�ֶ�Page�ĸ��Ĳ���������һҳ�򴫵ݵ�page+1
		        request.getRequestDispatcher("HistoryMessage.jsp").forward(request, response);    
		        
		        /**
		         * -------------------------------------------------------------------------
		         *
		         *���ʹ�õ�jsp
		         *
		         *<table id="t_stu" border="1" cellpadding="2" cellspacing="0">
    <thead>
        <tr>
            <th>ID</th>
            <th>����</th>
            <th>����</th>
            <th>�绰</th>
            <th>�ɼ�</th>
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
�� ${pagenum}ҳ   ��ǰ ��${page}ҳ 
<c:choose>
    <c:when test="${page>1}">
        <a href="getSutent?page=${page-1}"><input type="button" value="��һҳ" ></a>
    </c:when>
    <c:otherwise>
        <input type="button" value="��һҳ"  disabled="disabled" />
    </c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${page!=pagenum}">
        <a href="getSutent?page=${page+1}"><input type="button" value="��һҳ"></a>
    </c:when>
    <c:otherwise>
        <input type="button" value="��һҳ" disabled="disabled" />
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
		        page = request.getParameter("page");//�� HistoryMessage.jsp ҳ���õĲ��� page������ǰҳ
		        if(page == null || page==""){
		            page = "1";
		        }
		        MessageDao messagedao = new MessageDao();
		        request.setAttribute("message",messagedao.findByPage(Integer.parseInt(page),ph));//������infoһ��ArrayList��ֵ
		        request.setAttribute("pagenum",messagedao.messageCount()/5+1);//��ҳ��
		        request.setAttribute("page", page);//��ǰҳ     ��jsp��ʵ�ֶ�Page�ĸ��Ĳ���������һҳ�򴫵ݵ�page+1
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
