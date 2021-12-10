package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;

public class ListServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Item item = (Item)session.getAttribute("searching_item");
		if(item == null) {
			System.out.println("エラー：再入力してください");
			response.sendRedirect("./Top");
		}
		String str_item_kind = "";
    	switch(item.getItem_kind()) {
    	    case 1:  
    	    	str_item_kind = "ペン";
    	        break;
    	    case 2:  
    	    	str_item_kind = "ふでばこ";
    	        break;
    	    case 3:  
    	    	str_item_kind = "けしゴム";
    	    	break;
    	    case 4:  
    	    	str_item_kind = "したじき";
    	    	break;
    	    case 5:  
    	    	str_item_kind = "ノート";
    	    	break;
    	    case 6:  
    	    	str_item_kind = "プリント";
    	    	break;
    	    case 7:  
    	    	str_item_kind = "かさ";
    	    	break;
    	    case 8:  
    	    	str_item_kind = "そのほか";
    	    	break;
    	}
		request.setAttribute("item_kind", str_item_kind);
		
		String str_found_place = "";
    	switch(item.getFound_place()) {
    	case 1:
    		str_found_place = "本校";
    		break;
    	case 2:
    		str_found_place = "A校";
    		break;
    	case 3:
    		str_found_place = "B校";
    		break;
    	case 4:
    		str_found_place = "C校";
    		break;
    	case 5:
    		str_found_place = "D校";
    		break;
    	case 6:
    		str_found_place = "E校";
    		break;
    	case 7:
    		str_found_place = "F校";
    		break;
    	case 8:
    		str_found_place = "G校";
    		break;
    	case 9:
    		str_found_place = "そのほか";
    		break;
    	}
		request.setAttribute("found_place", str_found_place);
		String found_at = item.getFound_at().split(" ")[0] + "~";
		request.setAttribute("found_at", found_at);
		
		List<Item> list = (List<Item>)model.DAO.SearchItemListWhereItem_kindFound_placeFound_atOrderByPosted_at(item.getItem_kind(), item.getFound_place(),item.getFound_at());
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