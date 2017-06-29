<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
       
            <a class="navbar-brand" href="/twit">Twit</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="/twit">Home</a></li>
              <li><a href="about">About</a></li>
              <li><a href="contact">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="login">Log in</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>


      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>Twitter account authorization required!</h1>
        <p>
          <a class="btn btn-lg btn-primary" target="_blank" href="${authlink}" role="button">Get your pin &raquo;</a>
        </p>
        
      <form name="Enter your pin" action="submitPin" method="POST" >
	      <ul>
	          <li><label>Pin:</label> <input type='text' name='pin' /></li>
	          <li><label>&nbsp;</label> <input type="submit" value="OK" class="btn"></li>
	      </ul>
 	  </form>
      </div>
      


<script src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>   
</body>
</html>

