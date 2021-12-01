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
<link rel="stylesheet" href="css/style_search.css">
<title>条件をつけて検索</title>
</head>
<body>
  <header>
    <h3>さがす</h3>
  </header>

  <form method="post" action="<%=pathS %>" name="search_form">
    <div class="search-box">
      <div class="search-box-title">おとしたものは？</div>
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
      <div class="search-box-title">おとしたばしょは？</div>
      <div class="search-box-grid">
        <input id="place1" class="radio" type="radio" value="1" name="found_place"><label for="place1">本校</label>
        <input id="place2" class="radio" type="radio" value="2" name="found_place"><label for="place2">A校</label>
        <input id="place3" class="radio" type="radio" value="3" name="found_place"><label for="place3">B校</label>
        <input id="place4" class="radio" type="radio" value="4" name="found_place"><label for="place4">C校</label>
        <input id="place5" class="radio" type="radio" value="5" name="found_place"><label for="place5">D校</label>
        <input id="place6" class="radio" type="radio" value="6" name="found_place"><label for="place6">E校</label>
        <input id="place7" class="radio" type="radio" value="7" name="found_place"><label for="place7">F校</label>
        <input id="place8" class="radio" type="radio" value="8" name="found_place"><label for="place8">G校</label>
        <input id="place9" class="radio" type="radio" value="9" name="found_place"><label for="place9">H校</label>


      </div>
    </div>
    <div class="search-box">
      <div class="search-box-title">おとした日は？</div>
      <div class="search-box-grid">
        <input id="time1" class="radio" type="radio" value="0" name="found_at"><label for="time1">きょう</label>
        <input id="time2" class="radio" type="radio" value="1" name="found_at"><label for="time2">きのう</label>
        <input id="time3" class="radio" type="radio" value="2" name="found_at"><label for="time3">おととい</label>
        <input id="time4" class="radio" type="radio" value="3" name="found_at"><label for="time4">３日前ぐらい</label>
        <input id="time5" class="radio" type="radio" value="7" name="found_at"><label for="time5">１週間前ぐらい</label>
        <input id="time6" class="radio" type="radio" value="14" name="found_at"><label for="time6">２週間より前</label>
      </div>
    </div>
    <div class="submit-box">
      <button id="search_button" class="btn" type="submit" onclick="">けってい</button>
    </div>
  </form>

  <footer>2021 (c)IgatatApps All Rights Resereved.</footer>
</body>
</html>