<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
<link rel="stylesheet"
	href="/webjars/font-awesome/5.0.13/web-fonts-with-css/css/fontawesome-all.css">
<script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
<script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
<script>
$(function(){
	//회원가입 페이지로 이동
	$('#join').on("click",function(e){
		e.preventDefault();
		$(location).attr("href", $(this).attr("data-url"));
	});

	//로그인
	 $("#loginbtn").on("click",function(e){
	      e.preventDefault();
	      $("form").submit();
	      
   });
});
</script>
</head>
<body>
	<%--LoginController에서 binding -> modelAttribute--%>
	<form:form modelAttribute="login" action="/login/memLoginOK" method="post">
	
		<div class="py-5">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="card text-white p-5 bg-primary">
							<div class="card-body">
								<h1 class="mb-4">Login</h1>
								<form action="https://formspree.io/YOUREMAILHERE">
									<div class="form-group">
										<label>Email address</label> 
										<form:input path="id" placeholder="Enter email"/> 
										<form:errors path="id" />
									</div>
									<div class="form-group">
										<label>Password</label> 
										<form:password path="passwd" placeholder="Password"/> 
										<form:errors path="passwd" />
									</div>
									<div align="right">
									<button id="loginbtn" type="submit" class="btn btn-secondary">Login</button>
									<button id="join" class="btn btn-secondary" data-url="/member/memberJoin">Join</button>
								    </div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

 </form:form>
</body>
</html>