<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"
%>

<%File frc = new File("/RegisterCheck"); 
  String pathRC = frc.getName();
  File ft = new File("/Top");
  String pathT = ft.getName();
%>
<%String item_kind = (String)request.getAttribute("str_item_kind");
  String found_place = (String)request.getAttribute("str_found_place");
  String found_at = (String)request.getAttribute("found_at");
  String posted_at = (String)request.getAttribute("posted_at");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style_registerCheck.css">
<title>落とし物を登録</title>
</head>
<body>
  <header>
    <h3>しらせる</h3>
  </header>

  <div class="full-page">
    <h1>これでいいですか？</h1>
    <div class="list-grid">
      <img src="img/sample1.jpg" alt="写真なし" class="list-grid-photo" width="auto" height="100%">
      <h4><%=item_kind %></h4>
      <div class="list-where"><%=found_place %></div>
      <div class="list-time"><%=found_at %></div>
    </div>
    <section class="check-box">
      <h2>なまえ</h2>
      <p><%=item_kind %></p>
      <h2>ばしょ</h2>
      <p><%=found_place %></p>
      <h2>ひろった日</h2>
      <p><%=found_at %></p>
      <h2>きょう</h2>
      <p><%=posted_at %></p>
    </section>
    <form action="./<%=pathRC %>" method="post" name="registerCheck_form"><input type="hidden" value="<%=posted_at %>" name="posted_at">
    <button id="search_button" class="btn" type="submit">けってい</button></form><br>
    <button id="back_button" class="btn" type="button" onclick="location.href='./<%=pathT %>'">もどる</button>
  </div>
  

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
</body>
</html>