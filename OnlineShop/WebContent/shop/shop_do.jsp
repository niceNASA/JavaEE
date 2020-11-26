<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 
<body>
	<%
	String goodsName = request.getParameter("goods");//获取商品名称
	if(!goodsName.equals("")){
	goodsName = new String(goodsName.getBytes("ISO-8859-1"),"UTF-8");  //解决中文乱码问题
		ArrayList list = null;  //定义保存商品的动态数组
		list = (ArrayList)session.getAttribute("list");  //通过list属性取得购物车
		if(list==null){
			list = new ArrayList();
			list.add(goodsName);
			session.setAttribute("list", list);
		}else{
			list.add(goodsName);
		}
	%>
	<%
	}else{
		response.sendRedirect("shop.jsp");
	}
	%>
	<center>
		<strong>提示：您刚才选择了商品
			<font color="red"><%=goodsName %></font>
			，请问您还想做什么？
		</strong><br><br>
		<button onclick="location.href='shop.jsp'">继续购买商品</button>
		<button onclick="location.href='pay.jsp'">到收银台结账</button>
	</center>
</body>

</html>