<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
tr, th, td{
	border: 1px black solid;
}
</style>
</head>
<body>
<f:form action="addUserWithAdmin" method="post">
 Hello,<c:out value="${userSession.name}"></c:out>
 <input type="search" onclick="this.form.action = ''" />
 <table>
 
<thead>
<tr>
<th>
id
</th>

<th>
name
</th>

<th>
password
</th>

<th>
email
</th>

<th>
delete
</th>


</tr>
</thead>

<tbody>



</tbody>
<c:forEach  var="u" items="${users}" >
<tr>

<td>
<c:out value="${u.idUser}" />
</td>

<td>
<c:out value="${u.name}"/>
</td>

<td>
<c:out value="${u.password}"/>
</td>

<td>
<c:out value="${u.email}"/>
</td>

<td>
<input type="submit" onclick="this.form.action ='delUser'"  value="Delete" id="" name="d${u.idUser}"/>
</td>

</tr>
</c:forEach>
 </table>


</f:form>
</body>
</html>