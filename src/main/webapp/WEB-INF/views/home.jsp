<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

<%@ include file="./common_element/header.jsp"%>




<br />
<button>등록하기</button> <!-- 로그인후가능 -->
<table>
	<tr>
		<td>No</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일자</td>
	</tr>
	<tr>
		<td>1</td>
		<td>제목입니다.</td>
		<td>홍길동</td>
		<td>2024-01-01</td>
	</tr>
</table>

	<!-- 회원가입 완료후 플래시메시지 -->
	<c:if test="${not empty loginSuccessMsg}">
	    <script>
	        alert("${loginSuccessMsg}");
	    </script>
	</c:if>

</body>
</html>
