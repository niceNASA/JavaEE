<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>购物车</title>
</head>
<body>
<h2>在线商店|购物车</h2>
<h4>以下商品已加入购物车：</h4>
	<% 	String goodsList = null;
			if(request.getParameter("goods")==null){
				//response.sendRedirect("ProductList.jsp");
				out.println("未选择商品<br/>");
			}else{
			goodsList = request.getParameter("goods");
			
			ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
			list.add(goodsList);
			out.println(goodsList);
		}
		%>
	<br/>
	<br/>
<h4>以下是购物车中的商品：</h4>
	<form method="post" action="">
	<table>
	<tr>
	<th>编号</th>
	<th>商品</th>
	</tr>
	<%
	if(session.getAttribute("list")!=null){
	ArrayList list = (ArrayList)session.getAttribute("list");
	for(int i=0;i<list.size();i++){
		String goodsName = (String)list.get(i);
		out.println("<tr><td>"+i+" </td><td>"+goodsName+"</td><td>");
		out.println("<td><input type='radio' name='delete' value='"+goodsName+"'></td></th>");
		} 
	}else{
		out.println("您还未添加商品");
	}
	
	%>	
	<tr>
	<td></td>
	<td></td>
	<td><input type="submit" value="移除所选商品" formaction="/OnlineShop/ShoppingServlet"></td>
	</tr>
	</table>
	</form>
	
	
<br/>
<br/>
<a href="ProductList.jsp">继续购物</a><br /><br />
<form action="" method="post">
	<input type="submit" value="结算" formaction="/OnlineShop/PayServlet" />
</form>

		

</body>
</html>