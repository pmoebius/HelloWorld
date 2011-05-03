<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>"Twitter"</title>
</head>
<script src="http://code.jquery.com/jquery-1.6.js"></script>
 <script type="text/javascript">
  	function getXMLObject() {
  	  	var xmlHttp = false;
  	  	try {
  	  	  	if(window.XMLHttpRequest()){
  	  	  	  	ajax=new XMLHttpRequest();
  	  	  	} else if(window.ActiveXObject){
  	  	  	  	ajax=new ActiveXObject("Microsoft.XMLHTTP");
  	  	  	} else {
  	  	  	  	alert("Ihr Webbrowser unterstützt leider kein Ajax!");
    	  	}
  	  	} catch (e) {
  	  	  	alert("Fehler: " + e);
  	  	}
  	  	return xmlHttp;
 	}

 	var xmlHttp = new getXMLObject();
 	
 	function ajaxFunction(){
 	 	if(xmlHttp){
 	 	 	var text = document.getElementById("user_eingabe");
 	 		xmlHttp.open("POST", "Controller", true);
 	  	  	xmlHttp.onreadystatechange = meineCallbackFkt;
 	  	  	xmlHttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
 	  	  	xmlHttp.send("text="+text.value);
 	 	}
 	 }
 	function meineCallbackFkt(){
 	 	if(4==xmlHttp.readyState){
 	 	 	if(200 != xmlHttp.status){
 	 	 	 	alert("Fehler "+ xmlHttp.status + ": " + xmlHttp.statusText);
 	 	 	} else {
 	 	 	 	document.showall.message.innerHTML=xmlHttp.responseText;
 	 	 	}
 	 	} 	
 	}
 </script>
<body>
<form method="POST" action="Controller" name="showall">
 <textarea name="user_eingabe" id="user_eingabe" cols="50" rows="10"></textarea>
 <input type="submit" name="Absenden" value="Absenden" >
</form>
<div id="list">
<%
	//tryncatch..
	Vector<String> vector = (Vector<String>)request.getAttribute("msg");
	out.println("<ul>");
	int i=vector.size()-1;
	for(Iterator<String> iter = vector.iterator(); iter.hasNext(); iter.next()) {
		out.println("<li>" + vector.get(i) + "</li>");
		i--;
	}
	out.println("</ul>");
	
	String temp = (String)request.getAttribute("myString");
	out.println("This is my String: " + temp);
%>
</div>
<form name="Liste">
	<ul>
	<li><%=temp %></li>
	</ul>
</form>
</body>
</html>