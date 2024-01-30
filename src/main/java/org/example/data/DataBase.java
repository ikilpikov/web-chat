package org.example.data;

import org.example.data.message.Message;
import org.example.data.user.User;
import org.example.data.user.UserType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class DataBase {
    private static List<User> users = new ArrayList<>();
    private static List<Message> messages = new ArrayList<>();

    private DataBase() {
    }

    public static List<User> getUsers() {
        return new ArrayList<>(users);
    }

    public static void setReadonlyByLogin(String login, Boolean readOnly) {
        users = users
                .stream()
                .map(x -> {
                    if (x.getLogin().equals(login)) {
                        x.setReadOnly(readOnly);
                    }
                    return x;
                })
                .collect(Collectors.toList());

    }

    public static List<Message> getMessages() {
        return new ArrayList<>(messages);
    }

    public static void addMessage(Message message) {
        messages.add(message);
    }
    public static void init() {
        users.add(new User("asd", "asd", "Kirill", UserType.CLIENT));
        users.add(new User("qwe", "qwe", "Anton", UserType.CLIENT));
        users.add(new User("tyu", "tyu", "Ilya", UserType.ADMIN));

        System.out.println("Установка соединения с Базой Данных");
    }

    public static void close() {
        System.out.println("Закрытие соединения с Базой Данных");
    }
}
