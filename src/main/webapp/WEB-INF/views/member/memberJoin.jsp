<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/header.jsp" flush="true" />

<title>회원가입</title>
<script>
	$(function() {

		$("input[name=password]").keyup(function(e) {
			e.preventDefault();
			if ($("input[name=password]").val() != $("input[name=passwd]").val()) {
				$(".passErr").text('비밀번호값이 틀립니다');
				$(this).focus();
			} else {
				$(".passErr").text('');
			}
		});

		$("#joinBtn").on("click", function(e) {
			e.preventDefault();
			$("form").submit();

		});

		$("#joinClearBtn").on("click", function(e) {
			e.preventDefault();
			$("form").each(function() {
				this.reset();
			});
		});

		$("#joinCancelBtn").on("click", function(e) {
			e.preventDefault();
			location.href = "/";
		});
	});
</script>
<style>
.errmsg {
	color: red;
}

.passErr {
	color: red;
}
</style>
<title>Insert title here</title>
<jsp:include page="/navbar.jsp" flush="true" />
</head>
<body>
	<div class="container">
		<form:form modelAttribute="memberVO" action="/member/memberJoinOK"
			method="post">
			<div class="py-1 text-white opaque-overlay h-100 w-100 mx-auto p-5" 
				style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_restaurant.jpg&quot;);
    			background-size:cover; background-position:center; background-repeat:no-repeat;">
				<h2>Sign Up</h2>
				<form>
					<label>Username</label><br>
						<input type="email" name="username" class="span3" placeholder="Enter email" /><br>
					<label>Password</label><br>
						<input type="password" name="password" class="span3" placeholder="Password"/><br>
					<label>Check Password</label> <br>
						<input type="password" name="password" class="span3" /> <br>
					<label>Name</label><br>
						<input type="text" class="span3" /><br>
					<label>Date of Birth</label><br>
						<input type="text" class="span3" /><br>
					<label>Phone</label><br>
						<input type="text" class="span3" /><br>
					<label>Gender</label>
					M
					<form:radiobutton path="gender" value="M" />
					F
					<form:radiobutton path="gender" value="F" /><br>
					<label><input type="checkbox" name="terms"> 
					I agree with the <a href="#">Terms and Conditions</a>.</label><br>
					<input id="joinBtn" type="submit" value="Sign up" class="btn btn-primary"/>
					<input id="joinClearBtn" type="submit" value="Reset" class="btn btn-primary"/>
					<input id="joinCancelBtn" type="submit" value="Cancel" class="btn btn-primary"/>
					<div class="clearfix"></div>
				</form>
			</div>


			<%-- <div class="table-responsive-sm">
				<table class="table-sm table-bordered">
					<tr>
						<th>아이디</th>
						<td><form:input path="id" /> <form:errors path="id"
								cssClass="errmsg" /> <!-- memberVO에서 지정해준 유효성 검사 에러 이렇게 뜸 --></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><form:password path="passwd" /> <form:errors
								path="passwd" cssClass="errmsg" /></td>
					</tr>
					<tr>
						<th>비밀번호확인</th>
						<td><input type="password" name="password" /> <span
							class="passErr"></span></td>

					</tr>
					<tr>
						<th>이름</th>
						<td><form:input path="name" /> <form:errors path="name"
								cssClass="errmsg" /></td>
					</tr>
					<tr>
						<th>생일</th>
						<td><form:input path="birth" /> <form:errors path="birth"
								cssClass="errmsg" /></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><form:input path="phone" /> <form:errors path="phone"
								cssClass="errmsg" /></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>남<form:radiobutton path="gender" value="M" /> 여<form:radiobutton
								path="gender" value="F" /> <form:errors path="gender"
								cssClass="errmsg" />
						</td>
					</tr>
					<tr align=right>
						<td colspan=2>
							<button id="joinBtn">가입</button>
							<button id="joinClearBtn">초기화</button>
							<button id="joinCancelBtn">가입취소</button>
					</tr>
				</table>
			</div> --%>
		</form:form>
	</div>
</body>
<jsp:include page="/footer.jsp" flush="true" />
</html>