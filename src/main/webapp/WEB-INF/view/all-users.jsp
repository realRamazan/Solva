<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<h2>All users</h2>
<br>
<table>

<tr>
    <th>Name</th>
    <th>Surname</th>
</tr>
    <c:forEach var="user" items="${allUsers}">
        <c:url var="infoUser" value="/userInfo">
            <c:param name="userId" value="${user.id}"/>
        </c:url>
        <tr>
            <td>${user.user_name}</td>
            <td>${user.user_surname}</td>
            <td><input type="button" value="Info" onclick="window.location.href='${infoUser}'"/></td>
        </tr>
    </c:forEach>

</table>
</body>

</html>