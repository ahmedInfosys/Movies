<%@ page import="javax.persistence.TypedQuery" %>
<%@ page import="model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>
<br><br><br><br><br>
<div class="container">
    <%String qString = "SELECT m FROM MMovy m";
      TypedQuery<MMovy> q = DBUtil.createQuery(qString,MMovy.class);%>
     
      <c:set var="movies" value="<%=q.getResultList()%>" scope="session"/>
      <div class = "galleryimage ">
      <c:forEach var="movie" items="${movies}" varStatus="status">
	      <c:if test="${status.count % 6 == 0 }">
		      </div>
		      <div class = "galleryimage " onmouseover="mOver(this)" onmouseout="mOut(this)" >  
	      </c:if>
     	     <a href="/Movies/movie_details?movie_id=${movie.getId()}"><img src="${movie.getCoverPicture()}" alt="${movie.getTitle()}" width="160" height="300" style="display:inline;margin-left:20px;margin-top:10px;" ></a>
      </c:forEach>
      </div> 
    </div>

