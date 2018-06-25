<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<sec:authentication var="user" property="principal" scope="session" />
<sec:authentication var="user2" property="name" scope="session" />
<body>
	<!-- 헤더 시작 -->
	<div class="container">
		<div class="py-1 text-center">
			<div class="row">
				<div class="col-md-12">
					<h1 class="display-1">Spring FrameWork</h1>
				</div>
			</div>
		</div>

		<p class="text-muted text-right font-weight-bold ">
			<span class="text-dark bg-light">${user2 }님 <c:if
					test="${user2 eq 'anonymousUser' }">
					<a class="text-danger"
						href='${pageContext.request.contextPath}/login/login'>Login </a>
				</c:if> <c:if test="${user2 ne 'anonymousUser' }">
					<a class="text-danger"
						href='${pageContext.request.contextPath}/login/logout'>LogOut</a>
				</c:if>
			</span>
		</p>
		<!-- 헤더 끝 -->

		<!-- 메뉴바 시작 -->
		<!-- 네비게이션에서 하나 찾아서 뭐 쓰면 될것 같아요  -->
		<!-- 점보트론 밑에 밑에보면...네비게이션...  -->
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href='${pageContext.request.contextPath} /'>Home</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<%-- <c:if test="${login.username eq null}"> --%>
						<li class="nav-item "><a class="navbar-brand"
							href='${pageContext.request.contextPath }/login/login'>Login</a>
						</li>
						<li class="nav-item "><a class="navbar-brand"
							href='${pageContext.request.contextPath}/login/logout'>LogOut</a>
						</li>
						<li class="nav-item "><a class="navbar-brand"
							href='${pageContext.request.contextPath }/member/memberJoin'>Join</a>
						</li>
						<li class="nav-item "><a class="navbar-brand"
							href='${pageContext.request.contextPath}/bbs/list'>Bulletin</a></li>

						<sec:authorize var="isAdminRole" access="hasRole('ADMIN')">
							<c:if test="${isAdminRole }">
								<li class="nav-item"><a class="nav-link"
									href='${pageContext.request.contextPath}/admin/admin'>ADMIN</a></li>
							</c:if>
						</sec:authorize>
					</ul>
					<form class="form-inline my-2 my-lg-0" style="float:right">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
				</div>
			</nav>
		</div>
		<!-- 메뉴바 끝 -->
	</div>