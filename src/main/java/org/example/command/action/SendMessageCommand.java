package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.Message;
import org.example.data.User;
import org.example.result.ForwardResult;
import org.example.result.Result;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;
import static org.example.Resources.PAGE_CHAT;

public class SendMessageCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String name = user.getName();
        String text = request.getParameter("message-input");

        if (!text.isBlank()) {
            DataBase.addMessage(new Message(name, text));
        }

        return new ForwardResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
