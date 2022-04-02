<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>
$(document).ready(function(){

	

	$("#btnclick").click(function(){

		

			$.ajax({

	            type: "get",

	            url: "http://localhost:8080/jobportal/ajaxlogic.html", //this is my servlet

	            data: "rno="+$("#txtrno").val()+"&name="+$("#txtname").val(),

	            success: function(msg){      

	                    $('#res').html(msg);

	            }

	        });

	});

	

	

});
</script>
</head>
<body>
<input type="text" id="txtrno" placeholder="Enter rno" />
<br><br>
<input type="text" id="txtname" placeholder="Enter name" />
<br><br>
<input type="button" id="btnclick" value="click" /> 
<br><br>
<div id="res"></div>
</body>
</html>