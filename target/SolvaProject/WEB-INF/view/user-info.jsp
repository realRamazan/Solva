<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>


    <body>
        <h2>
            <c:out value="${currentUser.user_name}"/>
            <c:out value="${currentUser.user_surname}"/>
            <br>
        </h2>
        <br>
        Cash <c:out value="${currentUser.cash}"/>
        <br>
        Transaction limit <c:out value="${currentUser.transaction_limit}"/>
        <br>



        <form:form action="setTransaction" modelAttribute="currentUser">
            <form:hidden path="id"/>
            Enter the new transaction limit <form:input path="transaction_limit"/>
            <input type="submit" value="Ok">
        </form:form>

        <br><br>
        <form:form action="setPayment" modelAttribute="transactions">
            <form:hidden path="user_id"/>
            Payment<form:input path="payment"/>
            <input type="submit" value="Ok">
        </form:form>

        <p>
            ${message}
        </p>



    </body>



</html>