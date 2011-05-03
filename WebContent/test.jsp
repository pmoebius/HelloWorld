<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.6.js"></script>
<script>
$(document).ready(function() {
	 var auto_refresh = setInterval(
			 function(){
				 $('#list').load('Controller');
			 }, 1000);

	 	$("#myButton").click(function(){
	 		$.post("Controller", {text:$("#user_eingabe").val()});
		 	alert($('#user_eingabe').val());
		 	$('#user_eingabe').val('');
		 	
		});
});
</script>
</head>
<body>
<div id="eingabe">
 <textarea name="user_eingabe" id="user_eingabe" cols="50" rows="10"></textarea>
 <button id="myButton">Absenden</button>
</div>
<div id="list"></div>
</body>
</html>