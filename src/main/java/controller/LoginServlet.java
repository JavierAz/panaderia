package controller;

import db.UserDaoDS;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("pide la conexión");
        String usuario = request.getParameter("usuario");
        String psw = request.getParameter("psw");
        System.out.println();

        UserDaoDS dao = new UserDaoDS();
        if (dao.findUser(usuario, psw)!= null){
            //get the old session and invalidate
            HttpSession oldSession = request.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }
            //generate a new session
            HttpSession newSession = request.getSession(true);
            newSession.setAttribute("usuario", usuario);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("error", "credenciales invalidas");
            RequestDispatcher dispatcher = request.getRequestDispatcher("loginEmployee.jsp");
            dispatcher.forward(request, response);
        }
    }
}
