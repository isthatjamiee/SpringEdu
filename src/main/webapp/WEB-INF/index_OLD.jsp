<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/webjars/bootstrap/4.1.0/css/bootstrap.css">
  <script src="/webjars/jquery/3.3.1/dist/jquery.js"></script>
  <script src="/webjars/bootstrap/4.1.0/js/bootstrap.js"></script>
<title>Insert title here</title>

<style>
*{margin:auto; text-align:center;}
html, body{margin:0; padding:0; height:100%;}
#header{height:10%; background-color:#FFC0C0}
#nav{height:10%; background-color:#A6CAF0}
#content{height:70%; background-color:#FFFFFF}
#footer{height:10%; background-color:#FFFFFF}
</style>
</head>

<body>
<header id="header"></header>
<div class="container">
<nav id="nav" class="navbar navbar-dark bg-dark">
<a href="/login/loginIn">로그인</a><br>
<a href="/login/logout">로그아웃</a><br>
<a href="/member/memberJoin">회원가입</a><br>
</nav>
</div>
<section id="content">
${login.id} 님 환영합니다 <br>
</section>
<footer id="footer"></footer>
</body>
</html>