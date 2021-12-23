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
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/style_searchCheck.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/css/lightbox.css" rel="stylesheet">
<title>確認画面</title>
</head>
<body>
<div class="background">
  <div class="main-screen">
    <header>
    <h3>さがす</h3>
  </header>

  <div class="full-page">
    <h1>これでいいですか？</h1>
    <div class="list-grid">
      <a href="https://lostitemmanager.s3.ap-northeast-1.amazonaws.com/dir/<%=item.getPhoto() %>.png" data-lightbox="abc" data-title="拡大写真" ><img src="https://lostitemmanager.s3.ap-northeast-1.amazonaws.com/dir/<%=item.getPhoto() %>.png" alt="リンク切れ"  width="90px" height="90px" class="list-grid-photo"></a>
      <h4><%=item.getStr_item_kind() %></h4>
      <div class="list-where"><%=item.getStr_found_place() %></div>
      <div class="list-time"><%=item.getFound_at().split(" ")[0] %></div>
    </div>
    <section class="check-box">
      <h2>種類</h2>
      <p><%=item.getStr_item_kind() %></p>
      <h2>場所</h2>
      <p><%=item.getStr_found_place() %></p>
      <h2>拾った日</h2>
      <p><%=item.getFound_at().split(" ")[0] %></p>
    </section>
    <form method="post" action="./<%=pathSC %>"><input type="hidden" name="id" value="<%=item.getId() %>">
    <button id="search_button" class="btn" type="submit" >けってい</button></form><br>
    <button id="back_button" class="btn" type="button" onclick="location.href='./<%=pathL %>'">もどる</button>
  </div>

  <footer>2021 (c)IgatatApps All Rights Reserved.</footer>
  </div>
</div>
  <script src="https://code.jquery.com/jquery-1.12.4.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/js/lightbox.min.js" type="text/javascript"></script>
  
</body>
</html>