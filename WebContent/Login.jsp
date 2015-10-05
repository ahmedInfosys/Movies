<br><br><br><br><br>
<jsp:include page="header.jsp"></jsp:include>

<div class ="col-sm-6 col-sm-offset-3">

       <div class= "panel-heading" style="background-color:#3366FF;">
            <p>Sign in</p>
			<p> <p>
		</div>	
		<div class ="panel-body" style="background-color:#E0E0D1;">
	
			<form class= "form-inline" action="SignIn"  method="get">
				<label >Email:</label>
				<input type="text" class="form-control" placeholder= "ex. join@domain.com" name="email" style="width:70%; margin-left:30px;"required> </input><br>
				<br>
				<label>Password:</label>
				<input type="password" class="form-control" placeholder="password" name="password" style="width:70%" required> </input><br>
		
				
				
				    <button type="submit"  value = "submit" class= "button btn-primary form-control">Sign In</button>${invalid}
			
			</form>
	  </div>
	 
</div>
</body>
</html></html>