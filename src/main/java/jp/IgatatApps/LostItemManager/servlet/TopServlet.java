package jp.IgatatApps.LostItemManager.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
public class TopServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;

	@RequestMapping("/")
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		
		File f = new File("WEB-INF/jsp/top.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}