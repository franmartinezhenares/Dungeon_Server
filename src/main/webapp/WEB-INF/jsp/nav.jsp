<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/css/styles.css"%></style>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Navigation</title>
</head>
<body>

    <div class="canvas_container">
        <canvas id="navigation_canvas" width="640" height="360"></canvas>
    </div>

    <script type="application/json">
    ${myjson}
    </script>

    <%-- <script>
        let dataScript = document.getElementById("mydata").textContext;
        let data = JSON.parse(dataScript);
        console.log(dta.walls.N);
    </script> --%>

   <script src="/js/canvas_script.js"></script>

</body>
</html>