<%@ page import="javax.persistence.TypedQuery" %>
<%@ page import="model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" >
   

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
    
    <%String qString = "SELECT m FROM MMovy m";
      TypedQuery<MMovy> q = DBUtil.createQuery(qString,MMovy.class);%>
     
      <c:set var="movies" value="<%=q.getResultList()%>" scope="session"/>
      <div class = "item active">
      <div class = "galleryimage ">
      <c:forEach var="movie" items="${movies}" varStatus="status">
	      <c:if test="${status.count % 6 == 0 }">
		      </div>
		      </div>
		      <div class = "item ">
		      <div class = "galleryimage ">  
	      </c:if>
	      <c:if test="${status.count % 5 == 1 }">
		    <a href="/Movies/movie_details?movie_id=${movie.getId()}"><img src="${movie.getCoverPicture()}" alt="${movie.getTitle()}" width="160" height="300" style="display:inline;margin-left:125px"></a>
     	  </c:if>
     	  <c:if test="${status.count % 5 != 1 }">
     	     <a href="/Movies/movie_details?movie_id=${movie.getId()}"><img src="${movie.getCoverPicture()}" alt="${movie.getTitle()}" width="160" height="300" style="display:inline;margin-left:20px"></a>
      	  </c:if>
      </c:forEach>
      </div>
	  </div>

    
     
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>