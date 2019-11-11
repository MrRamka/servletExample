package ru.kpfu.servlets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("user_name");
        String email = req.getParameter("user_email");
        String pass = req.getParameter("user_pass");
        String conf_pass = req.getParameter("conf_user_pass");
        String country = req.getParameter("user_country_select");
        String sex = req.getParameter("inlineRadioOptions");
        String about = req.getParameter("about_user");
        String consentForDataProcessing = req.getParameter("data_processing");
        if (pass.equals(conf_pass)) {
            File f = new File("C:\\Users\\ramil\\Desktop\\servletExample\\src\\main\\java\\ru\\kpfu\\servlets\\users.csv");
            FileWriter fileWriter = new FileWriter(f, true);
            fileWriter.write(name + "," + email + "," + pass + ',' + country + "," + sex + "," + about + "," + consentForDataProcessing + "\n");
            fileWriter.flush();
            fileWriter.close();
            req.setAttribute("status", Boolean.TRUE.toString());
            System.out.println(name + "," + email + "," + pass + ',' + country + "," + sex + "," + about + "," + consentForDataProcessing);
        } else {
            req.setAttribute("status", Boolean.FALSE.toString());
        }
        getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }
}