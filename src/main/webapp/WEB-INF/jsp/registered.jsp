<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"
%>

<%File ft = new File("/Top"); 
  String pathT = ft.getName();
  File fr = new File("/Register");
  String pathR = fr.getName();
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
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/style_registerCheck.css">
<title>落とし物を登録</title>
</head>
<body>
<div class="background">
  <div class="main-screen">
      <header>
    <h3>しらせる</h3>
  </header>

  <div class="full-page">
    <h1>おとしものをうけつけました。<br>
      協力ありがとう！</h1>
    <div class="list-grid">
      <img src="img/sample1.jpg" alt="写真" class="list-grid-photo" width="auto" height="100%">
      <h4><%=item_kind %></h4>
      <div class="list-where"><%=found_place %></div>
      <div class="list-time"><%=found_at %></div>
    </div>
    <section class="check-box">
      <h2>種類</h2>
      <p><%=item_kind %></p>
      <h2>場所</h2>
      <p><%=found_place %></p>
      <h2>拾った日</h2>
      <p><%=found_at %></p>
      <h2>登録した日</h2>
      <p><%=posted_at %></p>
    </section>
    <button id="back_button" class="btn" type="button" onclick="location.href='<%=pathT %>'">さいしょにもどる</button>
  </div>
  

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
  </div>
</div>


</body>
</html>