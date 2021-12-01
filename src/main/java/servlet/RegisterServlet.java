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

public class RegisterServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		File f = new File("WEB-INF/jsp/register.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		Item item = new Item();
		String str_item_kind = request.getParameter("item_kind");
		int item_kind = 0;
		try{
			item_kind = Integer.parseInt(str_item_kind);
		}catch(NumberFormatException e) {
			item_kind = 0;
		}
		item.setItem_kind(item_kind);
		
		String str_found_place = request.getParameter("found_place");
		int found_place = 0;
		try {
			found_place = Integer.parseInt(str_found_place);
		}catch(NumberFormatException e) {
			found_place = 0;
		}
		item.setFound_place(found_place);
		
		String str_found_at = request.getParameter("found_at");
		int int_found_at = 0;
		try {
			int_found_at = Integer.parseInt(str_found_at);
		}catch(NumberFormatException e) {
			int_found_at = 0;
		}
		String found_at = model.CalendarDate.DetermineFound_at(int_found_at);
		item.setFound_at(found_at);
		
//		photoを登録する
		
		String posted_at = model.CalendarDate.DeterminePosted_at();
		item.setPosted_at(posted_at);
		
		item.setDelete_flag(0);
		item.setPass(null);
		
		HttpSession session = request.getSession();
		session.removeAttribute("registering_item");
		session.setAttribute("registering_item", item);
		
		File f = new File("/RegisterCheck");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		
		
		
	}
}