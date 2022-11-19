<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/css/styles.css"%></style>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>End Form</title>
</head>
<body>

    <h1>Insert your name</h1>
    <form method="get" action="/winners">
        <input type="text" name="player_name">
    </form>

</body>
</html>