package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;

public class RegisterCheckServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	    request.setCharacterEncoding("UTF-8");
	    
	    HttpSession session = request.getSession();
	    File file = new File("WEB-INF/jsp/registerCheck.jsp");
        if(session.getAttribute("registering_item") != null) {
        	Item item = (Item)session.getAttribute("registering_item");
        	request.setAttribute("str_item_kind", item.getStr_item_kind());
        	request.setAttribute("str_found_place", item.getStr_found_place());
        	
        	String datetime_found_at = item.getFound_at();
        	String found_at = datetime_found_at.trim().split(" ")[0];
        	if(found_at == null) {
        		System.out.println("エラー：再入力してください");
        		file = new File("./Register");
        	}
        	request.setAttribute("found_at", found_at);
        	
            
            request.setAttribute("photo", item.getPhoto());

        	
        	
        	
        	String posted_at = item.getPosted_at().split(" ")[0];
        	if(posted_at == null) {
        		System.out.println("エラー：写真を再入力してください");
        		file = new File("./Register");
        	}
        	request.setAttribute("posted_at", posted_at);
        }
	    	
	    String path = file.getPath();
	    RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	    dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Item item = (Item)session.getAttribute("registering_item");
		
		int flag = model.DAO.InsertItem(item);
		
		response.sendRedirect("./Registered");
	}
}