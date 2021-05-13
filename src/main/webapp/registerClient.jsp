<%--
  Created by IntelliJ IDEA.
  User: javier
  Date: 12/05/21
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrarse</title>
    <link rel="stylesheet" href="css/loginStilo.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Login Form -->
        <div class="fadeIn first">
            <h1>Registrarse</h1>
        </div>
        <form>
            <p>Nombre</p>
            <input type="text" id="#" class="fadeIn second" name="" placeholder="Nombre">
            <p>Apellido Paterno</p>
            <input type="text" id="#2" class="fadeIn third" name="" placeholder="Apellido Paterno">
            <p>Apellido Materno</p>
            <input type="text" id="#3" class="fadeIn third" name="" placeholder="Apellido Materno">
            <p>CURP</p>
            <input type="text" id="#4" class="fadeIn third" name="" placeholder="CURP">
            <p>Usuario</p>
            <input type="text" id="#5" class="fadeIn third" name="" placeholder="Usuario">
            <p>Contraseña</p>
            <input type="text" id="#6" class="fadeIn third" name="" placeholder="Contrasena">

            <input type="submit" class="fadeIn fourth" value="Registrarme">
        </form>
        <div id="formFooter">
            <a class="underlineHover" href="#">Cancelar</a>
        </div>
    </div>
</div>
</body>
</html>
