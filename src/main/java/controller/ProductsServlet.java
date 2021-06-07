package controller;

import db.ProductDaoDS;
import vw.Cart;
import vw.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductsServlet", urlPatterns = "/ProductsServlet")
public class ProductsServlet extends HttpServlet {
    ProductDaoDS dao = new ProductDaoDS();
    Product p = new Product();
    List<Product> products = new ArrayList<>();
    List<Cart> listCart = new ArrayList<>();
    int item;
    double total = 0.0;
    int cantidad = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        products = dao.getProducts();
        switch (action) {
            case "AddCar":
                int pos=0;
                int idProduct = Integer.parseInt(req.getParameter("id"));
                if (listCart.size()>0){
                    for (int i = 0; i < listCart.size(); i++) {
                        if (idProduct==listCart.get(i).getIdProducto()){
                            pos=i;
                        }
                    }
                    if (idProduct==listCart.get(pos).getIdProducto()){
                        cantidad+=listCart.get(pos).getCantidad();
                        double sub=listCart.get(pos).getPrecio()*cantidad;
                        listCart.get(pos).setCantidad(cantidad);
                        listCart.get(pos).setSubtotal(sub);
                    } else {
                        p = dao.listById(idProduct);
                        item += 1;
                        Cart cart = new Cart();
                        cart.setItem(item);
                        cart.setIdProducto(p.getIdProducto());
                        cart.setNombre(p.getProducto());
                        cart.setCantidad(cantidad);
                        cart.setPrecio(p.getPrecio());
                        cart.setSubtotal(cantidad * p.getPrecio());
                        listCart.add(cart);
                    }
                }else{
                    p = dao.listById(idProduct);
                    item += 1;
                    Cart cart = new Cart();
                    cart.setItem(item);
                    cart.setIdProducto(p.getIdProducto());
                    cart.setNombre(p.getProducto());
                    cart.setCantidad(cantidad);
                    cart.setPrecio(p.getPrecio());
                    cart.setSubtotal(cantidad * p.getPrecio());
                    listCart.add(cart);
                }

                req.setAttribute("count", listCart.size());
                req.getRequestDispatcher("ProductsServlet?action=home").forward(req, resp);
                break;
            case "Cart":
                total = 0;
                req.setAttribute("cart", listCart);
                for (Cart value : listCart) {
                    total += value.getSubtotal();
                }
                req.setAttribute("totalPago", total);
                req.getRequestDispatcher("cart.jsp").forward(req, resp);
                break;
            case "Delete":
                int idProducto = Integer.parseInt(req.getParameter("idp"));
                System.out.println("id "+idProducto);
                for (int i = 0; i < listCart.size(); i++) {
                    if (listCart.get(i).getIdProducto() == idProducto) {
                        listCart.remove(i);
                    }
                }
                break;
            default:
                req.setAttribute("products", products);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
        }
    }
}
