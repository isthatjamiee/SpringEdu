<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>Find Member Id</title>
</head>
<jsp:include page="/navbar.jsp" flush="true" />
</head>

<body draggable="true">
	<form:form modelAttribute="login" action="/login/memLoginOK"
		method="post">
		<div class="py-1 text-white opaque-overlay h-100 w-100 mx-auto p-5"
			style="background-image: url(&amp;quot;https://pingendo.github.io/templates/sections/assets/cover_restaurant.jpg&amp;quot;); background-size: cover; background-position: center; background-repeat: no-repeat;">
			<div class="container py-5">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<h1 class="text-gray-dark">Find ID</h1>

						<div class="form-group">
							<label>Name</label>
							<form:input type="text" path="name" name="name"
								class="form-control" placeholder="Enter your name" />
							<form:errors path="name" />
						</div>
						<div class="form-group">
							<label>Phone</label>
							<form:input type="text" path="phone" class="form-control"
								placeholder="Enter your phone number" />
							<form:errors path="phone" />
						</div>
						<div class="button-group" align="right"
							style="margin-right: 30px;">
							<button id="loginbtn" type="submit" class="btn btn-primary" data-url="/member/memberJoin">Find Id</button>
						</div>
						<br>
						<!-- <div style="text-align: center;">
							<a href="/member/findId" class="forget" data-toggle="modal"
								data-target=".forget-modal">Forgot your id</a> / <a
								href="/member/findPasswd" class="forget" data-toggle="modal"
								data-target=".forget-modal">password?</a>
						</div> -->
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>
<jsp:include page="/footer.jsp" flush="true" /></body>
</html>