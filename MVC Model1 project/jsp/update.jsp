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
<h1 id="u">마이 페이지-수정</h1>
<form method="post" name="frm" action="update.do">
<table class="update">
	<tr>
		<td id="name">이름</td>
		<td><input id="c" type="text" name="name" value="${loginUser.name }"></td>
	</tr>
	<tr>
		<td id="name">닉네임</td>
		<td><input id="c" type="text" name="nickname" value="${loginUser.nickname }">
		<input type="hidden" name="nick" value="${loginUser.nickname }">
		</td>
	</tr>
	<tr>
		<td id="name">주민등록번호</td>
		<td><input id="c" type="text" name="pass" value="${loginUser.pass }"></td>
	</tr>
	<tr>
		<td id="name">아이디</td>
		<td><input id="c" type="text" name="id" value="${loginUser.id }"></td>
	</tr>
	<tr>
		<td id="name">비밀번호</td>
		<td><input id="c" type="password" name="pw" value="${loginUser.pw }"></td>
	</tr>
	<tr>
		<td id="name">이메일</td>
		<td><input id="c" type="text" name="email" value="${loginUser.email }"></td>
	</tr>
	<tr>
		<td id="name">메일/SMS 정보 수신</td>
		<c:if test="${loginUser.receive eq '수신' }">
		<td><input type="radio" name="receive" value="on" checked="checked"> <span style="color:#f2e70d;">수신</span>
		<input type="radio" name="receive" value="off"><span style="color:#f2e70d;"> 수신거부</span></td>
		</c:if>
		<c:if test="${loginUser.receive eq '수신거부' }">
		<td><input type="radio" name="receive" value="on"><span style="color:#f2e70d;"> 수신</span>
		<input type="radio" name="receive" value="off" checked="checked"> <span style="color:#f2e70d;">수신거부</span></td>
		</c:if>
	</tr>
	<tr>
		<td id="name">우편번호</td>
		<td><input id="c" type="text" name="post" value="${loginUser.post }"></td>
	</tr>
	<tr>
		<td id="name">주소</td>
		<td><input id="c" type="text" name="address" value="${loginUser.address }" size="70"></td>
	</tr>
	<tr>
		<td id="name">핸드폰 번호</td>
		<td><input id="c" type="text" name="phone" value="${loginUser.phone }"></td>
	</tr>
	<tr>
		<td id="name">직업</td>
		<td><select id="c" name="job" size="3" multiple="multiple">	
				<option value="1">컴퓨터/인터넷</option>
				<option value="2">언론</option>
				<option value="3">공무원</option>
				<option value="4">학생</option>
				<option value="5">축구선수</option>
		</select></td>
	</tr>
	<tr>
		<td id="name">관심분야</td>
		<td><input type="checkbox" name="interest" value="computer game"> <span style="color:#f2e70d;">컴퓨터 게임</span>
		<input type="checkbox" name="interest" value="cook"> <span style="color:#f2e70d;">요리</span>
		<input type="checkbox" name="interest" value="shopping"> <span style="color:#f2e70d;">쇼핑</span>
		<input type="checkbox" name="interest" value="draw"> <span style="color:#f2e70d;">그림 그리기</span>
		<input type="checkbox" name="interest" value="book"> <span style="color:#f2e70d;">책 읽기</span>
		<input type="checkbox" name="interest" value="sports"> <span style="color:#f2e70d;">스포츠</span>
	</td>
	</tr>	
</table>
<table class="btn">
<tr>
	<td colspan="3"><input id="c" type="submit" value="수정 완료">
	<input id="c" type="reset" value="다시 수정">
	<input id="c" type="button" value="로그인하러 가기" onclick="location.href='login.jsp'"></td>
</tr>
</table>
</form>			
</body>
</html>