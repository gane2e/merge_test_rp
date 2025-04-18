<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="../common_element/header.jsp"%>

	<h2>회원가입</h2>
	
	<form method="post" action="register">
		
		성명  <input type="text" name="username" /> <br>
		아이디 <input type="text" name="loginId" /> <a href="#">중복확인</a> <br>
		비밀번호 <input type="password" name="password" /> <br>
		비밀번호 확인 <input type="password" name="passwordConfirm" /> <br>
		
	 	<button>회원가입</button>
	 </form>
	

</body>
</html>