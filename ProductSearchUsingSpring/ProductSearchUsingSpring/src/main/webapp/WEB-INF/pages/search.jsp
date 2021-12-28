<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Search</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<style>
.err
{
	color:red;
}
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login");
		}
	%>
	<div class="container text-center mt-5" style="border:1px solid black;width:50%;background-color:#d3f5f3">
		<h5>PRODUCTS SEARCH</h5>
			<form action="result" method="post" class="mt-2">
				<div class="row mb-3">
					<label for="color" class="col-sm-5 col-form-label">Enter Color</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="color" name="color"  onfocusout="validateCol()" required>
						
					</div>
				</div>
				<div class="row mb-3">
					<label for="size" class="col-sm-5 col-form-label">Enter Size</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="size" name="size"  onfocusout="validateSize()" required>
						
					</div>
				</div>
				<div class="row mb-3">
					<label for="gender_rec" class="col-sm-5 col-form-label">Enter gender</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="gender_rec" name="gender_rec" onfocusout="validategen()" required>
						
					</div>
				</div>
				
				
				<fieldset class="row mb-3">
					<legend class="col-form-label col-sm-3 pt-0" style="margin-left:50px;">Output Preference</legend>
					<div class="col-sm-3" style="margin-left:45px;">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="sort"
								id="gridRadios1" value="price" required> <label
								class="form-check-label" style="margin-left:-10px;" for="gridRadios1" > Sort By Price
							</label>
						</div>
					</div>
					<div class="col-sm-3" style="margin-left:235px;">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="sort"
								id="gridRadios2" value="rating"> <label
								class="form-check-label" style="margin-left:-10px;" for="gridRadios2" > Sort By rating
							</label>
						</div>
					</div>
				</fieldset>
				<button type="submit" class="btn btn-primary text-center mb-1">Search</button>
			</form>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
	integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
	crossorigin="anonymous"></script>
<script>
function validateCol()
{
	var color=document.getElementById("color");
	var re = /^[A-Za-z]+$/;
    if(!re.test(color.value))
		document.getElementById("col_err").innerHTML="Product color should only contain alphabets";
	else
		document.getElementById("col_err").style.display="none";
}
function validateSize()
{
	var size=document.getElementById("size");
	var re = /^[A-Za-z]+$/;
	if(!re.test(size.value))
		document.getElementById("size_err").innerHTML="Size should only contain alphabets";
	else
		document.getElementById("size_err").style.display="none";
}

function validategen(){
	var size=document.getElementById("gender_rec");
	var re = /^[A-Za-z]+$/;
	if(!re.test(size.value))
		document.getElementById("gender_err").innerHTML="gender should only contain alphabets";
	else
		document.getElementById("gender_err").style.display="none";
}

</script>
</html>