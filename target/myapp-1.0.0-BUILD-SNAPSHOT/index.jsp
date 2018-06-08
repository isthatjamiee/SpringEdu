<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"/>
<jsp:include page="navbar.jsp" flush="true"/>
<jsp:include page="body.jsp" flush="true"/>
<jsp:include page="footer.jsp" flush="true"/>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://v40.pingendo.com/assets/4.0.0/default/theme.css" type="text/css"> 
<!-- <style>
html{
background: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_event.jpg&quot;) no-repeat center center fixed;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size :  cover;
background-size : cover;
}
</style>
   -->
</head>

<body>
  <div class="py-1 text-center w-100 h-100" style="background-image: url(&quot;https://pingendo.github.io/templates/sections/assets/cover_event.jpg&quot;);
  background-size:cover; background-repeat: no-repeat; background-position: center;" >
    <div class="container py-5">
      <div class="row">
         <div class="align-self-center col-md-6 text-black" style ="font-family:ScriptS" >
          <p class="text-center text-md-left display-3">Welcome To Visit,</>
          <p class="lead display-4">${login.id}</p>
            <br>
          <a href="#" ></a>
          <a href="#" ></a>
        </div>
      </div>
    </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>