<%--
  Created by IntelliJ IDEA.
  User: 23511
  Date: 2019/8/7
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<center>
    <h1>用户页面</h1>
    <br>
    <a href="${pageContext.request.contextPath}/view/addUser.jsp">增加</a>
</center>
<center>
    <hr>
    <table border="1" width="80%">
        <tr>
            <td>用户ID</td>
            <td>用户名称</td>
            <td>年龄</td>
            <td>性别</td>
            <td>爱好</td>
            <td>登录名</td>
            <td>密码</td>
            <td>创建时间</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${userList }" var="user">
            <tr>
                <td>${user.user_id }</td>
                <td>${user.name }</td>
                <td>${user.age }</td>
                <td>${user.sex }</td>
                <td>${user.hobby }</td>
                <td>${user.login_name }</td>
                <td>${user.password }</td>
                <td>${user.create_time }</td>
                <td><a href="${pageContext.request.contextPath}/delete?user_id=${user.user_id}">删除</a></td>
                <td><a href="${pageContext.request.contextPath}/view/alterUser.jsp?user_id=${user.user_id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</center>

</body>
</html>
