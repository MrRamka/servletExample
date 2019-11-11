package ru.kpfu.servlets;

import ru.kpfu.servlets.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersFilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File f = new File("C:\\Users\\ramil\\Desktop\\servletExample\\src\\main\\java\\ru\\kpfu\\servlets\\users.csv");
        Scanner scanner = new Scanner(f);
        List<User> users = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String raw_input = scanner.nextLine();
            String[] items = raw_input.split(",");
            String name = items[0];
            String email = items[1];
            String country = items[3];
            boolean sex = items[4].equals("m");
            String about = items[5];
            boolean consentForDataProcessing = items[6].equals("on");
            users.add(new User(name, email, country, sex, about, consentForDataProcessing));
        }
        req.setAttribute("users", users);
        Cookie country_cookie = new Cookie("Country", "Any");
        resp.addCookie(country_cookie);
        Cookie sex_cookie = new Cookie("Sex", "Any");
        resp.addCookie(sex_cookie);

        req.setAttribute("country_cookie", country_cookie.getValue());
        req.setAttribute("sex_cookie", sex_cookie.getValue());
        System.out.println(country_cookie.getValue() + " " + sex_cookie.getValue());
        getServletContext().getRequestDispatcher("/WEB-INF/usersFilter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortByCountry = req.getParameter("user_country_select");
        String sortBySex = req.getParameter("user_sex_select");
        Cookie countryCookie = findCookie(req, "Country");
        Cookie sexCookie = findCookie(req, "Sex");
        if(countryCookie != null) {
            countryCookie.setValue(sortByCountry);
            countryCookie.setMaxAge(-1);
            resp.addCookie(countryCookie);
        }
        if(sexCookie != null) {
            sexCookie.setValue(sortBySex);
            sexCookie.setMaxAge(-1);
            resp.addCookie(sexCookie);
        }
        req.setAttribute("country_cookie", countryCookie.getValue());
        req.setAttribute("sex_cookie", sexCookie.getValue());
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