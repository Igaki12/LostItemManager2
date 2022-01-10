package jp.IgatatApps.LostItemManager.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.IgatatApps.LostItemManager.model.*;

public class RegisteredServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
        if(session.getAttribute("registering_item") != null) {
        	Item item = (Item)session.getAttribute("registering_item");
        	request.setAttribute("str_item_kind", item.getStr_item_kind());
        	
        	request.setAttribute("str_found_place", item.getStr_found_place());
        	
        	String datetime_found_at = item.getFound_at();
        	String found_at = datetime_found_at.trim().split(" ")[0];
        	if(found_at == null) {
        		System.out.println("エラー：再入力してください");
        		response.sendRedirect("./Top");	
        	}
        	request.setAttribute("found_at", found_at);
        	
        	request.setAttribute("photo", item.getPhoto());
        	
        	String posted_at = item.getPosted_at().split(" ")[0];
        	if(posted_at == null) {
        		System.out.println("エラー：再入力してください");
        		response.sendRedirect("./Top");		
        	}
        	request.setAttribute("posted_at", posted_at);
        }
        session.removeAttribute("registering_item");
		
		File file = new File("WEB-INF/jsp/registered.jsp");
		String path = file.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}