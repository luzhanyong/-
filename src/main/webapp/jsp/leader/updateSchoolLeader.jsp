<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>领导干部信息管理——修改员工</title>
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
		function modifyEmployee() {
			var name = $("#name");
			var position = $("#position");
			var sex = $("#sex");
			var nation = $("#nation");
			var nativeplc = $("#nativeplc");
			var birthday = $("#birthday");
			var worktime = $("#worktime");
			var theparty = $("#theparty");
			var postime = $("#postime");
			var educationbg = $("#educationbg");
			var degree = $("#degree");
			var graduateinst = $("#graduateinst");
			var title = $("#title");
			var msg = "";
			if ($.trim(name.val()) == ""){
				msg = "姓名不能为空！";
				name.focus();
			}else if ($.trim(position.val()) == ""){
				msg = "职务不能为空！";
				cardId.focus();
			}else if ($.trim(nation.val()) == ""){
				msg = "民族不能为空！";
				education.focus();
			}else if ($.trim(nativeplc.val()) == ""){
				msg = "籍贯不能为空！";
				email.focus();
			}else if ($.trim(worktime.val()) == ""){
				msg = "参加工作时间不能为空！";
				phone.focus();
			}else if ($.trim(theparty.val()) == ""){
				msg = "入党时间不能为空！";
				tel.focus();
			}else if ($.trim(postime.val()) == ""){
				msg = "任现职级时间不能为空！";
				party.focus();
			}else if ($.trim(educationbg.val()) == ""){
				msg = "学历不能为空！";
				qqNum.focus();
			}else if ($.trim(degree.val()) == ""){
				msg = "学位不能为空！";
				address.focus();
			}else if ($.trim(graduateinst.val()) == ""){
				msg = "毕业院校不能为空！";
				postCode.focus();
			}else if ($.trim(birthday.val()) == ""){
				msg = "出生日期不能为空！";
				birthday.focus();
			}else if ($.trim(title.val()) == ""){
				msg = "职称不能为空！";
				race.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}

			$.post("${pageContext.request.contextPath}/employee/updateSchoolLeader",$("#employeeForm").serialize(),
				function (data) {
					if (data.code == 0){
						alert("员工信息修改成功！！！");
						window.location.href = "${pageContext.request.contextPath}/toView/schoolLeader";
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
		$("#sex").val("${sessionScope.schoolLeader.sex}");
    });
	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：员工管理  &gt; 修改员工</td>
	<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
		<form action="" id="employeeForm" method="post">
			<!-- 隐藏表单，flag表示添加标记 -->
			<input type="hidden" name="flag" value="2">
			<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
				<tr><td class="font3 fftd">
					<table>
						<tr><td class="font3 fftd"><input type="hidden" name="id" id="id" size="20" value="${sessionScope.schoolLeader.id}"/></td></tr>
						<tr>

							<td class="font3 fftd">姓名：<input type="text" name="name" id="name" size="20" value="${sessionScope.schoolLeader.name}"/> </td>
							<td class="font3 fftd">职务：<input type="text" name="position" id="position" size="20" value="${sessionScope.schoolLeader.position}"/></td>
						</tr>
						<tr>
							<td class="font3 fftd">性别：
								<select id="sex" name="sex" style="width:143px;">
									<option value="0">--请选择性别--</option>
									<option value="男">男</option>
									<option value="女">女</option>
								</select></td>
							<td class="font3 fftd">民族：<input type="text" name="nation" id="nation" size="20" value="${sessionScope.schoolLeader.nation}"/></td>
						</tr>
						<tr>
							<td class="font3 fftd">籍贯：<input name="nativeplc" id="nativeplc" size="20" value="${sessionScope.schoolLeader.nativeplc}"/></td>
							<td class="font3 fftd">	出生日期：<input cssClass="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});"
																   name="birthday" id="birthday" size="40" value="${sessionScope.schoolLeader.birthday}"/>&nbsp;&nbsp;</td>
						</tr>
						<tr>
							<td class="font3 fftd">参加工作时间：<input name="worktime" id="worktime" size="20" value="${sessionScope.schoolLeader.worktime}"/></td>
							<td class="font3 fftd">入党时间：<input name="theparty" id="theparty" size="20" value="${sessionScope.schoolLeader.theparty}"/></td>
						</tr>

					</table>
				</td></tr>
				<tr><td class="main_tdbor"></td></tr>
				<tr>
					<td class="font3 fftd">
						现任职级时间：<input name="postime" id="postime" size="40" value="${sessionScope.schoolLeader.postime}"/>&nbsp;&nbsp;
						学历：<input name="educationbg" id="educationbg" size="20" value="${sessionScope.schoolLeader.educationbg}"/>
					</td>
				</tr>
				<tr><td class="main_tdbor"></td></tr>

				<tr>
					<td class="font3 fftd">
						学位：<input name="degree" id="degree" size="40" value="${sessionScope.schoolLeader.degree}"/>&nbsp;&nbsp;
						毕业院校：<input name="graduateinst" id="graduateinst" size="20" value="${sessionScope.schoolLeader.graduateinst}"/>
					</td>
				</tr>
				<tr><td class="main_tdbor"></td></tr>
				<tr>
					<td class="font3 fftd">
						职级：<input name="title" id="title" size="20" value="${sessionScope.schoolLeader.title}"/>
					</td>
				</tr>
				<tr><td class="main_tdbor"></td></tr>



				<tr>
					<td class="font3 fftd">
						备&nbsp;&nbsp;&nbsp;&nbsp;注：<input name="comm" id="comm" size="40" value="${sessionScope.schoolLeader.comm}"/>
					</td>
				</tr>
				<tr><td class="main_tdbor"></td></tr>

				<tr><td align="left" class="fftd">
					<input type="button" value="修改" onclick="modifyEmployee()">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
			</table>
		</form>
	</td>
  </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>