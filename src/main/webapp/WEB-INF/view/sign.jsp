<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>Welcome!</h2>
        <form action="userInfo" method="get">
            Enter your pin-code <input type="password" name="pwd" id="pwd">
            <input type="submit" value="Ok">
        </form>


    </body>
</html>