package org.example.command.show;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.user.User;
import org.example.data.user.UserType;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.example.Resources.PAGE_ADMIN_PANEL;

public class ShowAdminPanelPageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = DataBase
                .getUsers()
                .stream()
                .filter(x -> x.getUserType() == UserType.CLIENT)
                .collect(toList());

        request.setAttribute("users", users);
        return new ForwardResult(PAGE_ADMIN_PANEL);
    }
}
