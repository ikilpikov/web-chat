package org.example.filter;

import org.example.data.User;
import org.example.data.UserType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

import static org.example.Resources.PAGE_CHAT;

public class AdminPanelFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Optional<Object> user = Optional.ofNullable(httpServletRequest.getSession().getAttribute("user"));

        if (isAdminCommand(httpServletRequest)) {
            if (user.isEmpty() || ((User) user.get()).getUserType() == UserType.CLIENT) {
                httpServletRequest.getRequestDispatcher(PAGE_CHAT).forward(request, response);
                return;
            }
        }


        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    private boolean isAdminCommand(HttpServletRequest request) {
        String query = "";
        query += request.getQueryString();
        return query.endsWith("admin_panel_page");
    }
}
