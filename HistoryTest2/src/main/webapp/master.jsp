<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
,tr, th, td{
	border: 1px black solid;
}
</style>
</head>
<body>
<c:out value="${userSession.name}"></c:out>
<f:form action="goToAddTest" method="post" > 
<table>
<thead>
<tr>

<th>
id
</th>

<th>
question
</th>

<th>
answer1
</th>

<th>
answer2
</th>

<th>
answer3
</th>

<th>
answer4
</th>

<th>
answer5
</th>

<th>
Delete
</th>

<th>
Update
</th>

</tr>
</thead>

<tbody>
<c:forEach var="t" items="${tests}">
<tr>

<td>
<c:out value="${t.idTest}" />
</td>

<td>
<c:out value="${t.question}"></c:out>
</td>

<td>
<c:out value="${t.answer1}"></c:out>
</td>

<td>
<c:out value="${t.answer2}"></c:out>
</td>

<td>
<c:out value="${t.answer3}"></c:out>
</td>

<td>
<c:out value="${t.answer4}"></c:out>
</td>

<td>
<c:out value="${t.answer5}"></c:out>
</td>

<td>
<input type="submit" value="Delete"  onclick="this.form.action = 'delTest'" id="" name="t${t.idTest}" />
</td>

<td>
<input type="submit"  value="Update" onclick="this.form.action = 'goToUpTest'" id="" name="u${t.idTest}" />
</td>

</tr>
</c:forEach>
</tbody>

</table>
<br/><input type="submit" value="Add" id="" name="" /> 
</f:form>
</body>
</html>