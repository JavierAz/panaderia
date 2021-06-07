package db;

import vw.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoDS {
    private final String productsQuery = "SELECT * FROM Producto";
    private final String stockQuery = "SELECT * FROM Stock WHERE IdProducto = ?";
    private final String productById = "SELECT * FROM Producto where idProducto = ?";

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection con = DataSource.getConnection(); PreparedStatement pst = con.prepareStatement(productsQuery); PreparedStatement pst2 = con.prepareStatement(stockQuery)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setIdProducto(rs.getInt("IdProducto"));
                product.setProducto(rs.getString("Producto"));
                product.setPrecio(rs.getDouble("Precio"));

                pst2.setInt(1, product.getIdProducto());
                ResultSet rs2 = pst2.executeQuery();
                while (rs2.next()) {
                    product.setCantidad(rs2.getInt("Cantidad"));
                    products.add(product);
                }
                //products.add(product);
            }
        } catch (Exception e) {
            throw new RuntimeException("error getProducts", e);
        }
        return products;
    }

    public Product listById(int id) {
        Product p = new Product();
        try(Connection conn = DataSource.getConnection(); PreparedStatement pst = conn.prepareStatement(productById); PreparedStatement pst2 = conn.prepareStatement(stockQuery)){
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                p.setIdProducto(rs.getInt("IdProducto"));
                p.setProducto(rs.getString("Producto"));
                p.setPrecio(rs.getDouble("Precio"));

                pst2.setInt(1, p.getIdProducto());
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                    p.setCantidad(rs2.getInt("Cantidad"));
                }
            }
        } catch (Exception e){
            throw new RuntimeException("error en ListById", e);
        }
        return p;
    }
}
