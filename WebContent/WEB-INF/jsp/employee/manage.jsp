<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<link rel="stylesheet" href="css/sapar.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<title>员工管理</title>
</head>
<body>
    <div id="saper-container">
        <div id="saper-hd"></div>
        <div id="saper-bd">
            <div class="subfiled clearfix">
                <h2>员工管理</h2>
            </div>
            <div class="subfiled-content">
                <div class="search-box clearfix">
                    <div class="kv-item clearfix">
                        <label>姓名：</label>
                        <div class="kv-item-content">
                            <input type="text" placeholder="姓名">
                        </div>
                    </div>
                     <div class="kv-item clearfix">
                        <label>地址：</label>
                        <div class="kv-item-content">
                            <input type="text" placeholder="居住地址">
                        </div>
                    </div>
                    <div class="kv-item clearfix">
                        <label>手机：</label>
                        <div class="kv-item-content">
                            <input type="text" placeholder="手机">
                        </div>
                    </div>
                    <a href="javascript:;" class="sapar-btn sapar-btn-recom query-btn">查询</a>
                </div>
                

                <!--表格开始-->
                <div class="table">
                    <!--表格操作-->
                    <div class="table-operate ue-clear">
                        <a href="add.html" class="add" >添加</a>                       
                    </div>
                    <!--表格具体内容-->
                    <div class="table-box">
                        <table>
                            <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>工号</th>
                                    <th>手机号码</th>
                                    <th>职位</th>
                                    <th>入职时间</th>
                                    <th>居住地址</th>
                                    <th>操作</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>                                	
                                	<td>暂时没有数据</td>
                                	<td>暂时没有数据</td>
                                	<td>暂时没有数据</td> 
                                	<td>暂时没有数据</td> 
                                	<td>暂时没有数据</td> 
                                	<td>暂时没有数据</td>
                                	<td><a href="detail.jsp">详情</a>
                                		<a href="alter.jsp">修改</a>
                                		<a href="#">删除</a>
                                	</td> 
                                </tr>
                                
                            </tbody>
                        </table>
                    </div>
                </div><!--表格结束-->
            </div>
        </div>
        <div id="saper-ft"></div>
    </div>
    
</body>

<script type="text/javascript">

</script>
</html>