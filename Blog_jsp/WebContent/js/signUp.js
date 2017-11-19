function reg(){
	var form= document.getElementById("formSignUp");
	if(form.username.value == ""){
	alert("用户不能为空！");
	return false;
	}
	if(form.password.value == ""){
		alert("密码不能为空！");
		return false;
	}
	if(form.repassword.value == ""){
		alert("确认密码不能为空！");
		return false;
	}
	if(form.password.value != form.repassword.value){
		alert("两次密码输入不一致！");
		return false;
	}
	if(form.question.value == ""){
		alert("密码找回问题不能为空！");
		return false;
	}
	if(form.answer.value == ""){
		alert("密码找回答案不能为空！");
		return false;
	}
	if(form.email.value == ""){
		alert("电子邮箱不能为空！");
			return false;
		}
}