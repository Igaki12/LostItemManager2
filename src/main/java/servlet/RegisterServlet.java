package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

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

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import model.Item;


@WebServlet("/Main")
@MultipartConfig

public class RegisterServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		String now = model.CalendarDate.StrDatetimeNow();
		String today = now.split(" ")[0];
		String daysAgo1 = model.CalendarDate.StrDatetimeDaysAgo(1).split(" ")[0];
		String daysAgo2 = model.CalendarDate.StrDatetimeDaysAgo(2).split(" ")[0];
		String daysAgo3 = model.CalendarDate.StrDatetimeDaysAgo(3).split(" ")[0];
		String daysAgo7 = model.CalendarDate.StrDatetimeDaysAgo(7).split(" ")[0];
		String daysAgo14 = model.CalendarDate.StrDatetimeDaysAgo(14).split(" ")[0];
		
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
		
		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part=request.getPart("photo");
		//ファイル名を取得
		//String filename=part.getSubmittedFileName();//ie対応が不要な場合
		String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//アップロードするフォルダ
		String path=getServletContext().getRealPath("WEB-INF/upload");
		//実際にファイルが保存されるパス確認
		System.out.println(path);
		//書き込み
		part.write(path+File.separator+filename);
		Item item = new Item();
		request.setAttribute("filename", filename);
		item.setPhoto(filename);
		
		
		String str_item_kind = request.getParameter("item_kind");
		int item_kind = 0;
		try{
			item_kind = Integer.parseInt(str_item_kind);
		}catch(NumberFormatException e) {
			item_kind = 0;
		}
		if(item_kind == 0) {
			System.out.println("エラー：再入力してください");
			response.sendRedirect("./Top");
		}
		item.setItem_kind(item_kind);
		
		String str_found_place = request.getParameter("found_place");
		int found_place = 0;
		try {
			found_place = Integer.parseInt(str_found_place);
		}catch(NumberFormatException e) {
			found_place = 0;
		}
		if(found_place == 0) {
			System.out.println("エラー：場所を再入力してください");
			response.sendRedirect("./Top");
		}
		item.setFound_place(found_place);
		
		String day_found_at = request.getParameter("found_at");
		if(day_found_at == null) {
			day_found_at = model.CalendarDate.StrDatetimeNow().split(" ")[0];
		}
		String time_found_at = model.CalendarDate.StrDatetimeNow().split(" ")[1];
		String found_at = day_found_at +" " + time_found_at;
		item.setFound_at(found_at);
		
//		photoを登録する
		if(request.getPart("photo") != null) {
			File file = new File(path);
			model.S3AO.PutPhotoObject("sample", file);
			item.setPhoto("sample");
		}
		
		
		String posted_at = model.CalendarDate.StrDatetimeNow();
		item.setPosted_at(posted_at);
		
		item.setDelete_flag(0);
		
		System.out.println(item.getPhoto());
		HttpSession session = request.getSession();
		session.removeAttribute("registering_item");
		session.setAttribute("registering_item", item);
		
		response.sendRedirect("./RegisterCheck");
		
		
		
	}
}