package com.sdu.uims.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// �ϴ��ļ��洢Ŀ¼
	private static final String UPLOAD_DIRECTORY = "iconImg";

	// �ϴ�����
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * �ϴ����ݼ������ļ�
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// �ҵ��û���˭
		HttpSession session = request.getSession();
		String ph = (String) session.getAttribute("loginPhone");
		// �ж��û��Ƿ��¼�����δ��¼����ת����¼ҳ��
		if (ph.equals("") || ph == null) {
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		}
		String methodNum = request.getParameter("methodNum");
		System.out.println(methodNum);
		String username = request.getParameter("username");
		System.out.println(username);

		if ("2".equals(methodNum)) {
			System.out.println("it has been equals");
			request.getRequestDispatcher("/servlet/PersonalServlet").forward(
					request, response);
		} else {
			// ����Ƿ�Ϊ��ý���ϴ�
			if (!ServletFileUpload.isMultipartContent(request)) {
				// ���������ֹͣ
				PrintWriter writer = response.getWriter();
				writer.println("Error: ��������� enctype=multipart/form-data");
				writer.flush();
				return;
			}

			// �����ϴ�����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
			factory.setSizeThreshold(MEMORY_THRESHOLD);
			// ������ʱ�洢Ŀ¼
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

			ServletFileUpload upload = new ServletFileUpload(factory);

			// ��������ļ��ϴ�ֵ
			upload.setFileSizeMax(MAX_FILE_SIZE);

			// �����������ֵ (�����ļ��ͱ�����)
			upload.setSizeMax(MAX_REQUEST_SIZE);

			// ���Ĵ���
			upload.setHeaderEncoding("UTF-8");

			// ������ʱ·�����洢�ϴ����ļ�
			// ���·����Ե�ǰӦ�õ�Ŀ¼
			String uploadPath = getServletContext().getRealPath("./")
					+ File.separator + UPLOAD_DIRECTORY;

			// ���Ŀ¼�������򴴽�
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}

			try {
				// ���������������ȡ�ļ�����
				@SuppressWarnings("unchecked")
				List<FileItem> formItems = upload.parseRequest(request);

				if (formItems != null && formItems.size() > 0) {
					// ����������
					for (FileItem item : formItems) {
						// �����ڱ��е��ֶ�
						if (!item.isFormField()) {
							String fileName = new File(item.getName())
									.getName();
							String filePath = uploadPath + File.separator
									+ fileName;
							File storeFile = new File(filePath);
							// �ڿ���̨����ļ����ϴ�·��
							System.out.println(filePath);
							// �����ļ���Ӳ��
							item.write(storeFile);
							request.setAttribute("message", "�ļ��ϴ��ɹ�!");
							request.setAttribute("userImg", filePath);
							session.setAttribute("userImg", filePath);
						}
					}
				}
			} catch (Exception ex) {
				request.setAttribute("message", "������Ϣ: " + ex.getMessage());
			}
			// ��ת�� message.jsp
			getServletContext().getRequestDispatcher("/message.jsp").forward(
					request, response);
			return;
		}
	}
}