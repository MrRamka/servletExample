package ru.kpfu.filters;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BrowserFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        filterConfig = fConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        boolean filterFlag = httpRequest.getHeader("User-Agent").contains("OPR");
        if (filterFlag){
            filterConfig.getServletContext().getRequestDispatcher("/WEB-INF/moz.jsp").forward(request, response);
        }
        else{
            filterConfig.getServletContext().getRequestDispatcher("/WEB-INF/hello.jsp").forward(request, response);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
