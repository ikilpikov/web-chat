package org.example.filter;

import org.example.data.user.User;
import org.example.data.user.UserType;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.FilterConfig;
import java.io.IOException;
import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class AdminPanelFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Optional<Object> user = Optional.ofNullable(httpServletRequest.getSession().getAttribute("user"));

        if (isAdminCommand(httpServletRequest)) {
            if (user.isEmpty() || ((User) user.get()).getUserType() == UserType.CLIENT) {
                httpServletRequest.getRequestDispatcher(COMMAND_SHOW_CHAT_PAGE).forward(request, response);
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
