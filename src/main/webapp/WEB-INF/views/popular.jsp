<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
 <form name="Enter user name" action="saveP" method="POST" >
    <ul>
        <li><label>User:</label> <input type='text' name='username' /></li>
        <li><label>Number of tweets:</label> <input type='text' name='count' /></li>
        <li><label>&nbsp;</label> <input type="submit" value="OK" class="btn"></li>
    </ul>
</form>


 <h1>Popular tweets!</h1>  
 <table border="2" width="70%" cellpadding="2">  
<tr><th>Popular tweets</th></tr>  
   <c:forEach var="tweet" items="${tweets}">   
   <tr>  
   <td>${tweet.text}</td>   
   </tr>  
   </c:forEach>  
   </table>  
   
   <a href="/twit">back</a>  
</body>
</html>
