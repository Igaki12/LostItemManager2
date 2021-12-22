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

public class SearchServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		String today = model.CalendarDate.StrDatetimeDaysAgo(1).split(" ")[0];
		String daysAgo1 = model.CalendarDate.StrDatetimeDaysAgo(2).split(" ")[0];
		String daysAgo2 = model.CalendarDate.StrDatetimeDaysAgo(3).split(" ")[0];
		String daysAgo3 = model.CalendarDate.StrDatetimeDaysAgo(4).split(" ")[0];
		String daysAgo7 = model.CalendarDate.StrDatetimeDaysAgo(14).split(" ")[0];
		String daysAgo14 = model.CalendarDate.StrDatetimeDaysAgo(28).split(" ")[0];
		
		request.setAttribute("today", today);
		request.setAttribute("daysAgo1", daysAgo1);
		request.setAttribute("daysAgo2", daysAgo2);
		request.setAttribute("daysAgo3", daysAgo3);
		request.setAttribute("daysAgo7", daysAgo7);
		request.setAttribute("daysAgo14", daysAgo14);
		File f = new File("WEB-INF/jsp/search.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		
		Item item = new Item();
//		Search側は0(指定なし)も許容する
		String str_item_kind = request.getParameter("item_kind");
		int item_kind = 0;
		try{
			item_kind = Integer.parseInt(str_item_kind);
		}catch(NumberFormatException e) {
			item_kind = 0;
		}
		item.setItem_kind(item_kind);
		String word_item_kind = model.DAO.SelectStrItemKindByIntItemKind(item_kind);
		item.setStr_item_kind(word_item_kind);
		
		String str_found_place = request.getParameter("found_place");
		int found_place = 0;
		try {
			found_place = Integer.parseInt(str_found_place);
		}catch(NumberFormatException e) {
			found_place = 0;
		}
		item.setFound_place(found_place);
		String word_found_place = model.DAO.SelectStrFoundPlaceByIntFoundPlace(found_place);
		item.setStr_found_place(word_found_place);
		
		String day_found_at = request.getParameter("found_at");
		if(day_found_at == null) {
			day_found_at = model.CalendarDate.StrDatetimeDaysAgo(365);
		}
		String time_found_at = model.CalendarDate.StrDatetimeNow().split(" ")[1];
		String found_at = day_found_at +" " + time_found_at;
		item.setFound_at(found_at);
		
		item.setDelete_flag(0);
		
		HttpSession session = request.getSession();
		session.setAttribute("searching_item", item);
		response.sendRedirect("./List");

	}
}