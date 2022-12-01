<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="nextTetest" method="post">


<c:out value="${question}"></c:out>


<br/><input type="radio"  name="answer" checked="checked" /><c:out value="${answer1}"/>
<br/><input type="radio" name="answer"  /><c:out value="${answer2}"/>
<br/><input type="radio" name="answer"  /><c:out value="${answer3}"/>
<br/><input type="radio" name="answer"  /><c:out value="${answer4}"/>
<br/><input type="radio" name="answer"  /><c:out value="${answer5}"/>

<br/><input type="submit" value="Back"/><input type="submit" value="Next" id="" name=""/>

</form>
</body>
</html>