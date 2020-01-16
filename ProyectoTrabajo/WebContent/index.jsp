<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximun-scale=1, minimun-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Nunca Solos   **Albergue para mascotas** </title>
	<link rel="stylesheet" href='css/style1.css'>
    <link rel="stylesheet" href='css/css1.css'>
</head>
 <body> 
       <header>
       
        <div class="cabecera">
           
            <h1 class="logo"><a title="home" href="index.jsp"><img src="img/logo1.1.png" alt="home" width="95" height="60"></a>Nunca Solos</h1>
            <input type="checkbox" id="menu-bar">
            <label class="icon-paragraph-justify" for="menu-bar" id="btn-menu"></label>
         <!--PAra trabajar con ul li -->
            <nav class="menu">
            <!--headrmenu-->  
               <ul class="des">
               <!--nav des -->
                <li><a href="index.jsp">Inicio</a></li>
                <li><a title="Consultar animales" href="consultaanimal.jsp">Mascotas</a>
                   <ul>
                    <li><a  title="Adopción" href="Adopcion.html">Adopción</a></li>
                    
                   </ul>
                </li>
                <li><a  title="Visítanos" href="ubicacion.html">Ubicación</a></li>
                <li><a  title="Contáctanos" href="Formulario.html">Contacto</a></li>
                <li><a  title="Colaboración" href="Colabora.html">Colabora</a></li>
                </ul>
            </nav>
        </div>
      </header>
     <main>
     <section id="banner">
         <img src="img/banner.jpg">
        <div class="cabecera">
         <h2>Mascotas y Personas Felices </h2>
         <p>Encuentre la suya</p>
         <!-- Página que llevará a Contacto-->
         <a href="Adopcion.html" title="Adopción">Leer más</a> 
        </div>
     </section>
     <section id="bienvenidos">
         <!--Pensar en que poner y que tenga que ver con la adopción de mascotas-->
         <div class="cabecera">
         <h2>¿Estas buscando un nuevo compañero?</h2>
         
         </div>
     </section>
     <section id="ultimo">
         
        <div class="cabecera">
         <article>
            <a title="Mascotas" href="Adopcion.html"><img src="img/imagen2.PNG"></a>
             <h4>Escoge la mascota que más te guste</h4>
         </article>
         <article>
            <a title="Colaboración" href="Colabora.html"><img src="img/image.jpg" ></a>
             <h4>Los animales te necesitan</h4>
         </article>
         <article>
           <!-- poner link a contacto-->
            <a title="Visitanos" href="ubicacion.html"><img  src="img/logo1.PNG" width="250" height="181"></a>
             <h4>Visitanos</h4>
         </article>
         </div>
     </section>
     
     </main>
    
     <footer id="final"> 
         <div class="cabecera">
             <p class="copy">Jhonatan Ruiz &copy; 2017</p>
             <div class="sociales">
                 <a class="icon-google-plus" href=""></a>
                 <a class="icon-facebook2" href=""></a>
                 <a class="icon-instagram" href=""></a>
                 <a class="icon-twitter" href=""></a>
             </div>
         </div>
     </footer>
    </body>
</html>