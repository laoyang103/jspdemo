<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/add.html">添加</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>楼名</th>
        <th>房间号</th>
    </tr>
    <c:forEach var="r" items="${rooms}"> 
        <tr>
            <td>${r.id}</td>
            <td>${r.buildingName}</td>
            <td>${r.number}</td>
            <td><a href="/rooms?method=del&id=${r.id}">删除</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
