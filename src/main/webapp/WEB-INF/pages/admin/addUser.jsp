<%--
  Created by IntelliJ IDEA.
  User: gannyee
  Date: 2017/5/7
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="zh-CN">
<%@include file="../common/head.jsp" %>
<body>
<div class="container">
    <h1>SpringMVC 添加用户</h1>
    <hr/>
    <form:form action="/admin/users/addP" method="post" commandName="user" role="form">
        <div class="form-group">
            <label for="username">userName:</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter userName:"/>
        </div>
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter FirstName:"/>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter LastName:"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password:"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>

        <div class="form-group">
            <button type="reset" class="btn btn-sm btn-success">重置</button>
        </div>
    </form:form>
</div>

</body>
</html>
