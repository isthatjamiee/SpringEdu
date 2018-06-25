<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://v40.pingendo.com/assets/4.0.0/default/theme.css" type="text/css"> </head>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

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
	      
	//아이디 찾기
     $('#findid').on("click",function(e){
    	 e.preventDefault();
    	 $(location).attr("href", $(this).attr(""))
     });
	
	
	//비밀번호 찾기

   });
});

</script>
<jsp:include page="/navbar.jsp" flush="true" />
</head>

<body draggable="true" >
<c:if test="${param.fail != null}">
<p>Fail Login</p>
</c:if>
<c:url value="login" var="loginUrl"/>

<%-- <form:form modelAttribute="login" action="${pageContext.request.contextPath }/${loginUrl}" method="post"> --%>
<form:form action="${pageContext.request.contextPath }/${loginUrl}" method="post">
    <div align="center" class="py-1 text-white opaque-overlay h-100 w-100 mx-auto p-5" 
    style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_restaurant.jpg&quot;);
    background-size:cover; background-position:center; background-repeat:no-repeat;">
    <div class="container py-5">
      <div class="row">
        <div class="col-md-3"></div>
        <div align="center" class="col-md-6">
          <h1 class="text-gray-dark">Login</h1>
            <div class="form-group">
              <label>Email address</label>
              <%-- <form:input type="email" path="username" name="email" class="form-control" placeholder="Enter email" />
			  <form:errors path="username" /> --%>
			  <%-- <form:errors path="username" /> --%>
			  <input type="email" name="username" class="form-control" placeholder="Enter email" />
              </div>
            <div class="form-group">
              <label>Password</label>
              <%-- <form:password path="password" class="form-control" placeholder="Password"/>
			  <form:errors path="password" /> --%>
			  <input type="password" name="password" class="form-control" placeholder="Password"/>
              </div>
            <div class="button-group" align="right" style="margin-right: 30px;" >
            <button id="loginbtn" type="submit" class="btn btn-primary">Login</button>
			<button id="join" class="btn btn-primary" data-url="/member/memberJoin">Join</button>
			</div>
			<br>	
    		<div style="text-align: center;">
    		<a href="${pageContext.request.contextPath }/member/findId" class="findid" data-toggle="modal" data-target=".id-modal">Forgot your id</a> /
    		<a href="${pageContext.request.contextPath }/member/findPasswd" class="findpasswd" data-toggle="modal" data-target=".passwd-modal">password?</a>
    		</div>
        </div>
      </div>
    </div>
  </div>
   </form:form>
</body>
<jsp:include page="/footer.jsp" flush="true" />
</html>
