<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/css/styles.css"%></style>


<!DOCTYPE html>
<html>
<head>
    <title>Start</title>
</head>
<body>

    <h1 class="h1_header">Welcome to MAZE</h1>

    <div class="start_form_container">
        <form method="post" action="/start">
            Select Maze:
            <select name="maze_select" id="maze_select">
                <option value=1>Tutorial Maze</option>
                <option value=2>Peres Maze</option>
            </select>
            <div class="start_submit">
                <input id="play_button" type="submit" name="play" value="Play">
            </div>
        </form>
    </div>


</body>
</html>
