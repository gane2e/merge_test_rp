<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>
	가으니의게시판
</h1>

<a href="/">Home</a>
<a href="/user/login">로그인</a>
<a href="/user/register">회원가입</a>

<c:if test="${not empty sessionScope.username}">
      <span>${sessionScope.username} 님 환영합니다.</span>
</c:if>

<a href="/user/logout">로그아웃</a>

</body>
</html>