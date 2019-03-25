package com.game.test.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String savePath = "D:\\study\\workspace\\game-jsp\\WebContent\\upload";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.replace("/gboard/", "");
		if("insert".equals(uri)) {
			DiskFileItemFactory dfiFactory = new DiskFileItemFactory();
			String tempPath = System.getProperty("java.io.tmpdir");
			File tempFile = new File(tempPath);
			dfiFactory.setRepository(tempFile);
			dfiFactory.setSizeThreshold(10*1024*1024);
			ServletFileUpload sfu = new ServletFileUpload();
			sfu.setSizeMax(60*1024*1024);
			sfu.setFileSizeMax(20*1024*1024);
			try {
				List<FileItem> fileList = sfu.parseRequest(request);
				for(int i=0;i<fileList.size();i++) {
					FileItem fi= fileList.get(i);
					if(fi.isFormField()) {
						
					}else {
						String fileName = fi.getName();
						File saveFile = new File(savePath + "\\" + fileName);
						fi.write(saveFile);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}

}
