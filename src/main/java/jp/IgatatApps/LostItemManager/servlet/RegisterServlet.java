package jp.IgatatApps.LostItemManager.servlet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.text.html.HTMLDocument.Iterator;



import jp.IgatatApps.LostItemManager.model.*;


@WebServlet("/Main")
@MultipartConfig

public class RegisterServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		String now = jp.IgatatApps.LostItemManager.model.CalendarDate.StrDatetimeNow();
		String today = now.split(" ")[0];
		String daysAgo1 = jp.IgatatApps.LostItemManager.model.CalendarDate.StrDatetimeDaysAgo(1).split(" ")[0];
		String daysAgo2 = jp.IgatatApps.LostItemManager.model.CalendarDate.StrDatetimeDaysAgo(2).split(" ")[0];
		String daysAgo3 = jp.IgatatApps.LostItemManager.model.CalendarDate.StrDatetimeDaysAgo(3).split(" ")[0];
		String daysAgo7 = jp.IgatatApps.LostItemManager.model.CalendarDate.StrDatetimeDaysAgo(7).split(" ")[0];
		String daysAgo14 = jp.IgatatApps.LostItemManager.model.CalendarDate.StrDatetimeDaysAgo(14).split(" ")[0];
		
		request.setAttribute("today", today);
		request.setAttribute("daysAgo1", daysAgo1);
		request.setAttribute("daysAgo2", daysAgo2);
		request.setAttribute("daysAgo3", daysAgo3);
		request.setAttribute("daysAgo7", daysAgo7);
		request.setAttribute("daysAgo14", daysAgo14);
		File f = new File("WEB-INF/jsp/register.jsp");
		String path = f.getPath();
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		Item item = new Item();
		System.out.println("register:doPost");
		
		//name?????????pict??????????????????Part?????????????????????????????????
		Part part = request.getPart("photo");
		System.out.println(request.getPart("photo"));
		try {
		//????????????????????????
		//String filename=part.getSubmittedFileName();//ie????????????????????????
		String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//????????????????????????????????????
//		String path=getServletContext().getRealPath("WEB-INF/upload");
		String path = getServletContext().getRealPath("/");
		//???????????????????????????????????????????????????
		System.out.println("FileUploadFrom:" + path + File.separator + filename);
		//????????????
		part.write(path+File.separator+filename);
		
		request.setAttribute("filename", filename);
		item.setPhoto(filename);
//		photo???????????????
		File file = new File(path+File.separator+filename);
		String unixtime10 = jp.IgatatApps.LostItemManager.model.CalendarDate.StrUnixtimeNow();
		try{
			jp.IgatatApps.LostItemManager.model.S3AO.PutPhotoObject(unixtime10, file);
		}catch(Exception f) {
			System.out.println(f.getMessage());
			System.out.println("Failed to upload Photographs.");
		}
		item.setPhoto(unixtime10);
		file.delete();
		}catch(Exception e) {
			System.out.println("PhotoUploadFailure:" + e.getMessage());
		}
		
		String str_item_kind = request.getParameter("item_kind");
		int item_kind = 0;
		try{
			item_kind = Integer.parseInt(str_item_kind);
		}catch(NumberFormatException e) {
			item_kind = 0;
		}
		if(item_kind == 0) {
			System.out.println("???????????????????????????????????????");
			response.sendRedirect("./Top");
		}
		item.setItem_kind(item_kind);
		String word_item_kind = jp.IgatatApps.LostItemManager.model.DAO.SelectStrItemKindByIntItemKind(item_kind);
		item.setStr_item_kind(word_item_kind);
		
		String str_found_place = request.getParameter("found_place");
		int found_place = 0;
		try {
			found_place = Integer.parseInt(str_found_place);
		}catch(NumberFormatException e) {
			found_place = 0;
		}
		if(found_place == 0) {
			System.out.println("????????????????????????????????????????????????");
			response.sendRedirect("./Top");
		}
		item.setFound_place(found_place);
		String word_found_place = jp.IgatatApps.LostItemManager.model.DAO.SelectStrFoundPlaceByIntFoundPlace(found_place);
		item.setStr_found_place(word_found_place);
		
		
		String day_found_at = request.getParameter("found_at");
		if(day_found_at == null) {
			day_found_at = jp.IgatatApps.LostItemManager.model.CalendarDate.StrDatetimeNow().split(" ")[0];
		}
		String time_found_at = jp.IgatatApps.LostItemManager.model.CalendarDate.StrDatetimeNow().split(" ")[1];
		String found_at = day_found_at +" " + time_found_at;
		item.setFound_at(found_at);
		

		
		
		String posted_at = jp.IgatatApps.LostItemManager.model.CalendarDate.StrDatetimeNow();
		item.setPosted_at(posted_at);
		
		item.setDelete_flag(0);
		
		System.out.println(item.getPhoto());
		HttpSession session = request.getSession();
		session.removeAttribute("registering_item");
		session.setAttribute("registering_item", item);
		
		response.sendRedirect("./RegisterCheck");
		
		
		
	}
}