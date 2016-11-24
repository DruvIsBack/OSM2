$(document).ready(function(){
	console.log("Home page loaded successfully...");
	$("#btn_login_register").click(function(){
		console.log("LoginRegister button clicked...");
		console.log("Redirect from => "+$(location).attr('pathname')); 
		setCookie("redirect_from", $(location).attr('pathname'), "1");
		$(location).attr('href', './login');
	});
	$("#btn_logout").click(function(){
		console.log("Logout clicked...");
		setCookie("username", "", "0");
		setCookie("password", "", 0);
		$.ajax({
			type: 'post',
			url: 'clearSession',
			success: function(data){
				if(data == "1"){
					setCookie("JSESSIONID", "", 0);
					console.log("Clear alls...");
				}else{
					console.log("Something ERROR occured...");
				}
				location.reload();
			}
		});
	});
});