<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<style type="text/css">
    .exceeded_meal{color:red}
    .normal_meal{color:green}
</style>

<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>

<table class="tftable" border="1">
    <thead><tr><th>Description</th><th>Date</th><th>Calories</th></tr></thead>
    <tbody>
        <c:forEach var="meal" items="${list}">
            <c:set var="cls" value="${(meal.exceed == true) ? 'exceeded_meal' : 'normal_meal'}"/>
            <tr>
                <th><p class="${cls}">${meal.description}</p></th>
                <th><p class="${cls}">${meal.dateTime}</p></th>
                <th><p class="${cls}">${meal.calories}</p></th>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
