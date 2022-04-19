<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>领导干部信息管理——修改科级领导信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${pageContext.request.contextPath}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/css/pager.css" type="text/css" rel="stylesheet" />
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function updateEmployee() {
			var name = $("#name");
			var position = $("#position");
			var sex = $("#sex");
			var nation = $("#nation");
			var nativeplc = $("#nativeplc");
			var worktime = $("#worktime");
			var theparty = $("#theparty");
			var zctime = $("#zctime");
			var fctime = $("#fctime");
			var birthday = $("#birthday");
			var postime = $("#postime");
			var q_educationbg = $("#q_educationbg");
			var q_degree = $("#q_degree");
			var q_graduateinst = $("#q_graduateinst");
			var z_educationbg = $("#z_educationbg");
			var z_degree = $("#z_degree");
			var z_graduateinst = $("#z_graduateinst");
			var title = $("#title");
			var msg = "";
			if ($.trim(name.val()) == ""){
				msg = "姓名不能为空！";
				name.focus();
			}else if ($.trim(position.val()) == ""){
				msg = "职务不能为空！";
				position.focus();
			}else if ($.trim(nation.val()) == ""){
				msg = "民族不能为空！";
				nation.focus();
			}else if ($.trim(nativeplc.val()) == ""){
				msg = "籍贯不能为空！";
				nativeplc.focus();
			}else if ($.trim(q_educationbg.val()) == ""){
				msg = "全日制学历不能为空！";
				q_educationbg.focus();
			}else if ($.trim(q_degree.val()) == ""){
				msg = "全日制学位不能为空！";
				q_degree.focus();
			}else if ($.trim(q_graduateinst.val()) == ""){
				msg = "全日制毕业院校专业不能为空！";
				q_graduateinst.focus();
			}else if ($.trim(z_degree.val()) == ""){
				msg = "在职学位不能为空！";
				z_degree.focus();
			}else if ($.trim(z_graduateinst.val()) == "") {
				msg = "在职毕业院校专业不能为空！";
				z_graduateinst.focus();
			}
			else if ($.trim(z_educationbg.val()) == ""){
				msg = "在职学历不能为空！";
				q_educationbg.focus();
			}else if ($.trim(title.val()) == ""){
				msg = "职称不能为空！";
				title.focus();


			}else if ($.trim(birthday.val()) == ""){
				msg = "出生日期不能为空！";
				birthday.focus();
			}else if ($.trim(worktime.val()) == ""){
				msg = "参加工作时间不能为空！";
				worktime.focus();

			}else if ($.trim(theparty.val()) == ""){
				msg = "入党时间不能为空！";
				theparty.focus();

			}else if ($.trim(zctime.val()) == ""){
				msg = "任副科时间不能为空！";
				zctime.focus();
			}else if ($.trim(fctime.val()) == ""){
				msg = "任正科时间不能为空！";
				fctime.focus();
			}else if ($.trim(postime.val()) == ""){
				msg = "任现职时间不能为空！";
				postime.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}

			$.post("${pageContext.request.contextPath}/employee/updateSchoolkeLeader",$("#employeeForm").serialize(),
					function (data) {
						console.log(data)
						if (data.code == 0){
							alert("员工信息修改成功！！！");
							window.location.href = "${pageContext.request.contextPath}/toView/schoolkeLeader";
						}
						else {
							alert("员工信息修改失败！");
							window.location.reload();
						}
					}
			);
		}
		$(function(){
			// 控制文档加载完成以后 选中性别
			$("#sex").val("${schoolkeLeader.sex}");
		});
	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="10"></td></tr>
	<tr>
		<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：领导信息管理  &gt; 修改科技级领导信息</td>
		<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
	</tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
	<tr valign="top">
		<td>
			<form action="" id="employeeForm" method="post">
				<!-- 隐藏表单，flag表示添加标记 -->
				<input type="hidden" name="flag" value="2">
				<input type="hidden" name="id" value="${schoolkeLeader.id }">
				<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
					<tr><td class="font3 fftd">
						<table>
							<tr>
								<td class="font3 fftd">姓名：<input type="text" name="name" id="name" size="20" value="${schoolkeLeader.name }"/></td>
								<td class="font3 fftd">职务：<input type="text" name="position" id="position" size="20" value="${schoolkeLeader.position }"/></td>
							</tr>
							<tr>
								<td class="font3 fftd">性别：
									<select  id="sex" name="sex" style="width:143px;">
										<option value="0">--请选择性别--</option>
										<option value="男">男</option>
										<option value="女">女</option>
									</select></td>
								<td class="font3 fftd">民族：<input type="text" name="nation" id="nation" size="20" value="${schoolkeLeader.nation }"/></td>
							</tr>
							<tr>
								<td class="font3 fftd">籍贯：<input name="nativeplc" id="nativeplc" size="20" value="${schoolkeLeader.nativeplc }"/></td>
								<td class="font3 fftd">出生日期：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});"
																   name="birthday" id="birthday" size="40" value="${schoolkeLeader.birthday }"/>&nbsp;&nbsp;</td>
							</tr>
							<tr>
								<td class="font3 fftd">参加工作时间：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});"
																	 name="worktime" id="worktime" size="40" value="${schoolkeLeader.worktime }"/>&nbsp;&nbsp;</td>
								<td class="font3 fftd">入党时间：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});"
																   name="theparty" id="theparty" size="40" value="${schoolkeLeader.theparty }"/>&nbsp;&nbsp;</td>
							<tr>
								<td class="font3 fftd">任副科时间：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});"
																	name="zctime" id="zctime" size="40" value="${schoolkeLeader.zctime }"/>&nbsp;&nbsp;</td>
								<td class="font3 fftd">任正科时间：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});"
																	name="fctime" id="fctime" size="40" value="${schoolkeLeader.fctime }"/>&nbsp;&nbsp;</td></tr><tr>
							<td class="font3 fftd">任现职时间：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});"
																name="postime" id="postime" size="40" value="${schoolkeLeader.postime }"/>&nbsp;&nbsp;</td></tr>
							</tr>


						</table>
					</td></tr>
					<tr><td class="main_tdbor"></td></tr>
					<tr>

						<td class="font3 fftd"><div>全日制</div>
							学历：<input name="q_educationbg" id="q_educationbg" size="10" value="${schoolkeLeader.q_educationbg }"/>&nbsp;&nbsp;
							学位：<input  name="q_degree" id="q_degree" size="10" value="${schoolkeLeader.q_degree }"/>&nbsp;&nbsp;
							毕业院校专业：<input  name="q_graduateinst" id="q_graduateinst" size="20" value="${schoolkeLeader.q_graduateinst }"/>&nbsp;&nbsp;
						</td>
					</tr>
					<tr><td class="main_tdbor"></td></tr>

					<tr>

						<td class="font3 fftd"><div>在职</div>
							学历：<input name="z_educationbg" id="z_educationbg" size="10" value="${schoolkeLeader.z_educationbg }"/>&nbsp;&nbsp;
							学位：<input  name="z_degree" id="z_degree" size="10" value="${schoolkeLeader.z_degree }"/>&nbsp;&nbsp;
							毕业院校专业：<input  name="z_graduateinst" id="z_graduateinst" size="20" value="${schoolkeLeader.z_graduateinst }"/>&nbsp;&nbsp;
						</td>
					</tr>
					<tr><td class="main_tdbor"></td></tr>
					<tr>
						<td class="font3 fftd">
							职称：<input name="title" id="title" size="10" value="${schoolkeLeader.title }"/>
							备注：<input name="comm" id="comm" size="40" value="${schoolkeLeader.comm }"/>

						</td>
					</tr>
					<tr><td class="main_tdbor"></td></tr>
					<tr><td align="left" class="fftd">
						<input type="button" value="修改" onclick="updateEmployee()">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
				</table>
			</form>
		</td>
	</tr>
</table>
<div style="height:10px;"></div>
</body>
</html>