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

    <h1 class="h1_header">Winners List</h1>

    <div class="winners_list">
        <table class="winners_table">
            <tr>
                <th class="table_header">Player</th>
                <th class="table_header">Maze</th>
                <th class="table_header">Time</th>
            </tr>

    <c:forEach var="winner" items="${winnerslist}">
            <tr>
                <td class="table_value">${winner.getWinnerName()}</td>
                <td class="table_value">${winner.getMazeSolved()}</td>
                <td class="table_value">${winner.getFormattedTime()}</td>
            </tr>
    </c:forEach>

        </table>
    </div>


</body>
</html>