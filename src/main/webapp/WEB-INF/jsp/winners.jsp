<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/css/styles.css"%></style>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Winners</title>
</head>
<body>

    <h1>Lista de Winners</h1>

    <div class="winners_list">
        <table class="winners_table">
            <tr>
                <th>Player</th>
                <th>Maze</th>
                <th>Time</th>
            </tr>

    <c:forEach var="winner" items="${winnerslist}">
            <tr>
                <td class="table_value">name</td>
                <td class="table_value">maze</td>
                <td class="table_value">time</td>
            </tr>
    </c:forEach>

        </table>
    </div>


</body>
</html>