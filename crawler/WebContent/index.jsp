<%@page import="java.util.ArrayList"%>
<%@page import="vo.NationList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<meta charset=UTF-8>
<title>Main</title>
</head>
<body>
	<%
	//HashMap<String, String> nationList = NationList.nationList;
	ArrayList<String> nationList = new ArrayList<>(NationList.nationList.keySet());
	%>
	
	<h1>Chart Crawler</h1>
	
	
	
	
	
</body>
</html>