<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<link rel="stylesheet" href="<%=path %>/css/sapar.css" />
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/sapar.js"></script>
<script type="text/javascript" src="<%=path %>/js/WdatePicker.js"></script>
<title>角色分配</title>

</head>
<script type="text/javascript">
	function save(eId) {
		var no = eId;
		var role = document.getElementById(eId).value;

		alert(no + "," + role);
	}
	/*function turnThePage(page){
		$.ajax({
		  	url : "/rolePageContent.do",   //要提交的URL路径
			type : "post",      //发送请求的方式
			data : "page="+page,       //要发送到服务器的数据
			dataType : "json", //指定传输的数据格式
			success : function(result) {//请求成功后要执行的代码		
				document.getElementById("div1").innerHTML = result.pageColumn;				
				document.getElementById("div2").innerHTML = result.normalColumn;
				document.getElementById("no").value = result.no;
				document.getElementById("acceptId").value = result.acceptId;
				
			}
		});
	}*/
</script>
<body>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>检索用户信息</h2>
			</div>
			<div class="subfiled-content">
				<div class="search-box clearfix">
					<div class="kv-item clearfix">
						<label>地&nbsp;&nbsp;&nbsp;区：</label>
						<div class="kv-item-content">
							<select>
								<option>南宁</option>
								<option>玉林</option>
								<option>柳州</option>
							</select>
						</div>
					</div>
					<div class="kv-item clearfix">
						<label>部&nbsp;&nbsp;&nbsp;门：</label>
						<div class="kv-item-content">
							<select>
								<option>南宁</option>
								<option>玉林</option>
								<option>柳州</option>
							</select>
						</div>
					</div>
					<div class="kv-item clearfix">
						<label>员工姓名：</label>
						<div class="kv-item-content time-select-wrap">
							<input type="text" placeholder="请输入姓名" />
						</div>
					</div>
					<a href="javascript:;" class="sapar-btn sapar-btn-recom query-btn">查询</a>
				</div>


				<!--表格开始-->
				<div class="table">

					<!--表格具体内容-->
					<div class="table-box">
						<table>
							<thead>
								<tr>
									<th>工号</th>
									<th>员工姓名</th>
									<th>角色</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="account" items="${accountAllList}" varStatus="a">
								<c:forEach var="employee" items="${employeeAllList}" varStatus="e">
								<c:forEach var="role" items="${roleAllList}" varStatus="r">
								<c:if test="${a.index==e.index}">
								<c:if test="${e.index==r.index}">
								<tr>
									<td id="no">${account.employeeId}</td>
									<td>${employee.name}</td> 
									<td style="width: 100px;">
									<select id="${account.employeeId}" style="width: 100%;">
										<option value="${role.name }">${role.name}</option>
										<c:forEach var="roles" items="${roleList}">
										<c:if test="${roles.name!=role.name}">
											<option value="${roles.name }">${roles.name}</option>
										</c:if>
										</c:forEach>
									</select></td>
									<td><a href="" onclick="save(${account.employeeId});">保存</a></td>
								</tr>
								</c:if>
								</c:if>
								</c:forEach>
								</c:forEach>
								</c:forEach>
							</tbody>
						</table>	
					</div>			
				</div>
				<!--表格结束-->	
				<!-- 分页求美工 -->
				<a href="rolePageContent.do?page=0" > 首页 </a>	
				<c:if test="${nowPage>0}">
					<a href="rolePageContent.do?page=${nowPage-1}" > &lt;&lt;上一页 </a>
				</c:if>	
				${nowPage+1}
				<a href="rolePageContent.do?page=${nowPage+1}" > 下一页&gt;&gt; </a>
				<a href="javascript:;" > 尾页 </a>
				
			</div>
		</div>
		<div id="saper-ft"></div>
	</div>

</body>
</html>