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

    <h1 class="h1_header">You Win!</h1>
    <div class="endform_container">
        <h1>Insert your name</h1>
        <h1>Amongst Winners</h1>
        <form method="post" action="/endform">
            <input class="endform_input" type="text" name="player_name">
            <input id="endform_button" type="submit" value=Send>
        </form>
    </div>
</body>
</html>