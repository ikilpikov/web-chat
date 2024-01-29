<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Панель управления админа</title>
    <style>
        <%@include file="/WEB-INF/css/admin-panel.css" %>
    </style>
</head>
<body>
<div class="admin-panel">
    <h2>Панель управления админа</h2>
    <ul class="user-list">
        <li class="user-item">
            <label for="user1">Пользователь 1:</label>
            <select id="user1" name="user1">
                <option value="allow">Разрешено</option>
                <option value="deny">Запрещено</option>
            </select>
        </li>
        <li class="user-item">
            <label for="user2">Пользователь 2:</label>
            <select id="user2" name="user2">
                <option value="allow">Разрешено</option>
                <option value="deny">Запрещено</option>
            </select>
        </li>
    </ul>
    <div class="button-container">
        <button class="button" onclick="saveChanges()">Сохранить изменения</button>
    </div>
</div>

</body>
</html>