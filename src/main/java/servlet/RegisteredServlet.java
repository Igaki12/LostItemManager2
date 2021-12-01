package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisteredServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		File file = new File("WEB-INF/jsp/registered.jsp");
		String strId = request.getParameter("id");
		int id = 0;
		try{
			id = Integer.parseInt(strId);
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
			response.sendRedirect("/Register");
		}
//		idをもとにDB上の該当レコードを探して、requestで送信
		
		String path = file.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}