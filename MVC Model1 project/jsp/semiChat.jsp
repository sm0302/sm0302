<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
<link rel="stylesheet" type="text/css" href="css/member.css">
</head>
<body>
<form name="frm">
<table class="success">	
<tr>
	<td colspan="10"><input id="b" type="hidden" name="id" value="${loginUser.id }">
	<input id="b" type="button" value="회원가입" onclick="location.href='register.jsp'">
	<input id="b" type="button" value="로그인하기" onclick="location.href='Success.do'"></td>
</tr>
</table>
</form>
</body>
</html>