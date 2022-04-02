<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<form:form action="studelete.html" method="post">
   RNO:- <form:input path="rno"/> <br><br>
   Name:- <form:input path="sname"/><br><br>
    <input type="submit" name="Edit Record" />
</form:form>
${key}
</body>
</html>