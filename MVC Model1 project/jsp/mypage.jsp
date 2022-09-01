<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/check.js"></script>
<link rel="stylesheet" type="text/css" href="css/member.css">
<link href="https://fonts.googleapis.com/css2?family=Hahmlet:wght@900&display=swap" rel="stylesheet">
</head>
<body>
<h1 id="u">마이 페이지</h1>
<form name="frm" action="delete.do" method="get">
<table class="update">
	<tr>
		<td id="name">이름</td>
		<td id="c">${loginUser.name }</td>
	</tr>
	<tr>
		<td id="name">닉네임</td>
		<td id="c">${loginUser.nickname }
		<input type="hidden" name="nickname" value="${loginUser.nickname }">
		</td>
	</tr>
	<tr>
		<td id="name">주민등록번호</td>
		<td id="c">${loginUser.pass }</td>
	</tr>
	<tr>
		<td id="name">아이디</td>
		<td id="c">${loginUser.id }</td>
	</tr>
	<tr>
		<td id="name">비밀번호</td>
		<td id="c">${loginUser.pw }</td>
	</tr>
	<tr>
		<td id="name">이메일</td>
		<td id="c">${loginUser.email }</td>
	</tr>
	<tr>
		<td id="name">메일/SMS 정보 수신</td>
		<td id="c">${loginUser.receive}</td>
	</tr>
	<tr>
		<td id="name">우편번호</td>
		<td id="c">${loginUser.post }</td>
	</tr>
	<tr>
		<td id="name">주소</td>
		<td id="c">${loginUser.address }</td>
	</tr>
	<tr>
		<td id="name">핸드폰 번호</td>
		<td id="c">${loginUser.phone }</td>
	</tr>
	<tr>
		<td id="name">직업</td>
		<td id="c">${loginUser.job }</td>
	</tr>
	<tr>
		<td id="name">관심분야</td>
		<td id="c">${loginUser.interest }</td>
	</tr>	
</table>
<table class="btn2">
<tr>
	<td colspan="3">
	<input id="c" type="button" value="수정" onclick="location.href='update.do'">
	<input id="c" type="submit" value="회원탈퇴">
	<input id="c" type="button" value="뒤로가기" onclick="history.go(-1)">
	</td>
</tr>
</table>
</form>			
</body>
</html>