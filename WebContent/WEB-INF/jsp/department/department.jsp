<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sapar.css" />
<link rel="stylesheet" type="text/css" href="css/detail.css" />
<link rel="stylesheet" type="text/css" href="css/box.css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<title>部门管理</title>
</head>
<body>
	<script type="text/javascript">
		function msgBox(n) {
			//alert("add");
			//方式1：
			/*var str = prompt("部门名", "请输入部门名");
			if (str) {
				alert("您刚输入的是：" + str)
			}*/
			//方式2：
			document.getElementById('inputbox').style.display = n ? 'block': 'none'; /* 点击按钮打开/关闭 对话框 */
		}
		function add() {
			var departmentName = document.getElementById('departmentName').value;
			$.ajax({
			  	url : "department/add.do",   //要提交的URL路径
				type : "post",      //发送请求的方式
				data : "name="+departmentName,       //要发送到服务器的数据
				dataType : "json", //指定传输的数据格式
				success : function(result) {//请求成功后要执行的代码						
					if(result.msg=="部门添加成功！"){
						//alert(result.msg);
						msgBox(0);//添加成功，关闭窗口
						document.getElementById('newDepartmentName').innerHTML = result.newDepartmentName;
						document.getElementById('newOperationButton').innerHTML = "<a href='javascript:edit("+result.dId+");'>编辑</a>"+
						"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:delet("+result.dId+");'>删除</a>";
						/*
							<a href="javascript:edit(${d.departmentId});">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="javascript:delet(${d.departmentId});">删除</a>
						*/
					}else{
						//添加失败
						document.getElementById('msg').innerHTML = result.msg;
					}
				}
			});	
		}
		function query() {
			var name = document.getElementById('queryName').value;
			window.location.href="query.do?name="+name;
		}
		function edit(dId) {
			alert(dId);
		}
		function delet(dId) {
			//alert(dId);
			window.location.href="delet.do?departmentId="+dId;
		}
	</script>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>部门管理</h2>
			</div>
			<div class="subfiled-content">
				<div class="search-box clearfix">

					<div class="kv-item clearfix">
						<label>部门名：</label>
						<div class="kv-item-content">
							<input id="queryName" type="text" placeholder="请输入部门名" />
						</div>
					</div>

					<a href="javascript:query();" class="sapar-btn sapar-btn-recom query-btn">查询</a>
				</div>


				<!--表格开始-->
				<div class="table">

					<!--表格操作-->
					<div class="table-operate ue-clear">
						<a href="javascript:msgBox(1);" class="add">添加部门</a>
					</div>

					<div id="inputbox" class="box">			 
						<div class="search-box clearfix">
							<div class="kv-item clearfix">								
								<div class="kv-item-content">
									<input id="departmentName" style="width: 150px" type="text" placeholder="请输入部门名" />
									<p id="msg" style="color: red"></p>
								</div>
							</div>
						</div>
						
						<a class="sapar-btn sapar-btn-recom query-btn" onClick="add()">确定</a>
						<a style="position: absolute; left: 132px; top: 183px;" class="sapar-btn sapar-btn-recom query-btn" onClick="msgBox(0)">退出</a>
						
					</div>
					
					<!--表格具体内容-->
					<div class="table-box">
						<table>
							<thead>
								<tr>
									<th class="num">部门名</th>
									<th class="operate">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="d" items="${departmentList}">
									<tr>
										<td>${d.name}</td>
										<td><a href="javascript:edit(${d.departmentId});">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="javascript:delet(${d.departmentId});">删除</a></td>
									</tr>
								</c:forEach>
								<tr>
									<td id="newDepartmentName"></td>
									<td id="newOperationButton"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!--表格结束-->
			</div>
		</div>
		<div id="saper-ft"></div>
	</div>
</body>
</html>