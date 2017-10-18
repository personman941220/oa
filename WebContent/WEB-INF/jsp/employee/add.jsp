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
<link rel="stylesheet" type="text/css" href="css/datepicker.css" />
<link rel="stylesheet" href="css/form.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/sapar.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<title>添加员工信息</title>
</head>

<body>
<script type="text/javascript">
$('select').iSelect();
</script>
	<div id="saper-container">
		<div id="saper-hd"></div>
		<div id="saper-bd">
			<div class="subfiled clearfix">
				<h2>我的信息</h2>
			</div>
			<div class="subfiled-content">
				<div class="tab-container" data-trigger="hover">
					<div class="tab">
						<a href="javascript:;" class="current">添加信息</a>
					</div>
					<div class="tab-content">
						<div class="tab-content-item">
							<form name="f1" id="f1"
								action="?m=system&amp;c=myInfo&amp;a=updateInfo&amp;type=1"
								method="post">
								<!--
                                	作者：张恭雨
                                	时间：2017-10-18
                                	描述：表单左部
                                -->
								<div id="form-left">
									<div class="kv-item clearfix">
										<label>员工姓名：</label>
										<div class="kv-item-content" style="line-height: 30px;">
											<input name="employee.name" type="text" placeholder="姓名">
										</div>
									</div>
									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>电话：</label>
										<div class="kv-item-content">
											<input name="employee.phone" type="text" placeholder="电话">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>身份证号：</label>
										<div class="kv-item-content">
											<input name="employee.idCard" type="text"
												placeholder="请输入18位身份证号">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>籍贯：</label>
										<div class="kv-item-content">
											<input name="employee.idCard" type="text" placeholder="籍贯">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>学历：</label>
										<div class="kv-item-content">
											<input name="employee.educational" type="text"
												placeholder="学历">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label><span class="impInfo">*</span>部门：</label>
										<div class="kv-item-content">
											<select name="employee.department">
												<option>选择部门</option>
												<option>模板1</option>
												<option>模板2</option>
											</select>
										</div>
									</div>

									<div class="kv-item address clearfix">
										<label><span class="impInfo">*</span>详细地址：</label>
										<div class="kv-item-content">
											<select name="addressOne">
												<option>请选择省份</option>
												<option>北京</option>
												<option>天津</option>
												<option>上海</option>
												<option>重庆</option>
											</select> <select name="addressTwo">
												<option>请选择市</option>
												<option>南京</option>
												<option>无锡</option>
												<option>苏州</option>
												<option>常州</option>
											</select> <input name="addressThree" type="text" placeholder="街道">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>入职时间：</label>
										<div class="kv-item-content time-select-wrap">
											<div class="time-select">
												<input type="text" name="employee.hireDate"
													onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
													placeholder="入职时间"> <i class="date-icon"></i>
											</div>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>邮箱：</label>
										<div class="kv-item-content">
											<input name="employee.email" type="email" placeholder="邮箱">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>原职位：</label>
										<div class="kv-item-content">
											<input name="employee.lastJob" type="text" placeholder="原职位">
										</div>
									</div>


									<div class="kv-item clearfix">
										<label>现职位：</label>
										<div class="kv-item-content">
											<input name="employee.nowJob" type="text" placeholder="原职位">
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
											<span class="choose"> <input name="employee.sex"
												type="radio" checked="true" value="男"> <span
												class="text">男</span>
											</span> <span class="choose"> <input name="employee.sex"
												type="radio" value="女"> <span class="text">女</span>
											</span>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>民族：</label>
										<div class="kv-item-content">
											<input name="employee.nation" type="text" placeholder="民族">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>出生日期：</label>
										<div class="kv-item-content time-select-wrap">
											<div class="time-select">
												<input type="text" name="employee.birthday"
													onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
													placeholder="出生日期"> <i class="date-icon"></i>
											</div>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>政治面貌：</label>
										<div class="kv-item-content">
											<input name="employee.politicsStatus" type="text"
												placeholder="政治面貌">
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>工作时间：</label>
										<div class="kv-item-content">
											<div class="kv-item-content time-select-wrap">
												<div class="time-select">
													<input type="text" name="employee.workDate"
														onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
														placeholder="工作时间"> <i class="date-icon"></i>
												</div>
											</div>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>试用日期：</label>
										<div class="kv-item-content">
											<div class="kv-item-content time-select-wrap">
												<div class="time-select">
													<input type="text" name="employee.probationPeriod"
														onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
														placeholder="试用日期"> <i class="date-icon"></i>
												</div>
											</div>
										</div>
									</div>


									<div class="kv-item clearfix">
										<label>转正日期：</label>
										<div class="kv-item-content">
											<div class="kv-item-content time-select-wrap">
												<div class="time-select">
													<input type="text" name="employee.positivePhase"
														onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
														placeholder="转正日期"> <i class="date-icon"></i>
												</div>
											</div>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>毕业时间：</label>
										<div class="kv-item-content">
											<div class="kv-item-content time-select-wrap">
												<div class="time-select">
													<input type="text" name="employee.graduationDate"
														onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
														placeholder="毕业时间"> <i class="date-icon"></i>
												</div>
											</div>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>员工状态：</label>
										<div class="kv-item-content">
											<select name="employee.status">
												<option>在职</option>
												<option>离职</option>
											</select>
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
											<textarea name="employee.familyRelationShips"
												placeholder="家庭关系"></textarea>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>社会关系：</label>
										<div class="kv-item-content">
											<textarea name="employee.socialRelations" placeholder="社会关系"></textarea>
										</div>
									</div>


								</div>

								<div id="form-button-right">
									<div class="kv-item clearfix">
										<label>个人简历：</label>
										<div class="kv-item-content">
											<textarea name="employee.resume" placeholder="个人简历"></textarea>
										</div>
									</div>

									<div class="kv-item clearfix">
										<label>备注：</label>
										<div class="kv-item-content">
											<textarea name="employee.remark" placeholder="备注"></textarea>
										</div>
									</div>

								</div>
								<div id="form-button-tijiao">
									<input type="submit"
										class="sapar-btn sapar-btn-recom query-btn" value="提交" />
								</div>
								<div class="kv-item-content">
									<input hidden="" />
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
</html>