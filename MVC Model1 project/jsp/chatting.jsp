<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅창</title>
<link rel="stylesheet" type="text/css" href="css/member.css">
</head>
<body>
<div class="chat">
<form>
	<input type="text" id="textMessage">
	<input id="c" type="button" onclick="sendMessage()" value="보내기">
	<input id="c" type="button" onclick="disconnect()" value="종료">
</form>
<br>
<textarea id="messageWindow" rows="10" cols="50" readonly="true"></textarea>
<script type="text/javascript">
	var webSocket = new WebSocket("ws://localhost:8181/portfolio/websocket");
	var messageTextArea = document.getElementById("messageWindow");
	webSocket.onopen = function(message) {
		messageTextArea.value += "서버 연결중...\n";
	};
	webSocket.onclose = function(message) {
		messageTextArea.value += "서버 종료중...\n";
	};
	webSocket.onerror = function(message) {
		alert(message.data);
	};
	webSocket.onmessage = function(message) {
		messageTextArea.value += "상대방"+" : "+message.data+"\n";
	};
	function sendMessage(){
		var message = document.getElementById("textMessage");
		messageTextArea.value+= "나"+" : "+message.value+"\n";
		webSocket.send(message.value);
		message.value="";
	}
	function disconnect(){
		webSocket.close();
		alert("로그 아웃 되었습니다.");
		window.close();
	}
</script>
</div>
</body>
</html>