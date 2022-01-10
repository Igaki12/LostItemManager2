package jp.IgatatApps.LostItemManager.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.IgatatApps.LostItemManager.model.*;

public class ListServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Item item = (Item)session.getAttribute("searching_item");
		
		request.setAttribute("item_kind", item.getStr_item_kind());
		
		request.setAttribute("found_place", item.getStr_found_place());
		String found_at = item.getFound_at().split(" ")[0] + "~";
		request.setAttribute("found_at", found_at);
		
		List<Item> list = (List<Item>)jp.IgatatApps.LostItemManager.model.DAO.SearchItemListWhereItem_kindFound_placeFound_atOrderByPosted_at(item.getItem_kind(), item.getFound_place(),item.getFound_at());
		request.setAttribute("list", list);
		
//		int pageTop_index = 0;
//		for(Item i : list) {
//			String str_found_at = i.getFound_at();
//			Calendar list_found_at = model.CalendarDate.ParseStrToCalendar(str_found_at);
//			if(list_found_at.compareTo(searching_found_at) < 0) {
//				pageTop_index += 1;
//			}
//		}
//		request.setAttribute("pageTop_index", pageTop_index);
		
		File f = new File("WEB-INF/jsp/list.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(f.getPath());
		dispatcher.forward(request, response);
		
		
	}
}