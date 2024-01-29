<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="icon" href="data:,">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Онлайн Чат</title>
    <style>
        <%@include file="/WEB-INF/css/chat.css" %>
    </style>
</head>
<body>

<div id="chat-container">
    <div id="messages-container"></div>

    <div id="input-container">
        <input type="text" id="message-input" placeholder="Введите сообщение...">
        <button id="send-button">Отправить</button>
    </div>

    <button id="logout-button">Выйти из аккаунта</button>
</div>
</body>
<script>
    <%@include file="/WEB-INF/js/chat.js" %>
</script>
</html>