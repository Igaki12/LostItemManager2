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
  String photo = (String)request.getAttribute("photo");
  
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/style_registerCheck.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/css/lightbox.css" rel="stylesheet">
<title>落とし物を登録</title>
</head>
<body>




<div class="background">
  <div class="main-screen">
      <header>
    <h3>しらせる</h3>
  </header>

  <div class="full-page">
    <h1>これでいいですか？</h1>
    <div class="list-grid">

      <a href="https://lostitemmanager.s3.ap-northeast-1.amazonaws.com/dir/<%=photo %>.png" data-lightbox="abc" data-title="拡大写真" ><img src="https://lostitemmanager.s3.ap-northeast-1.amazonaws.com/dir/<%=photo %>.png" alt="リンク切れ"  width="90px" height="90px" class="list-grid-photo"></a>
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
  

  <footer>2021 (c)IgatatApps All Rights Reserved.</footer>
  </div>
</div>

<script src="https://code.jquery.com/jquery-1.12.4.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.7.1/js/lightbox.min.js" type="text/javascript"></script>
</body>
</html>