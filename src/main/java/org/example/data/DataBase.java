package org.example.data;

import java.util.ArrayList;
import java.util.List;

public final class DataBase {
    private static List<User> users = new ArrayList<>();

    private DataBase() {
    }

    public static List<User> getUsers() {
        return new ArrayList<>(users);
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
