<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="../common_element/header.jsp"%>

	<h2>로그인</h2>
	
	<form method="post" action="login">
		
		아이디 <input type="text" name="loginId" /> <br>
		비밀번호 <input type="password" name="password" /> <br>
	
	 <button>로그인</button>
	
	</form>
	
	<!-- 회원가입 완료후 플래시메시지 -->
	<c:if test="${not empty successMsg}">
	    <script>
	        alert("${successMsg}");
	    </script>
	</c:if>
	
</body>
</html>