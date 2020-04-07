<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>test jsp</title>
</head>
<body>
<div id="field" style="margin:10px">
 </div>
<div style="height:200px;overflow:auto;">
    <table>
    <thead>
        <tr>
        	<th>color_number</th>
        	<th>name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach begin="0" end="${jsonArray.length() -1}" var="index">
        <tr  onclick="moveValue(this);">
             <td>${jsonArray.getJSONObject(index).getString("color_number")}</td>
             <td>${jsonArray.getJSONObject(index).getString("name")}</td>
        </tr>
        </c:forEach>
    </tbody>
    </table>
</div>
</body>
</html>
<script type="text/javascript">

  function moveValue(event)
  {
    var arr = Array.from(event.cells);

    var val = arr[0].innerHTML + "," + arr[1].innerHTML;
    var field = document.getElementById("field");
    field.innerHTML = val;
    field.style.color = arr[1].innerHTML
  }
</script>