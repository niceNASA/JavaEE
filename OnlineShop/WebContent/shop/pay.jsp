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
	非常感谢您的光临！您本次在我们这里购买了一下商品：<br>
	<%
	ArrayList list = (ArrayList)session.getAttribute("list");
	for(int i=0;i<list.size();i++){
		String goodsName = (String)list.get(i);
	%>
	商品：<%=i %>:<%=goodsName %><br>
	<%} %>	
</body>

</html>