<%--
  Created by IntelliJ IDEA.
  User: kerim
  Date: 10.10.2022
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="owner" type="com"--%>
<form:form modelAttribute="owner" method="post">
    First Name : <form:input path="firstName"/>
    <form:errors path="firstName" cssStyle="color:rebeccapurple"/>
    <br/>
    Last Name : <form:input path="lastName"/>
    <form:errors path="lastName" cssStyle="color:rebeccapurple"/>
    <br/>
    <form:button name="submit">Create</form:button>
</form:form>
</body>
</html>
