<%--
  Created by IntelliJ IDEA.
  User: xiehaiyan
  Date: 6/18/15
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container">
  <h1>login</h1>

  <form:form method="post" commandName="user" role="form">
    <div class="form-group">
      <label for="name">Name:</label>
      <form:input path="name" class="form-control"/>
    </div>
    <div class="form-group">
      <label for="Password">Password:</label>
      <form:input path="Password" class="form-control"/>
    </div>
    <div class="form-group">
      <input class="btn btn-primary" type="submit" value="login" />
      <a href="${pageContext.request.contextPath}/user/">返回</a>
    </div>
  </form:form>
</div>
</body>
</html>
