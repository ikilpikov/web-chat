package org.example.command.action;

import org.example.command.Command;
import org.example.data.DataBase;
import org.example.result.ForwardResult;
import org.example.result.RedirectResult;
import org.example.result.Result;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.Resources.COMMAND_SHOW_CHAT_PAGE;

public class MessagesRestricitonCommand implements Command {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> loginValues = List.of(request.getParameterValues("login"));
        List<Boolean> statusValues = extractStatusValues(request.getParameterValues("status"));

        for (int i = 0; i < statusValues.size(); i++) {
            DataBase.setReadOnlyByLogin(loginValues.get(i), statusValues.get(i));
        }

        return new RedirectResult(COMMAND_SHOW_CHAT_PAGE);
    }

    private List extractStatusValues(String[] statuses) {
        List<Boolean> statusValues = new ArrayList<>();

        if (statuses != null) {
            for (String status : statuses) {
                statusValues.add(Boolean.parseBoolean(status));
            }
        }

        return statusValues;
    }

}


