<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <title>유저 페이지</title>
</head>

<body>

<h1>유저 페이지 입니다.</h1>
<!-- principal = UserDetails -->
<p>principal: <sec:authentication property="principal"/></p>
<!-- 해당 로그인한 사람 테이블 내용이 모두 출력된다. principal.emp = getEmp..
(UserDetails를 상속받은 CustomUserDetails 클래스 안에 Emp가 있기 때문에..getter함수 사용해서 호출할 수 있다. -->
<p>EmpVO: <sec:authentication property="principal.emp"/></p>
<!-- UserDetails를 상속해서 커스터마징해서 principal emp를 불러오도록 확장했다..? -->
<p>사용자이름: <sec:authentication property="principal.emp.ename"/></p>
<p>사용자월급: <sec:authentication property="principal.emp.sal"/></p>
<p>사용자입사일자: <sec:authentication property="principal.emp.hiredate"/></p>
<p><a href="<c:url value="/" />">홈</a></p>

</body>
</html>