<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
div.controls {
	margin: 0px 10px;
	font-size: 14px;
	font-family: Tahoma;
	color: #404040;
	height: 80px;
}

div#winVP {
	position: relative;
	height: 600px;
	border: 1px solid #dfdfdf;
	margin: 10px;
}
</style>
<script>
	var winF, popW;
	var popW2;
	$(document).ready(function() {
		winF = new dhtmlXWindows();
		winF.attachViewportTo("winVP");
		popW = winF.createWindow("win1", 20, 30, 500, 500);
		popW.hide();
		popW.setText("폼태그");

		var formObj = [ {
			type : "setting",
			offsetTop : 12,
			name : "connectionInfo",
			labelAlign : "left"
		}, {
			type : "input",
			name : "ciName",
			label : "컨넥션이름",
			required : true
		}, {
			type : "input",
			name : "ciUrl",
			label : "접속url",
			required : true
		}, {
			type : "input",
			name : "ciPort",
			label : "PORT번호",
			validate : "ValidInteger",
			required : true
		}, {
			type : "input",
			name : "ciDatabase",
			label : "DB",
			required : true
		}, {
			type : "input",
			name : "ciUser",
			label : "유저",
			required : true
		}, {
			type : "password",
			name : "ciPwd",
			label : "비밀번호",
			required : true
		}, {
			type : "input",
			name : "ciEtc",
			label : "설명",
			required : true
		},

		{
			type : "block",
			blockOffset : 0,
			list : [ {
				type : "button",
				name : "saveBtn",
				value : "저장"
			}, {
				type : "newcolumn"
			}, {
				type : "button",
				name : "cancelBtn",
				value : "취소"
			} ]
		} ];

		var form = popW.attachForm(formObj, true);
		form.attachEvent("onButtonClick", function(id) {

			if (id == "saveBtn") {
				if (form.validate) {
					form.send("${root}/connection/insert", "post", calback);
				}

			} else if (id == "cancelBtn") {
				form.clear();
			}
		})
	})
	function calback(loader, res) {
		var res = JSON.parse(res);
		alert(res.msg);
	}

	function showPopW(onOff) {
		if (onOff) {
			popW.show();
			return;
		}
	}
</script>
<body>
	<div id="winVP"></div>
	<div class="controls">
		<button onclick="showPopW(true)">떠라 창</button>
		<button onclick="showPopW(false)">꺼라 창</button>
	</div>
</body>
</html>