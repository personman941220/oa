<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/sapar.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<title>修改密码</title>
</head>
<script type="text/javascript">
	function show(){
		var Oldpassword = document.getElementById("Oldpassword").value;
		$.ajax({
			url : "Oldpassword.do",
			type : "get", 
			data : "Oldpassword="+Oldpassword,
			dataType : "json",
			success: function(result){
				document.getElementById("p1").innerHTML = result.msg;
			}
		});
	}
	function show2(){
		var Oldpassword = document.getElementById("Oldpassword").value;
		var Newpassword = document.getElementById("Newpassword").value;
		if(Oldpassword==Newpassword){
			document.getElementById("p2").innerHTML = "不能与原密码相同";
		}
	}
	function show3(){
		var Newpassword = document.getElementById("Newpassword").value;
		var Newpassword2 = document.getElementById("Newpassword2").value;
		if(Newpassword!=Newpassword2){
			document.getElementById("p3").innerHTML = "新密码和确认密码不一致，请确认";
		}else{
			document.getElementById("p3").innerHTML = "√";
		}
		
	}
	function s(){
		var Oldpassword = document.getElementById("Oldpassword").value;
		var Newpassword = document.getElementById("Newpassword").value;
		var Newpassword2 = document.getElementById("Newpassword2").value;
		alert(Oldpassword+","+Newpassword+","+Newpassword2);
		$.ajax({
			url : "pwdModify2.do",
			type : "get", 
			data: [ 
			       {"name":"Oldpassword","value":Oldpassword},
			       {"name":"Newpassword","value":Newpassword},
			       {"name":"Newpassword2","value":Newpassword2},
			       ],
			dataType : "json",
			success: function(result){
				
				alert(result.msg);
			}
		});
	}
</script>
<body>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>修改密码</h2>
				<h2>${msg}</h2>
			</div>
			<div class="subfiled-content">
				<form class="saper-form">
					<div class="kv-item clearfix">
						<label>用户名：</label>
						<div class="kv-item-content">
							<div class="user-name" style="line-height: 30px;">${account.getAccountId() }</div>
						</div>
					</div>
					<div class="kv-item clearfix">
						<label><span class="impInfo">*</span>原密码：</label>
						<div class="kv-item-content">
							<input id="Oldpassword" name="Oldpassword" type="text" placeholder="原密码" onblur="show()"> <h3 id="p1"></h3>
						</div>
					</div>
					<div class="kv-item clearfix">
						<label><span class="impInfo">*</span>新密码：</label>
						<div class="kv-item-content">
							<input id="Newpassword" name="Newpassword" type="text"  placeholder="新密码" onblur="show2()"><h3 id="p2"></h3>
						</div>
					</div>
					<div class="kv-item clearfix">
						<label><span class="impInfo">*</span>确认密码：</label>
						<div class="kv-item-content">
							<input id="Newpassword2" name="Newpassword2" type="text" placeholder="确认密码" onblur="show3()"><h3 id="p3"></h3>
						</div>
					</div>
					<div class="buttons">
						<a href="javascript:;" onclick="s()" class="sapar-btn sapar-btn-recom">确定</a>
					</div>
				</form>
			</div>
		</div>
		<div id="saper-ft"></div>
	</div>
</body>

</html>