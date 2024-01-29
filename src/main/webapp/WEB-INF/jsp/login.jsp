<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Вход в чат</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      text-align: center;
      margin-top: 100px;
    }

    h4 {
      color: red;
    }

    .login-container {
      width: 300px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    input {
      width: 100%;
      padding: 10px;
      margin: 8px 0;
      box-sizing: border-box;
    }

    button {
      width: 100%;
      padding: 10px;
      background-color: #0F0F0F;
      color: #fff;
      border: none;
      border-radius: 3px;
      cursor: pointer;
      margin-top: 10px;
    }

    button:hover {
      background-color: #636060;
    }
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