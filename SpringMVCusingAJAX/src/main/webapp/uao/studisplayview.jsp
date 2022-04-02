<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>  
<%@ page import="model.Student" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><td>Rno</td><td>Sname</td></tr>
<%
List ls =(List)request.getAttribute("lst");
Iterator it = ls.iterator();
while(it.hasNext())
{
	Student s =(Student)it.next();
%>
	
<tr><td><%= s.getRno() %> </td><td><%= s.getName() %> </td><td><a href="EditRec.html?q=<%= s.getRno() %>">Edit</a></td><td><a href="DeleteRec.html?q=<%= s.getRno() %>">Delete</a></td> </tr>
	
<% } %>




</table>
</body>
</html>