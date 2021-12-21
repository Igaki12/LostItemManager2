<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" import="model.Item" import="java.util.List"
%>

<%File fs = new File("/Search"); 
  String pathS = fs.getName();
  File fsc = new File("/SearchCheck");
  String pathSC = fsc.getName();
%>
<%String searching_item_kind = (String)request.getAttribute("item_kind");
  String searching_found_place = (String)request.getAttribute("found_place");
  String searching_found_at = (String)request.getAttribute("found_at");
  if(searching_item_kind == "" && searching_found_place == "" && searching_found_at == ""){
	  searching_found_at = "条件なし";
  }

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/style_search.css">
<title>条件をつけて検索</title>
</head>
<body>
 <div class="background">
    <div class="main-screen">
  <header>
    <h3>さがす</h3>
  </header>
  <div class="condition">
    <h3><%=searching_item_kind %>/<%=searching_found_place %>/<%=searching_found_at %> </h3>
  </div>
  
  <%List<Item> list = (List<Item>)request.getAttribute("list");
  %>
  
  <%for(int i = 0; i < list.size(); i++){ 
  %>

  <button class="list-grid" type="button"  onclick="location.href='./SearchCheck?id=<%=list.get(i).getId() %>'">
    <img src="https://lostitemmanager.s3.ap-northeast-1.amazonaws.com/dir/<%=list.get(i).getPhoto() %>.png" alt="写真" class="list-grid-photo" width="90px" height="90px" id="<%=i %>">
    <h4><%=list.get(i).getStr_item_kind() %></h4>
    <div class="list-where"><%=list.get(i).getStr_found_place() %></div>
    <div class="list-time"><%=list.get(i).getFound_at().split(" ")[0] %></div>
  </button>
  
  <%} %>

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
  </div>
  </div>
</body>
</html>