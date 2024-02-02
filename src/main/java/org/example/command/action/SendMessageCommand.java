package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.data.message.Message;
import org.example.data.user.User;
import org.example.result.ForwardResult;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class SendMessageCommand implements Command {
    private static final String READONLY_MESSAGE = "Вам запрещена отправка сообщений";

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        String name = user.getName();
        Optional<String> text = Optional.ofNullable(request.getParameter("message-input"));

        if (user.isReadOnly()) {
            request.setAttribute("restrictionMessage", READONLY_MESSAGE);
        } else if (text.isPresent() && !text.get().isBlank()) {
            DataBase.addMessage(new Message(name, text.get()));
        }

        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }
}
