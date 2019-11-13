package ru.kpfu.filters;

import ru.kpfu.servlets.User;
import ru.kpfu.util.Reader;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CountryFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
            String user_sort_select = servletRequest.getParameter("user_sort_select");
            String fileName = "D:\\MAVEN_PROJECTS\\servletExample\\src\\main\\java\\ru\\kpfu\\servlets\\users.csv";
            List<User> users = Reader.readUsers(fileName);
            if (user_sort_select.equals("Country")) {
                users.sort(Comparator.comparing(User::getCountry));
            } else {
                users.sort((o1, o2) -> o1.isSex() == o2.isSex() ? 0 : -1);
            }
            servletRequest.setAttribute("users", users);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
