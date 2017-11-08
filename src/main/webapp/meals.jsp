<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>

<style type="text/css">
    .exceeded_meal{color:red}
    .normal_meal{color:green}
</style>

<table class="tftable" border="1">
    <thead><tr><th>Description</th><th>Date</th><th>Calories</th></tr></thead>
    <tbody>
        <c:forEach var="meal" items="${list}">

            <tr>

                <c:if test="${meal.exceed == true}">
                    <th><p class="exceeded_meal">${meal.description}</p></th>
                    <th><p class="exceeded_meal">${meal.dateTime}</p></th>
                    <th><p class="exceeded_meal">${meal.calories}</p></th>
                </c:if>
                <c:if test="${meal.exceed == false}">
                    <th><p class="normal_meal">${meal.description}</p></th>
                    <th><p class="normal_meal">${meal.dateTime}</p></th>
                    <th><p class="normal_meal">${meal.calories}</p></th>
                </c:if>

            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
