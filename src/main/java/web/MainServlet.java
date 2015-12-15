package web;

import model.ClientEntity;
import model.ContractEntity;
import model.TarifEntity;
import services.ContractManager;
import services.ContractManagerImpl;
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
 * Created by oleg on 01.12.2015.
 */
public class MainServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String contractId = request.getParameter("contractId");
        ClientEntity user = (ClientEntity)request.getSession().getAttribute("user");
        ContractManager cm = new ContractManagerImpl();
        TarifManager tm = new TarifManagerImpl();
        ContractEntity contract = cm.findById(Integer.parseInt(contractId));

        int answer=0;

        try {
            answer = checkAction(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if( answer == 1|answer==2){
            request.getSession().setAttribute("contract", contract);
            request.getSession().setAttribute("user",user);
            response.sendRedirect("addDelOptions.jsp");
        }
        if (answer == 3){
            request.getSession().setAttribute("contract", contract);
            List<TarifEntity> tl = tm.loadAlltarif();
            request.getSession().setAttribute("allTarif", tl);
            response.sendRedirect("changeTarif.jsp");

        }
    }

    private int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("AddOption") != null) {
            return 1;
        }
        if (req.getParameter("DelOption") != null) {
            return 2;
        }
        if (req.getParameter("ChangeTarif") != null) {
            return 3;
        }
        /*if (req.getParameter("DeleteContract") != null) {
            if (req.getParameter("contractId") != null) {
                ContractEntity contract = ;
                s.setStudentId(Integer.parseInt(req.getParameter("studentId")));
                ManagementSystem.getInstance().deleteStudent(s);
            }
            return 0;
        }*/
        return 0;
    }
}
