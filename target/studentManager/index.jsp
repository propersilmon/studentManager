<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<center>
    <h1>登录页面</h1>
</center>
<center>
    ${message }
    <form action="${pageContext.request.contextPath}/login" method="post">
        <span>username: </span>
        <input type="text" name="username">
        <br>
        <br>
        <span>password: </span>
        <input type="password" name="password">
        <br>
        <br>
        <input type="reset">
        <input type="submit">
    </form>
</center>
</body>
</html>
