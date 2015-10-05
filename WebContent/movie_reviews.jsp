<jsp:include page="/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="sub" style="margin-left:20px;max-width:300px;height:500px;float:left;white-space:pre-line;">
	    <label style="font-style:italic;font-size:35px;font-family:AR BLANCA;white-space:pre-line;">${movie.getTitle()} </label>
	    <img src="${movie.getCoverPicture()}"  width="160" height="300" >
		<label style="font-style:italic;font-size:15px;margin-left:20%;">Released </label>
		<label align="center" style="font-size:15px;margin-left:20%;"><b>${number_of_reviews}</b> fans rating</label>
		<label align="center" style="font-size:15px;margin-left:20%;">Average rating : <b>${avg_rating}</b></label>
	</section>
	
	<div style="float:left;">
	<ul class="nav nav-pills" >
   		 <li role="presentation"  style="margin-left:150px;"><a href="overview.jsp">Overview</a></li>
   		 <li role="presentation" style="margin-left:20px;"><a href="synopsis.jsp">Synopsis</a></li>
   		 <li role="presentation"  class="active" style="margin-left:20px;"><a href="movie_reviews.jsp">Movie Reviews</a></li>
   		 <li role="presentation" style="margin-left:20px;"><a href="trailers.jsp">Trailers</a></li>
    </ul>
    <c:if test="${not empty user}">
    <form action="movie_details" method="get">
	    <section class="sub" style="margin: 0 auto;width:700px;height:250px;background-color:#FFFFFF;">
	    <input type="hidden" name="movie_id" value="${movie.getId()}"/>
	    <label style="display:inline;margin-left:20px;">Rating scale:
	    <select class="form-control" id="scale" name="scale" style="width:10%;display:inline;">
	    	<option>1</option>
	    	<option>2</option>
	    	<option>3</option>
	    	<option>4</option>
	    	<option>5</option>
	    </select>
	    </label>
	    <textarea class="form-control" id="comment" name="comment" rows="6" cols="80" style="resize:none;" placeholder="Write your review....."></textarea>
	     <br><button class="form-control" type="submit" style="width:20%;float:right;">Submit</button> 
	    </section>
    </form>
    </c:if>
    <c:forEach var="review" items="${reviews}" varStatus="status">
	    <section class="sub" style="margin: 0 auto;width:700px;height:200px;background-color:#FFFFFF;">
	    <h4>Rating scale: ${review.getRatingscale()} out of 5</h4>
	    <h4 style="text-transform:uppercase;">by <b>${review.getMAdmin().getFirstname()} ${review.getMAdmin().getLastname()}</b> on ${review_dates.get(status.index)}</h4>
	    <p style="font-style:italic;"> ${review.getReview()}</p>
	    </section>
	</c:forEach>
    </div>
</body>
</html>