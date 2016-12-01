package inno.filter;


import inno.model.User;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "authenticationFilter", urlPatterns = {"/posts/delete/*", "/posts/add"})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendError(401, "Пожалуйста авторизируйтесь");
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
