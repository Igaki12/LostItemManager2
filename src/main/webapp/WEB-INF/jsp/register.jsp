<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"
%>

<%File fr = new File("/Register"); 
  String pathR = fr.getName();
  File frc = new File("/RegisterCheck");
  String pathRC = frc.getName();
%>
<%String today = (String)request.getAttribute("today");
String daysAgo1 = (String)request.getAttribute("daysAgo1");
String daysAgo2 = (String)request.getAttribute("daysAgo2");
String daysAgo3 = (String)request.getAttribute("daysAgo3");
String daysAgo7 = (String)request.getAttribute("daysAgo7");
String daysAgo14 = (String)request.getAttribute("daysAgo14");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/style_register.css">
<script type="text/javascript" src="js/register.js"></script>
<title>落とし物を登録</title>
</head>
<body>
  <div class="background">
    <div class="main-screen">
    
        <header>
          <h3>しらせる</h3>
        </header>
      <form method="post" action="./<%=pathR %>" id="register_form" enctype="multipart/form-data">
    <div class="search-box">
      <div class="search-box-title">ひろったものは？</div>
      <div class="search-box-grid">
        <input id="kind1" class="radio" type="radio" value="1" name="item_kind"><label for="kind1">ペン</label>
        <input id="kind2" class="radio" type="radio" value="2" name="item_kind"><label for="kind2">ふでばこ</label>
        <input id="kind3" class="radio" type="radio" value="3" name="item_kind"><label for="kind3">けしゴム</label>
        <input id="kind4" class="radio" type="radio" value="4" name="item_kind"><label for="kind4">したじき</label>
        <input id="kind5" class="radio" type="radio" value="5" name="item_kind"><label for="kind5">ノート</label>
        <input id="kind6" class="radio" type="radio" value="6" name="item_kind"><label for="kind6">プリント</label>
        <input id="kind7" class="radio" type="radio" value="7" name="item_kind"><label for="kind7">かさ</label>
        <input id="kind8" class="radio" type="radio" value="8" name="item_kind"><label for="kind8">そのほか</label>
      </div>
    </div>
    <div class="search-box">
      <div class="search-box-title">ひろったばしょは？</div>
      <div class="search-box-grid">
        <input id="place1" class="radio" type="radio" value="1" name="found_place"><label for="place1">本校</label>
        <input id="place2" class="radio" type="radio" value="2" name="found_place"><label for="place2">A校</label>
        <input id="place3" class="radio" type="radio" value="3" name="found_place"><label for="place3">B校</label>
        <input id="place4" class="radio" type="radio" value="4" name="found_place"><label for="place4">C校</label>
        <input id="place5" class="radio" type="radio" value="5" name="found_place"><label for="place5">D校</label>
        <input id="place6" class="radio" type="radio" value="6" name="found_place"><label for="place6">E校</label>
        <input id="place7" class="radio" type="radio" value="7" name="found_place"><label for="place7">F校</label>
        <input id="place8" class="radio" type="radio" value="8" name="found_place"><label for="place8">G校</label>
        <input id="place9" class="radio" type="radio" value="9" name="found_place"><label for="place9">そのほか</label>
      </div>
    </div>
    <div class="search-box">
      <div class="search-box-title">ひろった日は？</div>
      <div class="search-box-grid">
        <input id="time1" class="radio" type="radio" value="<%=today %>" name="found_at"><label for="time1">きょう</label>
        <input id="time2" class="radio" type="radio" value="<%=daysAgo1 %>" name="found_at"><label for="time2">きのう</label>
        <input id="time3" class="radio" type="radio" value="<%=daysAgo2 %>" name="found_at"><label for="time3">おととい</label>
        <input id="time4" class="radio" type="radio" value="<%=daysAgo3 %>" name="found_at"><label for="time4">３日前ぐらい</label>
        <input id="time5" class="radio" type="radio" value="<%=daysAgo7 %>" name="found_at"><label for="time5">7日前ぐらい</label>
        <input id="time6" class="radio" type="radio" value="<%=daysAgo14 %>" name="found_at"><label for="time6">14日前ぐらい</label>
        
      </div>
    </div>
    <div class="search-box">
      <div class="search-box-title">しゃしんをとる</div>
      <div class="search-box-grid">
      <input id="photo" type="file" name="photo" accept=".png, .jpg, .jpeg">
        <label for="photo" id="photo-label">写真をえらぶ</label>
        
      </div>
    </div>
    <div class="submit-box">
      <button id="search_button" class="btn" type="submit" onclick="check()">けってい</button>
    </div>
  </form>
  

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
    </div>
  </div>
  
  
</body>
</html>