<!DOCTYPE html>
<html lang="en">
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="model.*"%>
<%@ page import="javax.persistence.TypedQuery;" %>

<% MAdmin admin = (MAdmin) session.getAttribute("user"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<title>AMC Theater</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style type="text/css">
/* background */
.navbar-inverse {
	background-color: #800000;
	
}
/* title */
.navbar-inverse .navbar-brand {
    color: #96D38D;
}
/* text */
.navbar-inverse .navbar-collapse .navbar-nav > li > a {
	color: #96D38D;
}

section.sub{
 border:1px solid grey;
 word-wrap: break-word;
}

  .affix {
      top: 0;
      width: 100%;
  }

  .affix + .container {
      padding-top: 70px;
  }
.slideContainer {
    white-space: nowrap;
}
.slide {
    font-size:35px;
	font-family:time-new-roman;
	white-space: nowrap;
	border:1px solid grey;
    display: inline-block;
    width: 100px;
    height: 100px;
    white-space: normal;
}
.firstcharacter { float: left; color: #903; font-size: 50px; line-height: 60px;  padding-left: 3px; }
</style>
</head>
<body style="background-color:#9999FF;overflow-x:scroll;overflow-y:scroll;white-space:nowrap;">
	<nav class="navbar navbar-inverse"  data-spy="affix" style="height:80px;">
		<div class="container-fluid" >
			
			 <a class="navbar-brand" href="/Movies/index.jsp"> <img src="http://www.col.ge/img/imovies.ge.jpg" style="width:150px;height:50px;float:left;"></a></li>

			<form class="nav navbar-nav col-sm-3" action="check_ticket" method="get" style="margin-top:25px;">
				 <div class="input-group" >
					      <input type="text" class="form-control" placeholder="Check your ticket status" >
					      <span class="input-group-btn">
					        <button class="btn btn-default" type="submit">Go!</button>
					      </span>
				 </div><!-- /input-group -->
			</form>
			<ul class="nav navbar-nav navbar-right" style="margin-top:15px;">
			   <% if (admin != null) { %>
				<%		if(admin.getType().equalsIgnoreCase("user")){ %>
						
							<li ><a href="all_movies.jsp">Movies</a></li>
							<li><a href="movie_times.jsp" style="margin-right:400px;">Movie times + Tickets</a></li>
						<%}else if(admin.getType().equalsIgnoreCase("admin")) {%>
							<li ><a href="all_movies">Movies</a></li>
							<li><a href="movie_times.jsp">Movie times + Tickets</a></li>
							<li><a href="AMC_DB">AMC database</a></li>
						
						<%} %>

				<% }  %>
				<%if (admin == null ) { %>
					<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span>
							 Login</a></li>
				<% } else {	%>
					<li><a href="SignOut"><span class="glyphicon glyphicon-log-in"></span>
							Logout</a></li>			
				<% } %>
				</ul>

		</div>
</nav>
