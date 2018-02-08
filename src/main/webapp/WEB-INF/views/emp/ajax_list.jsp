<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax_list</title>
</head>
<script>
//var au = new AjaxUtil("${root}/emp/list",null,null,"text/html");
var au = new AjaxUtil("${root}/emp/lista",null,"GET","json");
function callback(res){
	console.log(res);
	alert(res.msg);
    $("#empTable1").bootstrapTable({data:res.empList1});
	$("#empTable2").bootstrapTable({data:res.empList2});
}
au.setCallbackSuccess(callback);
au.send();
</script>

<body>
	<div class="container">
		<table data-toggle="table" id="empTable" data-url="${root}/emp/lista">
			<thead>
				<tr>
					<th data-field="empSal">월급</th>
					<th data-field="empName">이름</th>
					<th data-field="empNo">번호</th>
				</tr>

			</thead>
		</table>
		<a href="/path/emp/write"><button>사원정보추가</button></a>
	</div>
</body>
</html>