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

public class SearchCheckServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		
		String str_id = request.getParameter("id");
		int id = 0;
		try{
			id = Integer.parseInt(str_id);
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
			response.sendRedirect("./List");
		}
//		idをもとにDBから該当アイテムを検索して、あればrequestで送ってフォワード
		Item item = jp.IgatatApps.LostItemManager.model.DAO.SelectItemById(id);
		HttpSession session = request.getSession();
		session.removeAttribute("searched_item");
		session.setAttribute("searched_item", item);
		
		File f = new File("WEB-INF/jsp/searchCheck.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Item item = (Item)session.getAttribute("searched_item");
		String now = jp.IgatatApps.LostItemManager.model.CalendarDate.StrDatetimeNow();
		int flag = jp.IgatatApps.LostItemManager.model.DAO.UpdateDelete_flagDeleted_atOfItemById(1, now, item.getId());
		if(flag != 0) {
			System.out.println("エラー：再入力してください");
			response.sendRedirect("./SearchCheck");
		}
		response.sendRedirect("./Searched");
		
	}
}