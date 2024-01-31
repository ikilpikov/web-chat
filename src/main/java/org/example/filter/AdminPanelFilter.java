package org.example.filter;

import org.example.data.user.User;
import org.example.data.user.UserType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.PAGE_CHAT;

public class AdminPanelFilter implements Filter {
    private static final String NOT_ADMIN_MESSAGE = "Вам запрещено редактировать права пользователей";

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
