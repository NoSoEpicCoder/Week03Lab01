<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/header.html"/>
    <body>
        <h1>Login</h1>
        <div>
        <form action="Login" method="post">
            Username: <input type="text" name="username"><br>
            Password: <input type="text" name="password"><br>
            <input type="submit" value="Login"><br>
        </form>
        ${displayMessage}
        </div>
    </body>
<c:import url="/WEB-INF/footer.html"/>