<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Mostrar animales</h1>
<%
try
{
   // Conexion con bd
   Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:","usuario2","password2");
   if (!conexion.isClosed())
   {
      // La consulta
      Statement st = conexion.createStatement();
      ResultSet rs = st.executeQuery("select *  from animales ");

      // Ponemos los resultados en un table de html
      out.println("<table border=\"1\"><tr><td>Id</td><td>Clave animal</td><td>tipo</td><td>edad</td></tr>");
      while (rs.next())
      {
         out.println("<tr>");
         out.println("<td>"+rs.getObject("CLAVE_ANIMAL")+"</td>");
         out.println("<td>"+rs.getObject("TIPO")+"</td>");
         out.println("<td>"+rs.getObject("EDAD")+"</td>");
         out.println("<td>"+rs.getObject("NOMBRE")+"</td>");
         out.println("</tr>");
      }
      out.println("</table>");

      // cierre de la conexion
      conexion.close();
   }
   else
      // Error en la conexion
      out.println("fallo");
}
catch (Exception e)
{
   // Error en algun momento.
   out.println("Excepcion "+e);
   e.printStackTrace();
}
%>
</body>
</html>