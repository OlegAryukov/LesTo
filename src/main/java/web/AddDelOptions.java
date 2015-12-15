package web;

import model.ClientEntity;
import model.ContractEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by oleg on 02.12.2015.
 */
public class AddDelOptions extends HttpServlet {

    AddDelOptionsService serviceOp = new AddDelOptionsService();
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ClientEntity user = (ClientEntity)request.getSession().getAttribute("user");
        ContractEntity contract = (ContractEntity)request.getSession().getAttribute("contract");
        int contractId = contract.getContractId();
        //System.out.println(optionId + " " + contractId);
        int answer=0;

        try {
            answer = checkAction(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if( answer == 1){
            int optionId = Integer.parseInt(request.getParameter("add"));
            serviceOp.addOption(contractId,optionId);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("main.jsp");
        }
        if( answer == 2 ){
            int delOptionId = Integer.parseInt(request.getParameter("del"));
            serviceOp.delOption(contractId, delOptionId);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("main.jsp");
        }


    }
    private int checkAction(HttpServletRequest req) throws SQLException {
        if (req.getParameter("AddOption") != null) {
            return 1;
        }
        if (req.getParameter("DelOption") != null) {
            return 2;
        }
        return 0;
    }
}
