<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Twit</title>
	<link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/twit/home">Twit</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><a href="/twit/home">Home</a></li>
              <li><a href="about">About</a></li>
              <li><a href="contact">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="login">Log in</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>
      
     

 <form:form name="Enter user name" action="saveP" method="POST" modelAttribute="popular">
    <ul>
        <li><label>User:</label> <form:input path='username' /></li>
        <li><label>Number of tweets:</label> <form:input path='count' /></li>
        <li><label>&nbsp;</label> <input type="submit" value="APPLY" class="btn btn-lg btn-primary"></li>
    </ul>
</form:form>


 <h1>Popular tweets!</h1>  
 <table class="table">
  <thead>
    <tr>
      <th>Content</th>
      <th>User</th>
      <th>Date</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="tweet" items="${tweets}">   
   <tr>  
   <td>${tweet.text}</td>  
   <td>${tweet.author}</td>  
   <td>${tweet.date}</td>  
   </tr>  
   </c:forEach> 
  </tbody>
</table>
   
    <p>
         <a class="btn btn-lg btn-primary" href="javascript: history.go(-1)" role="button">Back &raquo;</a>
    </p>  
   <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script> 
</body>
</html>
