package ru.kpfu.servlets;

import ru.kpfu.servlets.User;
import ru.kpfu.util.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class UsersFilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = "D:\\MAVEN_PROJECTS\\servletExample\\src\\main\\java\\ru\\kpfu\\servlets\\users.csv";
        List<User> users = Reader.readUsers(fileName);
        req.setAttribute("users", users);
        Cookie sortCookie = new Cookie("sortCookie", "No_sorting_method");
        resp.addCookie(sortCookie);
        /*Cookie sex_cookie = new Cookie("Sex", "Any");
        resp.addCookie(sex_cookie);*/
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("sortingMethod", "No_sorting_method");


        req.setAttribute("sortCookie", sortCookie.getValue());
        getServletContext().getRequestDispatcher("/WEB-INF/usersFilter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortSelector = req.getParameter("user_sort_select");
       // Cookie sortCookie = findCookie(req, "sortCookie");
        HttpSession httpSession = req.getSession();

//        if(sortCookie != null) {
//            sortCookie.setValue(sortSelector);
//            sortCookie.setMaxAge(-1);
//            resp.addCookie(sortCookie);
//        }
        if (httpSession.getAttribute("sortingMethod") != null){
            httpSession.setAttribute("sortingMethod", sortSelector);
            req.setAttribute("sortingMethod", httpSession.getAttribute("sortingMethod"));
        }

        // req.setAttribute("sortingMethod", sortCookie.getValue());

        getServletContext().getRequestDispatcher("/WEB-INF/usersFilter.jsp").forward(req, resp);
    }

    private static Cookie findCookie(HttpServletRequest request, String name) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

}