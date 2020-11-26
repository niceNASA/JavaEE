<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.oshop.Util.DBUtil" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h2>新用户注册</h2>
		<form method="post" action="/OnlineShop/RegisterServlet">
			账号：
			<input type="text" name="username" id="uname" /><br />
			密码：
			<input type="password" name="userpass" id="upass" /><br />
			<br />
			<input type="submit" value="提交" />
			<input type="reset" value="清空" />
		</form>
</body>
</html>