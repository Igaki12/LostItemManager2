package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;

public class SearchCheckServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Item item = (Item)session.getAttribute("searching_item");
		String id = request.getParameter("id");
		if(item == null || id == null) {
			System.out.println("エラー：再入力してください");
			response.sendRedirect("/Search");
		}
//		idをもとにDBから該当アイテムを検索して、あればrequestで送ってフォワード
	}
}