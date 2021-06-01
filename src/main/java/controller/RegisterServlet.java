package controller;

import db.UserDaoDS;
import vw.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setNombre(request.getParameter("Nombre"));
        user.setPaterno(request.getParameter("Paterno"));
        user.setMaterno(request.getParameter("Materno"));
        user.setCurp(request.getParameter("CURP"));
        user.setUsuario(request.getParameter("usuario"));
        user.setPsw(request.getParameter("psw"));

        UserDaoDS dao = new UserDaoDS();
        if(dao.insertUser(user)){
            //get the old session and invalidate
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("usuario", user.getUsuario());
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("error", "No se pudo agregar");
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.forward(request, response);
        }
    }
}
