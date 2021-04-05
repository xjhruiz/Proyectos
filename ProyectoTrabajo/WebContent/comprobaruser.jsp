<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>


<%
		String usuario=request.getParameter("usuario");

		String contras=request.getParameter("contra");
		
		
		//llamo a la clase que me permite conectar la bbdd
		
		//digo que bbdd usuario pass
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try{
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:","proyecta","password");
        //creo statement = hoja bd
		//evita las injecciones sql
		PreparedStatement pstmt=con.prepareStatement("SELECT * FROM EJEMPLO WHERE USUARIO=? AND CONTRA=?");
		
        pstmt.setString(1, usuario);
        pstmt.setString(2, contras);
        //Los datos recogidos almacenara en el resulset
       
		//igual a el nombre de la variable recogida del formulario
		//devuelve verdadero si hay informacion y false si no la hay
		//(1)indco que se vaya al primer registro
		//digo que se actualize y se realice 
		 ResultSet rst=pstmt.executeQuery();
        
		if(rst.absolute(1)) out.println("Usuario autorizado");
		else out.println("No hay usuarios con esos datos");
		
		}catch(Exception e){
			out.println("error");
		}


%>
</body>
</html>