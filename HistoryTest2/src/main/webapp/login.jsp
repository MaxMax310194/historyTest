<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="startLogin" method="post" modelAttribute="loginUser">
<f:input path="name" placeholder="name"/><f:errors path="name"/>
<br/><f:password path="password" placeholder="password" /><f:errors path="password" />
<br/><input type="submit" value="Login"  id="" name="">
<br/><a href="goToReg">Registration</a>

</f:form>
</body>
</html>