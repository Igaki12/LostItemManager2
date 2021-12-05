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
<link rel="stylesheet" href="css/style_top.css">
<title>LostItemManager/Top</title>
</head>
<body>
  <div class="title">
    <h1>おとしものサポート</h1>
  </div>
  <div class="full">
    <div class="main">
      <p>おとしものを      </p>
      <button id="lost_button" class="btn" type="button" onclick="location.href='./<%=pathS %>'"> さがす</button>
      <br>
      <button id="found_button" class="btn" type="button" onclick="location.href='./<%=pathR %>'">ひろった</button>
    </div>
  </div>
  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
</body>
</html>