package org.example.command.show;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.example.Resources.*;

public class ShowChatPageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setIntHeader("Refresh", 10);
        request.setAttribute("messages", DataBase.getMessages());

        return new ForwardResult(PAGE_CHAT);
    }
}
