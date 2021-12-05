<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" import="model.Item"
%>

<%File fs = new File("/Search"); 
  String pathS = fs.getName();
  File ft = new File("/Top");
  String pathT = ft.getName();
%>

<%HttpSession sess = request.getSession();
  sess.getAttribute("searched_item");
  String item_kind = (String)request.getAttribute("item_kind");
  String found_place = (String)request.getAttribute("found_place");
  String found_at = (String)request.getAttribute("found_at");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style_searchCheck.css">
<title>条件をつけて検索</title>
</head>
<body>
  <header>
    <h3>さがす</h3>
  </header>

  <div class="full-page">
    <h1>おとしものがみつかりました。</h1>
    ,<p>A校</p><h1>でうけとってください！</h1>
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
    </section>
    <button id="back_button" class="btn" type="button" onclick="location.href='./<%=pathT %>'">さいしょにもどる</button>
  </div>

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
</body>
</html>