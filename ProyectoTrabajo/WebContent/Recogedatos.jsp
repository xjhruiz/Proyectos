<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<META HTTP-EQUIV="REFRESH" CONTENT="3;URL=index.jsp">
</head>
<body>
<div class=exito>

<%
		String nombre=request.getParameter("nombre");
		String apellido=request.getParameter("apellido");
		String aportacion=request.getParameter("aportacion");
		String acti=request.getParameter("mensaje");
		String dir=request.getParameter("direccion");
		String tel=request.getParameter("telefono");
		
		//llamo a la clase que me permite conectar la bbdd
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//digo que bbdd usuario pass
		try{
		Connection con=java.sql.DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:","usuario2","password2");
        //creo statement = hoja bd
		Statement stmt=con.createStatement();
		// creo la instruccion (consulta) bbdd
		String instruccionSql="Insert into COLABORADORES (NOMBRE, APELLIDO, APORTACION, ACTIVIDAD,dir, telefono) values('"+nombre+"','"+
		
																						apellido+"','"+aportacion+"','"+acti+"','"+dir+"','"+tel+"' )";
		//igual a el nombre de la variable recogida del formulario
		stmt.executeUpdate(instruccionSql); 
		
		out.print("Registrado con éxito");
		//digo que se actualize y se realice 
		}catch(Exception e){
			out.println("Error usuario mal introducido");
		}


%>
</div>
</body>
</html>