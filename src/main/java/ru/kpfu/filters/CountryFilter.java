package ru.kpfu.filters;

import ru.kpfu.servlets.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        if(httpRequest.getMethod().equalsIgnoreCase("POST")) {
            String sortByCountry = servletRequest.getParameter("user_country_select");
            String sortBySex = servletRequest.getParameter("user_sex_select");
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
                if (sortByCountry.equals("Any") && sortBySex.equals("Any")) {
                    users.add(new User(name, email, country, sex, about, consentForDataProcessing));
                }else if(country.equals(sortByCountry) && sortBySex.equals("Any")){
                    users.add(new User(name, email, country, sex, about, consentForDataProcessing));
                }else if(sortByCountry.equals("Any") && (sex ? "Male" : "Female").equalsIgnoreCase(sortBySex)){
                    users.add(new User(name, email, country, sex, about, consentForDataProcessing));
                }
                else if (country.equals(sortByCountry) && (sex ? "Male" : "Female").equalsIgnoreCase(sortBySex)) {
                    users.add(new User(name, email, country, sex, about, consentForDataProcessing));
                }
            }
            servletRequest.setAttribute("users", users);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
