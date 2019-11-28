package ru.kpfu.servlets;

import ru.kpfu.dao.UserDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        int hashPass = pass.hashCode();

        List<String> roles = getRoles(req);
        UserDAO userDAO = new UserDAO();

        try {
            userDAO.addUser(name, email, String.valueOf(hashPass), roles);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        String conf_pass = req.getParameter("conf_user_pass");
//        String country = req.getParameter("user_country_select");
//        String sex = req.getParameter("inlineRadioOptions");
//        String about = req.getParameter("about_user");
//        String consentForDataProcessing = req.getParameter("data_processing");
//        if (pass.equals(conf_pass)) {
//            File f = new File("C:\\Users\\ramil\\Desktop\\servletExample\\src\\main\\java\\ru\\kpfu\\servlets\\users.csv");
//            FileWriter fileWriter = new FileWriter(f, true);
//            fileWriter.write(name + "," + email + "," + pass + ',' + country + "," + sex + "," + about + "," + consentForDataProcessing + "\n");
//            fileWriter.flush();
//            fileWriter.close();
//            req.setAttribute("status", Boolean.TRUE.toString());
//            } else {
//            req.setAttribute("status", Boolean.FALSE.toString());
//        }
        getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }

    private List<String> getRoles(HttpServletRequest req) {
        List<String> roles = new ArrayList<>();
        String s1 = req.getParameter("s1");
        String s2 = req.getParameter("s2");
        String s3 = req.getParameter("s3");
        String input = req.getParameter("input");
        if (s1 != null)
            roles.add(s1);
        if (s2 != null)
            roles.add(s2);
        if (s3 != null)
            roles.add(s3);
        if (input != null)
            roles.add(input);
        return roles;
    }
}