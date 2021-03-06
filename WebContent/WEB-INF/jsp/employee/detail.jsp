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
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/sapar.css" />
<link rel="stylesheet" type="text/css" href="css/my_info.css" />
<link rel="stylesheet" href="css/form.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<title>我的资料信息</title>
</head>
<body>
    <div id="saper-container">
        <div id="saper-hd"></div>
        <div id="saper-bd">
            <div class="subfiled clearfix">
                <h2>我的资料</h2>
            </div>
            <div class="subfiled-content">
                <div class="tab-container" data-trigger="hover">
                    <div class="tab">
                        <a href="javascript:;" class="current">基本信息</a>                        
                    </div>
                    <div class="tab-content">
                        <div class="tab-content-item">
                            <form name="f1" id="f1" action="?m=system&amp;c=myInfo&amp;a=updateInfo&amp;type=1" method="post">
                            	<!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单左部
                                -->
                            	<div id="form-left">                            		
	                                <div class="kv-item clearfix">
	                                    <label>员工姓名：</label>
	                                    <div class="kv-item-content" style="line-height:30px;">
	                                        Madina
	                                    </div>
	                                </div>
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>电话：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.phone" type="text" placeholder="电话" readonly="readonly">
	                                    </div>
	                                </div>
	
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>身份证号：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.idCard" type="text" placeholder="请输入18位身份证号" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>籍贯：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.idCard" type="text" placeholder="籍贯" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>学历：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.educational" type="text" placeholder="学历" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>部门：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.department" type="text" placeholder="部门" readonly="readonly">
	                                    </div>
	                                </div>
	
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>居住地址：</label>
	                                    <div class="kv-item-content">
	                                        <textarea name="address" placeholder="地址" readonly="readonly"></textarea>
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>入职时间：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.hireDate" type="text" placeholder="入职时间" readonly="readonly">
	                                    </div>
	                                </div>
	
	                                <div class="kv-item clearfix">
	                                    <label>邮箱：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.email" type="email" placeholder="邮箱" readonly="readonly">
	                                    </div>
	                                </div>
	
	                                <div class="kv-item clearfix">
	                                    <label>原职位：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.lastJob" type="text" placeholder="原职位" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	
	                                <div class="kv-item clearfix">
	                                    <label>现职位：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.nowJob" type="text" placeholder="原职位" readonly="readonly">
	                                    </div>
	                                </div>
                            	</div>
                            	<!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单右部
                                -->
								<div id="form-rigth">		
									
	                                
	
	                                <div class="kv-item clearfix">
	                                    <label><span class="impInfo">*</span>性别：</label>
	                                    <div class="kv-item-content">
	                                        <span class="choose">
	                                            <input name="employee.sex" type="radio" checked="true" value="男">
	                                            <span class="text">男</span>
	                                        </span>
	                                        <span class="choose">
	                                            <input name="employee.sex" type="radio" value="女">
	                                            <span class="text">女</span>
	                                        </span>                                        
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>民族：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.nation" type="text" placeholder="民族" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>出生日期：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.birthday" type="text" placeholder="出生日期" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>政治面貌：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.politicsStatus" type="text" placeholder="政治面貌" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>工作时间：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.workDate" type="text" placeholder="工作时间" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>试用日期：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.probationPeriod" type="text" placeholder="工作时间" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>试用日期：</label>
	                                    <div class="kv-item-content">
	                                        <input name="employee.probationPeriod" type="text" placeholder="试用日期" readonly="readonly">
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>转正日期：</label>
	                                    <div class="kv-item-content">
	                                    	<input name="employee.positivePhase" type="text" placeholder="转正日期" readonly="readonly">	                                        
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>毕业时间：</label>
	                                    <div class="kv-item-content">
	                                    	<input name="employee.graduationDate" type="text" placeholder="转正日期" readonly="readonly">
	                                        
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>员工状态：</label>
	                                    <div class="kv-item-content">
	                                        <input type="text" name="employee.status" placeholder="员工状态" readonly="readonly"/>
	                                    </div>
	                                </div>
								</div>
                                <!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单底部
                                -->
                                <div id="form-button-left">
	                                <div class="kv-item clearfix">
	                                    <label>家庭关系：</label>
	                                    <div class="kv-item-content">
	                                        <textarea name="employee.familyRelationShips" placeholder="家庭关系" readonly="readonly"></textarea>
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>社会关系：</label>
	                                    <div class="kv-item-content">
	                                        <textarea name="employee.socialRelations" placeholder="社会关系" readonly="readonly"></textarea>
	                                    </div>
	                                </div>
	                                
	                                                            	
                                </div>
                                
                                <div id="form-button-right">
                                	<div class="kv-item clearfix">
	                                    <label>个人简历：</label>
	                                    <div class="kv-item-content">
	                                        <textarea name="employee.resume" placeholder="个人简历" readonly="readonly"></textarea>
	                                    </div>
	                                </div>
	                                
	                                <div class="kv-item clearfix">
	                                    <label>备注：</label>
	                                    <div class="kv-item-content">
	                                        <textarea name="employee.remark" placeholder="备注" readonly="readonly"></textarea>
	                                    </div>
	                                </div>    
                                	
                                </div>                                
                            </form>
                        </div>                       
                      </div>                       
                    </div>
                </div>
            </div>
        </div>
        <div id="saper-ft"></div>
    </div>
    
</body>

<script type="text/javascript">
$('select').iSelect();
</script>
</html>