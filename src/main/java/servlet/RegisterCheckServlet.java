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
        	int item_kind = item.getItem_kind();
        	String str_item_kind = null;
        	switch(item_kind) {
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
        	if(str_item_kind == null) {
        		System.out.println("エラー：再入力してください");
        		file = new File("./Register");	
        	}
        	request.setAttribute("str_item_kind", str_item_kind);
        	
        	int found_place = item.getFound_place();
        	String str_found_place = null;
        	switch(found_place) {
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
        	if(str_found_place == null) {
        		System.out.println("エラー：再入力してください");
        		file = new File("./Register");	
        	}
        	request.setAttribute("str_found_place", str_found_place);
        	
        	String datetime_found_at = item.getFound_at();
        	String found_at = datetime_found_at.trim().split(" ")[0];
        	if(found_at == null) {
        		System.out.println("エラー：再入力してください");
        		file = new File("./Register");
        	}
        	request.setAttribute("found_at", found_at);
        	
//        	写真についての箇所
        	String photo = item.getPhoto();
        	File photoFile = model.S3AO.GetPhotoObject(photo);
        	request.setAttribute("photoFile" ,photoFile);
        	
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