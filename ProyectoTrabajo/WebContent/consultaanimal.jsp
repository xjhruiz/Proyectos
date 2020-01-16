<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="objetos.Animal"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META HTTP-EQUIV="REFRESH" CONTENT="5;URL=http://www.desarrolloweb.com">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="ConsultaAnimal">
	¿Qué id de animal quiere consultar? <input type="text" name="numero"/>
	
	<input type="submit" value="enviar"/>
		
	</form>
	<% if (request.getAttribute("animal")!=null){
		Animal ani=(Animal)request.getAttribute("animal");%>
		<%=ani.toString() %>
		<%}else if(request.getAttribute("mensaje")!=null){ %>
		<%=request.getAttribute("mensaje") %>
		<%} %>
</body>
</html>