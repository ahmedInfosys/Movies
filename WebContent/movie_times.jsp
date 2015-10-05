<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br><br><br>
<section class="sub" style="margin:0 auto;max-width:600px;height:200px;overflow:scroll;background-color:#FFFFFF;"><br>
<form class="col-sm-8 col-sm-offset-2" action="search_movie" method="get">
	 <div class="input-group" >
	      <input type="text" class="form-control" id="city/state" name="city/state" placeholder="Enter City or state or both (ex. Denver, CO).">
	      <span class="input-group-btn">
	        <button class="btn btn-default" type="submit">Go!</button>
	      </span>
	 </div><br>
	
    
</form>
<div class="container-fluid" text-align="center" style="float:left;">
<c:forEach var="movies_date" items="movies_dates" varStatus="status">
    <span   class="slide">
    <label style="padding: 0 0.25cm;" >OCT</label>
    <label style="padding: 0 0.7cm;" >05</label>
     </span>

</c:forEach>
</div>
</section>
</body>
</html>