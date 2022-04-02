<%@include file="header.jsp" %>
<section>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<form:form action="adminlogic.html" method="post">
   Username:- <form:input path="uname"/> <br><br>
   Password:- <form:password path="upass"/><br><br>
    <input type="submit" name="Login here" />
</form:form>
<%
if(request.getAttribute("error")!=null)
{
	out.print(request.getAttribute("error"));
}

%>
</section>
<%@include file="footer.jsp" %>