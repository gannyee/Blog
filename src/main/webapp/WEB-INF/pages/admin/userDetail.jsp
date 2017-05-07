<%--
  Created by IntelliJ IDEA.
  User: gannyee
  Date: 2017/5/7
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../common/head.jsp" %>
<body>
<h1>用户详情</h1>
<hr/>

<table class="table table-bordered table-striped">
    <tr>
        <th>ID</th>
        <td>${user.id}</td>
    </tr>

    <tr>
        <th>username</th>
        <td>${user.username}</td>
    </tr>

    <tr>
        <th>FirstName</th>
        <td>${user.firstName}</td>
    </tr>

    <tr>
        <th>LastName</th>
        <td>${user.lastName}</td>
    </tr>

    <tr>
        <th>passsword</th>
        <td>${user.password}</td>
    </tr>
</table>
</body>
</html>
