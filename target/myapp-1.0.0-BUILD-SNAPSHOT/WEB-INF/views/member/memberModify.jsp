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
<script>
$(function(){
   
     $("input[name=password]").keyup(function(e){
    	 e.preventDefault();
	   	 if($("input[name=password]").val() != $("input[name=passwd]").val()){
	   	     $(".passErr").text('비밀번호값이 틀립니다');
	   		 $(this).focus();
	   	 }else{
	   		 $(".passErr").text('');
	   	 }
   	 });
      
   $("#joinBtn").on("click",function(e){
      e.preventDefault();
      $("form").submit();
      
   });
   $("#joinClearBtn").on("click",function(e){
      e.preventDefault();      
        $("form").each(function(){
             this.reset();
           });
   });   
   
   $("#joinCancelBtn").on("click",function(e){
      e.preventDefault();      
         location.href="/";
   });      
});
</script>
<style>
.errmsg{color : red;}
.passErr{color : red;}
</style>
<title>Insert title here</title>
<jsp:include page="/navbar.jsp" flush="true" />
</head>
<body>
	<div class="container">
	<form:form modelAttribute="memberVO" action="/member/memberModufyOK" method="post">
		<div class="span3">
				<h2>Sign Up</h2>
				<form>
					<label>Username</label><br>
					<form:input path="id" class="span3" readOnly="true"/><br>
					<label>Password</label><br>
					<form:password path="passwd" class="span3" /><br>
					<label>Check Password</label> <br>
					<input type="password" name="password" class="span3" /> <br>
					<label>Name</label><br>
					<form:input path="name" class="span3" /><br>
					<label>Date of Birth</label><br>
					<form:input path="birth" class="span3" /><br>
					<label>Phone</label><br>
					<form:input path="phone" class="span3" /><br>
					<label>Gender</label>
					남
					<form:radiobutton path="gender" value="M" />
					여
					<form:radiobutton path="gender" value="F" /><br>
					<input id="joinBtn" type="submit" value="Sign up" class="btn btn-primary pull-right"/>
					<input id="joinClearBtn" type="submit" value="Reset" class="btn btn-primary pull-right"/>
					<input id="joinCancelBtn" type="submit" value="Cancel" class="btn btn-primary pull-right"/>
					<div class="clearfix"></div>
				</form>
			</div>
		<%-- <table>
			<tr>
				<th>아이디</th>
				<td><form:input path="id" readOnly="true" /> 
				<form:errors path="id" cssClass="errmsg" /> <!-- memberVO에서 지정해준 유효성 검사 에러 이렇게 뜸 -->
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
				<form:password path="passwd" /> 
				<form:errors path="passwd" cssClass="errmsg" />
				</td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td>
				<input type="password" name="password" />
				<span class="passErr"></span>
				</td>
				
			</tr>
			<tr>
				<th>이름</th>
				<td><form:input path="name"/> 
				<form:errors path="name" cssClass="errmsg"/>
				</td>
			</tr>
			<tr>
				<th>생일</th>
				<td><form:input path="birth" /> 
				<form:errors path="birth" cssClass="errmsg" />
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><form:input path="phone" /> 
				<form:errors path="phone" cssClass="errmsg"/>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				남<form:radiobutton path="gender" value="M" /> 
				여<form:radiobutton path="gender" value="F" /> 
				<form:errors path="gender" cssClass="errmsg"/>
				</td>
			</tr>
			<tr align=right>
				<td colspan=2>
					<button id="joinBtn">가입</button>
					<button id="joinClearBtn">초기화</button>
					<button id="joinCancelBtn">가입취소</button>
			</tr>
		</table> --%>
	</form:form>
	</div>
</body>
<jsp:include page="/footer.jsp" flush="true" />
</html>