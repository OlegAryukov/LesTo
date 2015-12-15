package web;

import model.TarifEntity;
import services.TarifManager;
import services.TarifManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by oleg on 03.12.2015.
 */
public class AdminServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int answer=0;

        try {
            answer = checkAction(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if( answer == 1){

            response.sendRedirect("addDelOptions.jsp");
        }
        if( answer == 2){

            response.sendRedirect("addDelOptions.jsp");
        }
        if( answer == 3){
            TarifManager tm = new TarifManagerImpl();
            List<TarifEntity> allTarif = tm.loadAlltarif();
            request.getSession().setAttribute("tarifs",allTarif);
            response.sendRedirect("tarifs.jsp");
        }
        if( answer == 4){

            response.sendRedirect("addDelOptions.jsp");
        }

    }
    private int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("Clients") != null) {
            return 1;
        }
        if (req.getParameter("Contracts") != null) {
            return 2;
        }
        if (req.getParameter("Tarifs") != null) {
            return 3;
        }
        if (req.getParameter("Options") != null) {
            return 4;
        }
        return 0;
    }
}
