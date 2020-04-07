<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test jsp</title>
</head>
<body>
<div style="height:100px;overflow:auto;">
    <table>
    <thead>
        <tr>
        	<th>color_number</th>
        	<th>name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="{jsonArray}" var="color">
            <tr>
                <td>${color.color_number}</td>
                <td>${color.name}</td>
            </tr>
        </c:forEach>
    </tbody>
    </table>
</div>
</body>
</html>