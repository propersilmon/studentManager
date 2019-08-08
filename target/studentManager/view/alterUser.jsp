<%--
  Created by IntelliJ IDEA.
  User: 23511
  Date: 2019/8/7
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<% String user_id = request.getParameter("user_id"); %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
<center>
    <h5>修改页面</h5>
    <hr>
    <form action="${pageContext.request.contextPath}/alter?user_id=${param.user_id}" method="post">
        <table>
            <tbody>
            <tr>
                <td>用户名称: </td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>年龄: </td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td>性别: </td>
                <td><input type="text" name="sex"></td>
            </tr>
            <tr>
                <td>爱好: </td>
                <td><input type="text" name="hobby"></td>
            </tr>
            <tr>
                <td>登录名: </td>
                <td><input type="text" name="login_name"></td>
            </tr>
            <tr>
                <td>密码: </td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="修改"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
            </tbody>
        </table>
    </form>
</center>
</body>
</html>
