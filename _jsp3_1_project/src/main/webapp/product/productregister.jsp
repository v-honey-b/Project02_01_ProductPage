<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT REGISTER</title>
</head>
<body>
	<h1>PRODUCT REGISTER PAGE</h1>
	<form action="./productinsert.pd" method="post">
		<table border="1">
			<tr>
				<th>NAME</th>
				<td><input type="text" name="pname"></td>
			</tr>
			<tr>
				<th>PRICE</th>
				<td><input type="number" name="price"></td>
			</tr>
			<tr>
				<th>MADE_BY</th>
				<td><input type="text" name="made_by"></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit">REGISTER</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>