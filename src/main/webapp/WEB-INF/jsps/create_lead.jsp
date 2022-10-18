<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file = "menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create</title>
</head>
<body>   
        <h1>Leads | Contacts</h1>
       
        
        <form action = "saveLead" method ="post">
        <pre>
           First Name <input type ="text" name = "firstName"/>
           Last  Name <input type ="text" name = "lastName"/>
           Email      <input type ="email" name = "email"/>
           Mobile No  <input type ="number" name = "mobile"/>
           Source
          <select name="source" id="cars">
				  <option value="news paper">News Paper</option>
				  <option value="tv commercial">TV Commercial</option>
				  <option value="online">Online</option>
				  <option value="seminar">Seminar</option>
				  <option value="youtube">YouTube</option>
	      </select>
	       <input type ="submit" value ="save"/>
	       </pre>
        </form>>
       
        
       

</body>
</html>