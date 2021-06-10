<%--
  Created by IntelliJ IDEA.
  User: javier
  Date: 04/06/21
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrito</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Panaderia</a>
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
                <a class="nav-link disabled" href="ProductsServlet?action=Cart"><i class="fas fa-cart-plus">(<label>${count}</label>)</i>Carrito</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Buscar">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
        </form>
    </div>
</nav>
<div class="container mt-4">
    <h2>Carrito de compras</h2>
    <h3><i>Nomás eso?</i></h3>
    <div class="row">
        <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="car" items="${cart}">
                        <tr>
                            <td>${car.getItem()}</td>
                            <td>${car.getNombre()}</td>
                            <td>${car.getPrecio()}</td>
                            <td>${car.getCantidad()}</td>
                            <td>${car.getSubtotal()}</td>
                            <td>
                                <input type="hidden" id="idp" value="${car.getIdProducto()}">
                                <a class="btn btn-danger" id="btnDelete">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-sm-4">
            <div class="card">
                <div class="card-header">
                    <h3>Generar compra</h3>
                </div>
                <div class="card-body">
                    <label>SubTotal:</label>
                    <input type="text" value="$${totalPago}" readonly class="form-control">
                    <label>Descuento:</label>
                    <input type="text" readonly class="form-control" value="$0.00">
                    <label>Total:</label>
                    <input type="text" readonly class="form-control" value="${totalPago}">
                </div>
                <div class="card-footer">
                    <a href="" class="btn btn-info btn-block">Realizar pago</a>
                    <a class="btn btn-danger btn-block">Generar Compra</a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="js/functions.js" type="text/javascript"></script>
<script src="bootstrap/jquery-3.2.1.js"></script>
</body>
</html>
