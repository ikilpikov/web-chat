<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вход в чат</title>
    <style>
        <%@include file="/WEB-INF/css/login.css" %>
    </style>
</head>
<body>
<div class="login-container">
    <h2>Вход</h2>
    <form action="chat?command=login" method="post">
        <label for="loginInput">Логин:</label>
        <input type="text" id="loginInput" name="loginInput" value="${loginInput}" required>

        <label for="passwordInput">Пароль:</label>
        <input type="password" id="passwordInput" name="passwordInput" required>

        <button type="submit">Войти</button>
        <h4>${errorLoginMessage}</h4>
    </form>
</div>
</body>
</html>