<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="login.do" name="frm" method="post">
<h1 id="r">회원가입</h1>
<table class="register">
	<tr>
		<td id="name">이름</td>
		<td><input id="c" type="text" name="name"></td>
	</tr>
	<tr>
		<td id="name">닉네임</td>
		<td><input id="c" type="text" name="nickname"></td>
	</tr>
	<tr>
		<td id="name">주민등록번호</td>
		<td><input id="c" type="text" name="idNum"><span style="color:#f2e70d;">-</span><input id="c" type="text" name="idNum1"></td>
	</tr>
	<tr>
		<td id="name">아이디</td>
		<td><input id="c" type="text" name="id"></td>
	</tr>
	<tr>
		<td id="name">비밀번호</td>
		<td><input id="e" type="password" name="pw1" onchange="checkPass()"></td>
	</tr>
	<tr>
		<td id="name">비밀번호 확인</td>
		<td><input id="d" type="password" name="pw2" onchange="checkPass()">&nbsp;<span id="check"></span></td>
	</tr>
	<tr>
		<td id="name">이메일</td>
		<td><input id="c" type="text" name="email"><span style="color:#f2e70d;">@</span><input id="c" type="text" name="email1" id="email1">
		<select id="c" onchange="changeEmail()" name="email2" size="1" id="email2">
			<option value="nate.com">nate.com</option>
			<option value="naver.com">naver.com</option>
			<option value="gmail.com">gmail.com</option>
			<option value="daum.net">daum.net</option>
		</select></td>
	</tr>
	<tr>
		<td id="name">우편번호</td>
		<td><input id="c" type="text" name="postNum"></td>
	</tr>
	<tr>
		<td id="name">주소</td>
		<td><input id="c" type="text" name="address"> <input id="c" type="text" name="address1"></td>
	</tr>
	<tr>
		<td id="name">핸드폰번호</td>
		<td><input id="c" type="text" name="num" value="010" readonly="readonly" size="3" style="text-align:center;">&nbsp;<span style="color:#f2e70d;">-</span>
		<input id="c" type="text" name="num1" size="3">&nbsp;<span style="color:#f2e70d;">-</span>
		<input id="c" type="text" name="num2" size="3">
		</td>
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
		<td id="name">메일/SMS 정보 수신</td>
		<td><input type="radio" name="receive" value="on"><span style="color:#f2e70d;"> 수신</span>
		<input type="radio" name="receive" value="off"> <span style="color:#f2e70d;">수신거부</span></td>
	</tr>
	<tr>
		<td id="name">관심분야</td>
		<td><input type="checkbox" name="interest" value="computer game"> <span style="color:#f2e70d;">컴퓨터 게임</span>
		<input type="checkbox" name="interest" value="cook"><span style="color:#f2e70d;">요리</span>
		<input type="checkbox" name="interest" value="shopping"><span style="color:#f2e70d;"> 쇼핑</span>
		<input type="checkbox" name="interest" value="draw"> <span style="color:#f2e70d;">그림 그리기</span>
		<input type="checkbox" name="interest" value="book"><span style="color:#f2e70d;"> 책 읽기</span>
		<input type="checkbox" name="interest" value="sports"><span style="color:#f2e70d;"> 스포츠</span>
	</td>
	</tr>	
</table>
<table class="regi">
<tr>
	<td colspan="3"><input id="c" type="submit" value="회원가입" onclick="checkAll()">
	<input id="c" type="reset" value="다시 작성">
	<input id="c" type="button" value="로그인하러 가기" onclick="location.href='Success.do'"></td>
</tr>
</table>
</form>
</body>
</html>