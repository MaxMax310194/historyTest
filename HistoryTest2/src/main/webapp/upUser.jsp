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
<f:form action="updateUser" method="post" modelAttribute="regUser">
<f:input path="name" placeholder="name"/>
<br/><f:password path="password"  placeholder="password"/>
<br/><f:input path="email" placeholder="email"/>
<br/><f:input path="country"  placeholder="country" />
<br/><f:input path="age" placeholder="age"/>

<br/><input type="submit" value="Update"   id="" name=""/><input type="submit" value="Cansel" onclick="this.form.action = 'regCansl'" id="" name="" />

</f:form>
</body>
</html>