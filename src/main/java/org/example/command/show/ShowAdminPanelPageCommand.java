package org.example.command.show;

import org.example.command.Command;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.Resources.PAGE_ADMIN_PANEL;

public class ShowAdminPanelPageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new ForwardResult(PAGE_ADMIN_PANEL);
    }
}
