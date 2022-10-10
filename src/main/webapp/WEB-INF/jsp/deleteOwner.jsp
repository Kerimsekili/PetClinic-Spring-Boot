<%--
  Created by IntelliJ IDEA.
  User: kerim
  Date: 10.10.2022
  Time: 14:51
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
  First Name : <form:input path="firstName"/><br/>
  First Name : <form:input path="lastName"/><br/>
  <form:button name="submit">Delete</form:button>
</form:form>
</body>
</html></html>
