<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>在线商店|登录</h2>
		<form method="post" action="/OnlineShop/LoginServlet">
			账号：
			<input type="text" name="username" id="uname" /><br />
			密码：
			<input type="password" name="userpass" id="upass" /><br />
			<br />
			<input type="submit" value="登录" />
			<input type="reset" value="清空" />
			<a href="Register.jsp">新用户注册</a>
		</form>
</body>
</html>