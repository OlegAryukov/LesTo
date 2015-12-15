package web;

import model.ClientEntity;
import services.ClientManager;
import services.ClientManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by oleg on 26.11.2015.
 */
public class ClientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        ClientManager cm = new ClientManagerImpl();
        ClientEntity wanted = cm.findByPersonName("Oleg", "Arykov");
        String a = wanted.getEmail();
        Writer w = resp.getWriter();
        w.write("kjhg" + a + "terer");
        w.close();*/

    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String family = req.getParameter("family");
        String passport = req.getParameter("passport");
        String berthday = req.getParameter("berthday");
        String adress = req.getParameter("adress");

        HttpSession session = req.getSession(true);
        try {
        ClientEntity one = new ClientEntity(name,family,berthday,passport,adress);
        ClientManager cm = new ClientManagerImpl();
        cm.saveNewClient(one);
        } catch (Exception e) {

            e.printStackTrace();
        }


    }
}
