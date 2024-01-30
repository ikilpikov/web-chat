<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <form action="chat?command=restrict_messages" method="post">
        <h2>Панель управления админа</h2>

        <ul class="user-list" name="users-list">
            <c:forEach items="${users}" var="user">
                <li class="user-item">
                    <label><c:out value="${user.login}"/></label>
                    <input type="hidden" name="login" value="${user.login}" />
                    <select name="status">
                        <c:choose>
                            <c:when test="${user.readOnly == true}">
                                <option value="true" selected>Только чтение</option>
                                <option value="false">Чтение и отправка</option>
                            </c:when>
                            <c:otherwise>
                                <option value="true">Только чтение</option>
                                <option value="false" selected>Чтение и отправка</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </li>
            </c:forEach>
        </ul>
        <div class="button-container">
            <button class="button" type="submit">Сохранить изменения</button>
        </div>
    </form>
</div>

</body>
</html>