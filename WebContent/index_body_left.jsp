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
<link rel="stylesheet" href="css/index_inner.css" />

</head>
<body>
	<div id="container">
		<div id="bd">
			<div class="wrap clearfix">
				<div class="sidebar">
					<h2 class="sidebar-header">
						<p>功能导航</p>
					</h2>
					<ul class="nav">
						<!--
                	<li class="office current"><div class="nav-header"><a href="javascript:;" data-src="system_index.html" class="clearfix"><span>系统首页</span><i class="icon"></i></a></div></li>
                    <li class="gongwen"><div class="nav-header"><a href="javascript:;" data-src="my_info.html" class="clearfix"><span>我的资料信息</span><i class="icon"></i></a></div></li>
                    <li class="nav-info">
                    	<div class="nav-header"><a href="javascript:;" class="clearfix"><span>投诉与建议</span><i class="icon"></i></a></div>
                    </li>
                    <li class="konwledge">
                        <div class="nav-header">
                            <a href="javascript:;" data-src="login_times.html" class="clearfix"><span>登录记录查看</span><i class="icon"></i>
                            </a>
                        </div>
                    </li>
                    <li class="agency"><div class="nav-header"><a href="javascript:;" data-src="airline_info.html" class="clearfix"><span>航空公司信息</span><i class="icon"></i></a></div></li>
                    <li class="email"><div class="nav-header"><a href="javascript:;" data-src="airport_info.html" class="clearfix"><span>机场信息</span><i class="icon"></i></a></div></li>
                    <li class="email"><div class="nav-header"><a href="javascript:;" data-src="ol_checkin.html" class="clearfix"><span>网上值机</span><i class="icon"></i></a></div></li>
                    <li class="system"><div class="nav-header"><a href="javascript:;" data-src="pwd_modify.html" class="clearfix"><span>密码修改</span><i class="icon"></i></a></div></li>
                	-->
					</ul>
				</div>
				<div class="content">

					<iframe src="index_body_right.jsp" id="iframe" width="100%"
						height="100%" frameborder="0"></iframe>
				</div>
			</div>
		</div>
	</div>
</body>
</html>