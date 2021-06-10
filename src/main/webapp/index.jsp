<%--
  Created by IntelliJ IDEA.
  User: javier
  Date: 12/05/21
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pan</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand fas fa-home" href="index.jsp"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="ProductsServlet?action=home">articulos</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="login.jsp">iniciar sesión</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ProductsServlet?action=Cart"><i class="fas fa-cart-plus">(<label>${count}</label>)</i>Carrito</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Buscar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
        </form>
    </div>
</nav>
<div class="jumbotron">
    <h1 class="display-4">Bienvenido! ${usuario}</h1>
    <p class="lead">Pantalla donde se mostraran los panes y su informacion.</p>
    <hr class="my-4">
    <p>Aún no eres parte de nuestra comunidad?</p>
    <p class="lead">
        <a class="btn btn-primary btn-lg" href="register.jsp" role="button">Registrate!</a>
    </p>
</div>
<div class="container mt-1">
    <div class="row">
        <c:forEach var="p" items="${products}">
            <div class="col-sm-4">
                <div class="card">
                    <div class="card-header">
                        <h3>${p.getProducto()}</h3>
                    </div>
                    <div class="card-body">
                        <label>Precio:</label>
                        <i>$ ${p.getPrecio()}</i><br>
                        <label>Cantidad en Stock</label>
                        <p>${p.getCantidad()}</p>
                    </div>
                    <div class="card-footer text-center">
                        <div>
                            <a class="btn btn-outline-success" href="ProductsServlet?action=AddCar&id=${p.getIdProducto()}">agregar al carrito</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
