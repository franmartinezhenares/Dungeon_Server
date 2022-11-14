<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="../css/styles.css"%></style>


<!DOCTYPE html>
<html>
<head>
    <title>Start</title>
</head>
<body>
    <form method="get" action="/start"></form>
    Select Maze:
    <select name="maze_select" id="maze_select">
        <option value="maze_1">Maze 1</option>
        <option value="maze_2">Maze 2</option>
    </select>

</body>
</html>
