<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" import="model.Item" import="javax.servlet.http.HttpSession"
%>

<%File fc = new File("/SearchCheck"); 
  String pathSC = fc.getName();
  File fl = new File("/List");
  String pathL = fl.getName();
%>

<%HttpSession sess = request.getSession();
Item item = (Item)sess.getAttribute("searched_item");
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
String str_found_place = "";
switch(item.getFound_place()){
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

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style_searchCheck.css">
<title>確認画面</title>
</head>
<body>
  <header>
    <h3>さがす</h3>
  </header>

  <div class="full-page">
    <h1>これでいいですか？</h1>
    <div class="list-grid">
      <img src="img/sample1.jpg" alt="写真" class="list-grid-photo" width="auto" height="100%">
      <h4><%=str_item_kind %></h4>
      <div class="list-where"><%=str_found_place %></div>
      <div class="list-time"><%=item.getFound_at().split(" ")[0] %></div>
    </div>
    <section class="check-box">
      <h2>種類</h2>
      <p><%=str_item_kind %></p>
      <h2>場所</h2>
      <p><%=str_found_place %></p>
      <h2>拾った日</h2>
      <p><%=item.getFound_at().split(" ")[0] %></p>
    </section>
    <form method="post" action="./<%=pathSC %>"><input type="hidden" name="id" value="<%=item.getId() %>">
    <button id="search_button" class="btn" type="submit" >けってい</button></form><br>
    <button id="back_button" class="btn" type="button" onclick="location.href='./<%=pathL %>'">もどる</button>
  </div>

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
</body>
</html>