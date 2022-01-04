<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/include/header.jspf"  %>
<title>Login</title>
</head>
<body onload="document.f.id.focus();">
      <br><br>
      <div class="container text-center">
          <h1>로그인 페이지</h1><br>
      </div>
      <c:url value="/login" var="loginUrl" />
      <div class="container col-md-4">
      	  <!-- form태그를 쓸 때 스프링 시큐리티를 사용하게 되면 _csrf가 붙게 된다. (보안관련 기능?) -->
	      <form:form name ="f" class="px-4 py-3" action="${loginUrl}" method="post">
	            <c:if test="${param.error != null}">
        			<p>아이디와 비밀번호가 잘못되었습니다.</p>
    			</c:if>
    			
    			<c:if test="${param.logout != null}">
        			<p>로그아웃 하였습니다.</p>
    			</c:if>
    			
	          <div class="form-group">
	              <label for="exampleDropdownFormEmail1">ID</label>
	              <input type="text" class="form-control" name="username" placeholder="example">
	          </div>							<!-- name과 security-context.xml의 username-parameter와 같아야한다. -->
	          <div class="form-group">
	              <label for="exampleDropdownFormPassword1">Password</label>
	              <input type="password" class="form-control" name="pw" placeholder="Password">
	          </div>							<!-- name과 security-context.xml의 password-parameter와 같아야한다. -->
	          <div class="form-check">
	              <label class="form-check-label">
	              <input type="checkbox" class="form-check-input">
	              Remember me
	              </label>
	          </div>
	          <!-- <from:form... 을 사용하게되면 아래 코드를 스프링 시큐리티가 자동으로 만들어 붙여준다. 자동으로 안붙으면 직접 넣어야한다. 
	          		아래의 코드가 없으면 오류난다. (GET 방식은 상관없고 POST 방식일 때!)-->
	          <%-- <input name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}"/> --%>
	          <button type="submit" class="btn btn-primary">Sign in</button>
	   </form:form>
	      <div class="dropdown-divider"></div>
	      <a class="dropdown-item" href="#">New around here? Sign up</a>
	      <a class="dropdown-item" href="#">Forgot password?</a>
	  </div>

</body>
</html>