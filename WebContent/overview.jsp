<jsp:include page="header.jsp"></jsp:include>

	<section class="sub" style="margin-left:20px;max-width:300px;height:500px;float:left;white-space:pre-line;">
	    <label style="font-style:italic;font-size:35px;font-family:AR BLANCA;white-space:pre-line;">${movie.getTitle()} </label>
	    <img src="${movie.getCoverPicture()}"  width="160" height="300" >
		<label style="font-style:italic;font-size:15px;margin-left:20%;">Released </label>
		<label style="font-size:15px;margin-left:20%;"><b>${number_of_reviews}</b> fans rating</label>
		<label align="center" style="font-size:15px;margin-left:20%;">Average rating : <b>${avg_rating}</b></label>
	</section>
	
	<div style="float:left;" >
	<ul class="nav nav-pills" >
   		 <li role="presentation" class="active" style="margin-left:150px;"><a href="overview.jsp">Overview</a></li>
   		 <li role="presentation" style="margin-left:20px;"><a href="synopsis.jsp">Synopsis</a></li>
   		 <li role="presentation" style="margin-left:20px;"><a href="movie_reviews.jsp">Movie Reviews</a></li>
   		 <li role="presentation" style="margin-left:20px;"><a href="trailers.jsp">Trailers</a></li>
    </ul>
	<iframe width="800" height="500" src="${movie.getTrailers()}" style="margin-left:40px;"></iframe>
</div>
</body>
</html>