<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bookmark.U, java.util.List"%>
<%@ page import="bookmark.U2, java.util.List"%>
<%
	List<U> all = (List<U>) session.getAttribute("all");
    List<U2> all2 = (List<U2>) session.getAttribute("all2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>☆ブックマーク☆</title>
</head>
<body>
	<P>ブックマーク登録</P>

	<form action="/s1732126/urlT" method="POST">
		番号: <input type="text" name="number">
		URL: <input type="text" name="urls">
		 <input type="hidden" name="action" value="create"> <input type="submit" value="とりあえず登録">
		 </form>
    <form action="/s1732126/urlT" method="POST">
		 番号: <input type="text" name="number">
		URL: <input type="text" name="urls">
		 <input type="hidden" name="action" value="create2"><input type="submit" value="ニュースとして登録">

	</form>

	<hr>
	<P>ブックマーク一覧</P>
	<P>とりあえず登録</P>

	<%for (U url1 : all) { %>
	<%=url1.getNumber()%>, <a href="<%=url1.getUrl()%>"><%=url1.getUrl()%></a><br>
	<% } %>
	<hr>

	<P>ニュース</P>

	<%for (U2 url2 : all2) { %>
	<%=url2.getNumber2()%>, <a href="<%=url2.getUrl2()%>"><%=url2.getUrl2()%></a><br>
	<% } %>


	<hr>
	<P>ブックマーク削除</P>
	<P>「とりあえず登録」データの削除</P>
	<form action="/s1732126/urlT" method="POST">
		番号: <input type="text" name="number"> <input type="hidden" name = "action" value="delete"> <input type="submit" value="削除">
	</form>

	<P>「ニュース」データの削除</P>

	<form action="/s1732126/urlT" method="POST">
		番号: <input type="text" name="number"> <input type="hidden" name = "action" value="delete2"> <input type="submit" value="削除">
	</form>
</body>
</html>

