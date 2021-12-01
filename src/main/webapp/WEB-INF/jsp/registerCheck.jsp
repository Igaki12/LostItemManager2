<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"
%>

<%File fs = new File("/Search"); 
  String pathS = fs.getName();
  File fr = new File("/Register");
  String pathR = fr.getName();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style_registerCkeck.css">
<title>落とし物を登録</title>
</head>
<body>
  <header>
    <h3>しらせる</h3>
  </header>

  <div class="full-page">
    <h1>これでいいですか？</h1>
    <div class="list-grid">
      <img src="img/sample1.jpg" alt="写真" class="list-grid-photo" width="auto" height="100%">
      <h4>その他</h4>
      <div class="list-where">郊外</div>
      <div class="list-time">11/16</div>
    </div>
    <section class="check-box">
      <h2>種類</h2>
      <p>その他</p>
      <h2>場所</h2>
      <p>郊外</p>
      <h2>拾った日</h2>
      <p>11/16</p>
      <h2>登録した日</h2>
      <p>11/17</p>
    </section>
    <button id="search_button" class="btn" type="button" onclick="">けってい</button><br>
    <button id="back_button" class="btn" type="button" onclick="">もどる</button>
  </div>
  

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
</body>
</html>