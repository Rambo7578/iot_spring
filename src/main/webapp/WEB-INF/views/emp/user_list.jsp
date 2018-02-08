<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
var au = new AjaxUtil("${root}/emp/ulist",null,"GET","json");
function callback(res){
	console.log(res);
	alert(res.msg);
    $("#userTable").bootstrapTable({data:res.userTable});
	
}
au.setCallbackSuccess(callback);
au.send();

</script>
<body>
	<div class="container">
		<table data-toggle="table" id="userTable" data-url="${root}/emp/ulist">
			<thead>
				<tr>
					<th data-field="uiNo">번호</th>
					<th data-field="uiName">이름</th>
					<th data-field="uiAge">나이</th>
					<th data-field="uiId">아이디</th>
					<th data-field="uiPwd">비밀번호</th>
					<th data-field="address">주소</th>
				</tr>

			</thead>
		</table>
		
	</div>
</body>
</html>