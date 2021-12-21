package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;

public class SearchedServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Item item = (Item)session.getAttribute("searched_item");
	request.setAttribute("item_kind", item.getStr_item_kind());

	request.setAttribute("found_place", item.getStr_found_place());
	
	String found_at = item.getFound_at().split(" ")[0];
	request.setAttribute("found_at", found_at);
	request.setAttribute("photo", item.getPhoto());
	
	session.removeAttribute("searched_item");
	
	File f = new File("WEB-INF/jsp/searched.jsp");
	String path = f.getPath();
	RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	dispatcher.forward(request, response);
		
		
		
	}
}