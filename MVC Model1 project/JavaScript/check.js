function login_check(){
	if(document.frm.id.value==""){
		alert("아이디를 입력해 주세요");
		document.frm.id.focus();
		return;
	}
	if(document.frm.pw.value==""){
		alert("비밀번호를 입력해 주세요");
		document.frm.pw.focus();
		return;
	}
}
function chat(){
	alert("로그인 성공");
	var url="chatting.jsp?id="+document.frm.id.value;
	window.open(url,"_blank","toolbar=no, menubar=no, scrollbars=no, resizable=no, width=500, height=300");
}
function checkPass(){
	var pw = document.getElementById("e");
	var pw2 = document.getElementById("d");
	var check = document.getElementById("check");
	if(!(pw.value==""&&pw2.value=="")){
		if(pw.value==pw2.value){
			check.innerText="비밀번호가 일치합니다.";
			check.style.color="blue";
		}
		else{
			check.innerText="비밀번호가 일치하지 않습니다.";
			check.style.color="red";
		}
	}
}
function checkAll(){
	
	var pw = document.getElementById("e");
	var pw2 = document.getElementById("d");
	if(pw.value!=pw2.value){
		alert("비밀번호가 틀립니다 다시 확인해주세요.");
		frm.password.focus();
		return false;
	}
	else{
		return true;
	}
}
function changeEmail(){
	i=document.frm.email2.selectedIndex
 	var email=document.frm.email2.options[i].value
 	document.frm.email1.value=email
}