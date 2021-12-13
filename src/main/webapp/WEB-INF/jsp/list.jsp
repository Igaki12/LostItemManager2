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
      String str_item_kind = "";
      switch(list.get(i).getItem_kind()) {
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
       String str_found_place = "";
       switch(list.get(i).getFound_place()) {
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
  %>

  <button class="list-grid" type="button"  onclick="location.href='./SearchCheck?id=<%=list.get(i).getId() %>'">
    <img src="img/sample1.jpg" alt="写真" class="list-grid-photo" width="auto" height="100%" id="<%=i %>">
    <h4><%=str_item_kind %></h4>
    <div class="list-where"><%=str_found_place %></div>
    <div class="list-time"><%=list.get(i).getFound_at().split(" ")[0] %></div>
  </button>
  
  <%} %>

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
  </div>
  </div>
</body>
</html>