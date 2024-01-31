<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link rel="icon" href="data:,">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Онлайн Чат</title>
    <style>
        <%@include file="/WEB-INF/css/chat.css" %>
    </style>
</head>
<body>
<div class="container">
    <div id="chat-container">
        <div id="messages-container">
            <c:forEach items="${messages}" var="message">
                <div class="message">
                    <span class="sender"><c:out value="${message.name}:"/></span>
                    <c:out value="${message.text}"/>
                </div>
            </c:forEach>
        </div>

        <form id="input-container" action="chat?command=send_message" method="post">
            <input type="text" id="message-input" name="message-input" placeholder="Введите сообщение...">
            <button id="send-button" type="submit">Отправить</button>
        </form>

        <div class="button-container">
            <button id="logout-button">Выйти из аккаунта</button>
            <c:if test="${user.userType eq 'ADMIN'}">
                <button id="admin-button">Управление правами пользователей</button>
            </c:if>
        </div>
        <h4>${restrictionMessage}</h4>
    </div>
</div>
</body>
<script>
    <%@include file="/WEB-INF/js/chat.js" %>
</script>
</html>