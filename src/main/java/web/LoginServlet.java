package web;

/**
 * Created by oleg on 30.11.2015.
 */
import model.ClientEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userEmail = request.getParameter("userId");
        String password = request.getParameter("password");
        LoginService loginService = new LoginService();
        boolean result = loginService.authenticateUser(userEmail, password);
        ClientEntity user = loginService.getUserByUserId(userEmail);
        if(result == true){
            request.getSession().setAttribute("user", user);
            response.sendRedirect("main.jsp");
        }
        else{
            response.sendRedirect("error.jsp");
        }
    }

}

