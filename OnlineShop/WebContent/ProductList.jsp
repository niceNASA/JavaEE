<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.oshop.Util.DBUtil" %>
<%@ page import="com.oshop.Model.Goods" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<h2 align="center">在线商店|商品列表</h2>
	
	<form action="ShoppingCart.jsp" method="post">
	<table align="center">
	<tr>
		<th>编号</th>
		<th>商品</th>
		<th>价格</th>
		<th align="left">选择</th>
	</tr>
	<%if(session.getAttribute("allList")!=null){	//此处必须判断是否为空，否则会报错
		List<Goods> productList = (List<Goods>)session.getAttribute("allList");
		for(int i=0; i<productList.size(); i++){
			Goods temp = productList.get(i);
			out.println("<tr><td>"+temp.getId()+"</td><td>"+temp.getName()+"</td><td>￥"+temp.getPrice()+"</td>");
			out.println("<td><input type='radio' name='goods' value='"+temp.getName()+"'></td></th>");
		}
	}else{
		out.println("数据库中无商品");
	}
		
		
	%>
	<tr>
		<td> </td>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td><input type="submit" value="加入购物车" name="submit"></td>
	</tr>
	<tr>
		<td></td>
		<td><a href="index.jsp" >退出登录</a></td>
		<td></td>
		<td><a href="ShoppingCart.jsp">查看购物车</a></td>
	</tr>
	</table>
	</form>
	
	
</body>
</html>