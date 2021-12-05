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
	
	String found_at = item.getFound_at().split(" ")[0];
	request.setAttribute("found_at", found_at);
	
	session.removeAttribute("searched_item");
	
	File f = new File("WEB-INF/jsp/searched.jsp");
	String path = f.getPath();
	RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	dispatcher.forward(request, response);
		
		
		
	}
}