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
<f:form action="updateTest" method="post" modelAttribute="regTest">
<f:input path="question" placeholder="question"/><f:errors path="question" />
<br/><f:input path="answer1" placeholder="answer1"/><f:errors path="answer1" />
<br/><f:input path="answer2" placeholder="answer2"/><f:errors path="answer2" />
<br/><f:input path="answer3" placeholder="answer3"/><f:errors path="answer3" />
<br/><f:input path="answer4" placeholder="answer4"/><f:errors path="answer4" />
<br/><f:input path="answer5" placeholder="answer5"/><f:errors path="answer5" />
<br/><f:input path="correctAnswer" placeholder="correctAnswer"/><f:errors path="correctAnswer" />
<br/><input type="submit" value="Update"  /> <input type="submit" value="Cansl" onclick="this.form.action = 'canslUpTest'" />
</f:form>
</body>
</html>