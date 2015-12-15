package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by oleg on 03.12.2015.
 */
public class TarifsServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tarifId = request.getParameter("tarifId");
        ChangeTarifService cts = new ChangeTarifService();
        //cts.changeTarif(contract,tarifId);
        //request.getSession().setAttribute("user", user);
        response.sendRedirect("main.jsp");
    }
    private int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("Change") != null) {
            return 1;
        }
        if (req.getParameter("Delete") != null) {
            return 2;
        }
        if (req.getParameter("Add") != null) {
            return 3;
        }
        return 0;
    }
}
