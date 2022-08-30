<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT MODIFY</title>
</head>
<%
	ProductVO pvo = (ProductVO)request.getAttribute("pvo");
%>
<body>
	<h1>PRODUCT MODIFY PAGE</h1>
	<form action="./productupdate.pd" method="post">
	<input type="hidden" name="pno" value="<%=pvo.getPno() %>">
		<table border="1">
			<tr>
				<th>NO.</th>
				<td><%=pvo.getPno() %></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="pname" value="<%=pvo.getPname() %>"></td>
			</tr>
			<tr>
				<th>PRICE</th>
				<td><input type="number" name="price" value="<%=pvo.getPrice() %>"></td>
			</tr>
			<tr>
				<th>REG_DATE</th>
				<td><%=pvo.getReg_date() %></td>
			</tr>
			<tr>
				<th>MADE_BY</th>
				<td><input type="text" name="made_by" value="<%=pvo.getMade_by() %>"></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit">MODIFY</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>