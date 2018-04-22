<%@page import="java.util.ArrayList"%>
<%@page import="vo.NationList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>iTunes Crawler</title>
  </head>
  <body>
  <h1>itunes chart crawler</h1>
  <form class="input-group" action="crawler" method="post">
    <input id="selectall" checkedtype="checkbox" name="nation" value="Select All">
    <%
    //ㄴ라이름만 가져온다.
      ArrayList<String> nationList = new ArrayList<>(NationList.nationList.keySet());
      for (String nation : nationList) {
        %>
          <input checkedtype="checkbox" name="nation" value="<%= nation %>">
        <%

      }
    %>


    <input type="submit" name="" value="Get Excel file Now!">
  </form>




  </body>
</html>
