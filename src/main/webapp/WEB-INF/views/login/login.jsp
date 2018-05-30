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
	 $("#login").on("click",function(e){
	      e.preventDefault();
	      $("form").submit();
	      
   });
</script>
</head>
<body>
	<hr />
	<h2>로그인</h2>
	<hr />
	
	<%--LoginController에서 binding -> modelAttribute--%>
	<form:form modelAttribute="user" action="/login/memLoginOK" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
				<form:input path="id"/>
				<form:errors path="id"/>
				</td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td>
				<form:password path="passwd" />
				<form:errors path="passwd"/>
				</td>
			</tr>
			<tr>
				<td>
					<button id="login">로그인</button>
				</td>
				<td>
					<button id="join" data-url="/member/memberJoin">회원가입</button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>