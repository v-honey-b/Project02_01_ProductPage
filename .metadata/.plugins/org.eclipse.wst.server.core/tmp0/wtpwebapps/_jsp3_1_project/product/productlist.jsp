<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="domain.ProductVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT LIST</title>
</head>
<%
List<ProductVO> productlist = (ArrayList<ProductVO>)request.getAttribute("productlist");
%>
<body>
	<h1>PRODUCT LIST PAGE</h1>
	<table border="1">
		<tr>
			<th>NO.</th>
			<th>NAME</th>
			<th>REG_DATE</th>
		</tr>
		<% for(ProductVO pvo : productlist) { %>
			<tr>
				<td><%=pvo.getPno() %></td>
				<td><a href="./productdetail.pd?pno=<%=pvo.getPno() %>"><%=pvo.getPname() %></a></td>
				<td><%=pvo.getReg_date() %></td>
			</tr>
		<%} %>
	</table>
	<a href="/">INDEX</a>
</body>
</html>