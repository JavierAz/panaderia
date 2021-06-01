<%--
  Created by IntelliJ IDEA.
  User: javier
  Date: 12/05/21
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employed</title>
    <link href="css/employeeStyle.css" rel="stylesheet">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="sidenav">
    <div class="login-main-text">
        <h2>Panadería<br> Bienvenido</h2>
        <p>Login o registrate para tener acceso aquí.</p>
    </div>
</div>
<div class="main">
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <form name="LoginServlet" action="LoginServlet" method="post">
                <div class="form-group">
                    <p>${error}</p>
                    <label>Usuario</label>
                    <input type="text" class="form-control" placeholder="Usuario" name="usuario">
                </div>
                <div class="form-group">
                    <label>Contraseña</label>
                    <input type="password" class="form-control" placeholder="Contraseña" name="psw">
                </div>
                <button type="submit" class="btn btn-black">Entrar</button>
            </form>
            <a href="register.jsp" class="btn btn-outline-secondary">Registrarme</a>

        </div>
    </div>
</div>
</body>
</html>
