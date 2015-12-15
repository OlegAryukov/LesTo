package web;

import model.ClientEntity;
import model.ContractEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by oleg on 03.12.2015.
 */
public class ChangeTarif extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                ContractEntity contract = (ContractEntity)request.getSession().getAttribute("contract");
                ClientEntity user = (ClientEntity)request.getSession().getAttribute("user");
                String tarifId = request.getParameter("tarifId");
                ChangeTarifService cts = new ChangeTarifService();
                cts.changeTarif(contract,tarifId);
                //request.getSession().setAttribute("user", user);
                response.sendRedirect("main.jsp");
        }

    }
