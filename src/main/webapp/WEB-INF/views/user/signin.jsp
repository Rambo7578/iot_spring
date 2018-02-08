<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


	
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${root}/resources/ui/css/main/main.css">
		<link rel="stylesheet" type="text/css" href="${root}/resources/ui/css/signup/signup.css">
		
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		


		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
	


		<title>Admin</title>
<body>
	

</head>

	

			<div class="container">
			<div class="row main">
				<div class="main-login main-center">
				<h5>Sign up</h5>
					<form class="" method="post" action="#">
						
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">이름</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="uiName" id="uiName"  placeholder="이름"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">나이</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="uiAge" id="uiAge"  placeholder="나이"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">아이디</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="uiId" id="uiId"  placeholder="아이디"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">비밀번호</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="uiPwd" id="uiPwd"  placeholder="비밀번호"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">반</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<select type="text" class="form-control" name="ciNo" id="ciNo"  placeholder="반"/></select>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">주소</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="address" id="address"  placeholder="주소"/>
								</div>
							</div>
						</div>

						<input	class="btn btn-lg btn-primary btn-block" type="button" id="singnBtn" value="signin" onclick="signin()">
					
						
					</form>
				</div>
			</div>
		</div>
		 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
<script>
function signin(){
	//"uiName,uiAge,uiId,uiPwd,ciNo,address"
	var uiName = $("#uiName").val().trim();
	var uiAge = $("#uiAge").val().trim();
	var uiId = $("#uiId").val().trim();
	var uiPwd = $("#uiPwd").val().trim();
	var ciNo = $("#ciNo").val();
	var address = $("#address").val().trim();
	var param= {uiName:uiName, uiAge:uiAge, uiId:uiId, uiPwd:uiPwd, ciNo:ciNo, address:address};
	param = "param=" + JSON.stringify(param);	
	
	$.ajax({
		url : '/user/signin',
		type : 'post',
		data : param,		
		success:function(res){
			var obj = JSON.parse(res);
			alert(obj.msg);
			if(obj.result=="ok"){
				location.href="/view/user/login";
			}
		},
		error:function(xhr,status,error){
			
		}		
	})
}
$(document).ready(function(){
	$.ajax({
		url : '/class/list',
		type : 'get',
		success:function(res){
			var list = JSON.parse(res);
			var str = "";
			for(var ci of list){
				str += "<option value='" + ci.ciNo + "'>" + ci.ciName +"</option>";
			}
			//document.getElementById("ciNo").insertAdjacentHTML("beforeend",str);
			$("#ciNo").html(str);
		},
		error:function(xhr,status,error){
			
		}
	});
	
});
</script>
</html>