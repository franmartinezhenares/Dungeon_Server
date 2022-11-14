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

    <h1>Bienvenido a MAZE</h1>
    <br />

    <form method="post" action="/start">
        Select Maze:
        <select name="maze_select" id="maze_select">
            <option value=1>Maze 1</option>
            <option value=2>Maze 2</option>
            <br />
            <input type="submit" name="play" value="Play">
        </select>
    </form>

</body>
</html>
