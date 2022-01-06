<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>홈페이지</h1>

	<sec:authorize access="isAnonymous()">
		<p>
			<a href="<c:url value="/login/loginForm" />">로그인</a>
		</p>
	</sec:authorize>

	<!-- principla 일종의 객체로 session같은? -->
	<sec:authorize access="isAuthenticated()">
		<p>환영합니다. :<sec:authentication property="principal.username" />님</p>
		<p>패스워드 : <sec:authentication property="principal.password" /></p>
     	<p>principal : <sec:authentication property="principal"/></p>
	</sec:authorize> <!-- 패스워드는 절대 함부로 웹페이지에 띄우지 않는다.. -->



</body>
</html>
