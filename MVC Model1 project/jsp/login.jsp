<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅창 로그인</title>
<script type="text/javascript" src="script/check.js"></script>
<link rel="stylesheet" type="text/css" href="css/member.css">
<link href="https://fonts.googleapis.com/css2?family=Hahmlet:wght@900&display=swap" rel="stylesheet">
</head>
<body>
<h1 id="l">로그인</h1>
<form action="Success.do" method="post" name="frm">
<table class="login">
	<tr>
		<td><label for="a">아이디 : </label></td>
		<td><input id="a" type="text" name="id"></td>
	</tr>
	<tr>
		<td><label for="g">비밀번호 : </label></td>
		<td><input id="g" type="password" name="pw"></td>
	</tr>
	<table class="id">
	<tr>
		<td colspan="2"><input id="a" type="submit" value="로그인" onclick="login_check()">
		<input id="a" type="reset" value="다시 작성">
		<input id="a" type="button" value="회원가입" onclick="location.href='register.jsp'"></td>
	</tr>
	<tr>
		<td id="m" colspan="2">${message }</td>
	</tr>	
	</table>
</table>	
</form>
</body>
</html>