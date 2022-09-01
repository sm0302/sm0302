<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background-color: #494949;
}
td.login {
	border:1px solid #f2e70d;
	width:200px;
	height:50px;
	text-align:center;
	color:#f2e70d;
}

td.login:hover{
	background-color: black;
}
</style>
<script type="text/javascript" src="script/check.js"></script>
</head>
<body>
<table class="mainmenu" align="center">
	<c:if test="${empty loginUser }">
		<tr>
			<td></td>
			<td></td>
			<td class="login"><a name="login" href="login.do" style="text-decoration:none;">로그인</a></td>
			<td class="login">채팅창<br><span style="color:red">(로그인 후 사용 가능)</span></td>
			<td class="login">
			마이페이지<br>
			<span style="color:red">(로그인 후 사용 가능)</span>
			</td>
		</tr>
	</c:if>
	<c:if test="${!empty loginUser }">
		<tr>
			<td class="login">${loginUser.nickname }님 반갑습니다</td>
			<td class="login"><a href="semiChat.jsp" style="color:#f2e70d; text-decoration:none" onclick="chat()">채팅창</a></td>
			<td class="login"><a href="logout.do" style="color:#f2e70d; text-decoration:none">로그 아웃</a></td>
			<td class="login" style="width:300px color:#f2e70d;">게임<br></td>
			<td class="login">
				<a href="page.do" style="text-decoration:none; color:#f2e70d;">
				마이페이지</a>
			</td>
		</tr>
	</c:if>
</table>
</body>
</html>