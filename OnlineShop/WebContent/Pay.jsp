<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="com.oshop.Model.Goods" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pay</title>
</head>
<body>
<h2>在线商店|结算</h2>


<%
	if(session.getAttribute("payList")!=null){
	ArrayList<Goods> list = (ArrayList<Goods>)session.getAttribute("payList");
	double sum = 0;
	for(int i=0;i<list.size();i++){
		Goods good = list.get(i);
		double temp = good.getPrice();
		sum += temp;
		out.println("商品"+i+": "+good.getName()+"		价格: ￥"+temp+"<br/>");
	} 
	out.println("合计: ￥"+sum+"<br/>");
	}else{
		out.println("您还未添加商品");
	}
	
	%>	
<br/>
<a href="ProductList.jsp">继续购物</a>
<script type="text/javascript">
	function api(){
		alert("在此处接入第三方支付api");
	}
</script>
<input type="button" value="结算" onclick="api()">	
<!--此处可调用第三方支付API-->
</body>
</html>