<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 
<body>
	<form id="form1" name="form1" method="post" action="shop_do.jsp">
		<p><strong>请选择你要购买的商品</strong></p>
		<table width="300" border="1">
			<tr>
				<td>商品名：</td>
				<td><input type="text" name="goods"></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<input type="submit" name="Submit" value="加入购物车">
						<input type="reset" name="Submit2" value="重选">
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
 
</html>