<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="xsk" uri="http://xsk.pager-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>领导干部信息管理 ——科级领导信息管理</title>
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
	<!-- 引入vue       -->
	<script src="${pageContext.request.contextPath}/js/vue.js"></script>
	<script type="text/javascript">
		$(function(){
			/** 获取上一次选中的部门数据 */
			var boxs  = $("input[type='checkbox'][id^='box_']");

			/** 给全选按钮绑定点击事件  */
			$("#checkAll").click(function(){
				// this是checkAll  this.checked是true
				// 所有数据行的选中状态与全选的状态一致
				boxs.attr("checked",this.checked);
			})

			/** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
			$("tr[id^='data_']").hover(function(){
				$(this).css("backgroundColor","#eeccff");
			},function(){
				$(this).css("backgroundColor","#ffffff");
			})

			//form表单返回数据
			$(function () {
				$("#updateForm").ajaxForm(function (data) {
							console.log(data);
						}
				);
			});

			/** 删除员工绑定点击事件 */
			$("#delete").click(function(){
				/** 获取到用户选中的复选框  */
				var checkedBoxs = boxs.filter(":checked");
				if(checkedBoxs.length < 1){
					$.ligerDialog.error("请选择一个需要删除的员工！");
				}else{
					/** 得到用户选中的所有的需要删除的ids */
					var ids = checkedBoxs.map(function(){
						return this.value;
					})

					$.ligerDialog.confirm("确认要删除吗?","删除员工",function(r){
						if(r){
							alert("删除："+ids.get());
							发送请求
							window.location = "${pageContext.request.contextPath}/employee/removeEmployee?ids=" + ids.get();
							$.get("${pageContext.request.contextPath}/employee/removeEmployee?ids="+ids.get(),
									function (data) {
										if (data == "OK"){
											alert("选中员工删除成功！！！");
											window.location.href = "${pageContext.request.contextPath}/employee/findEmployee";
										}else {
											alert("选中员工删除失败！");
											window.location.reload();
										}
									});
						}
					});
				}
			})
		})
	</script>
</head>
<body>
<div id="app">
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr><td height="10"></td></tr>
		<tr>
			<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
			<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：领导信息管理 &gt; 科级领导信息管理</td>
			<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
		</tr>
	</table>

	<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
		<!-- 查询区  -->
		<tr valign="top">
			<td height="30">
				<table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
					<tr>
						<td class="fftd">
								<tr>
									<td class="font3">
										<form id="updateForm" action="${pageContext.request.contextPath }/employee/fileUploadKexcel" method="post" enctype="multipart/form-data">
											选择excel：<input   type="file" name="kexcel">
											<input style="background-color: #FFC0CB;" type="submit" value="excel导入">
										</form>
									</td>
									<td class="font3">
										<form action="${pageContext.request.contextPath }/employee/fileDownloadKexcel" method="get">
											<input style="background-color: #FFC0CB;" type="submit" value="导出数据">
										</form>
									</td>
								</tr>
								<tr>
									<td class="font3">
										姓名：<input type="text" name="name" v-model="name">
										<input style="background-color: #FFC0CB;"  type="submit" v-on:click="findAllSchoolkeLeaderByName" value="搜索"/>
									</td>
								</tr>
								<tr>
									<td class="font3">
									</td>
								</tr>
						</td>
					</tr>
				</table>
			</td>
		</tr>

		<tr valign="top">
			<td height="20">
				<table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
					<tr class="main_trbg_tit" align="center">
						<th rowspan="2"><input type="checkbox" name="checkAll" id="checkAll"></th>
						<th rowspan="2">姓名</th>
						<th rowspan="2">职务</th>
						<th rowspan="2">性别</th>
						<th rowspan="2">民族</th>
						<th rowspan="2">籍贯</th>
						<th rowspan="2">出生年月</th>
						<th rowspan="2">参加工作时间</th>
						<th rowspan="2">入党时间</th>
						<th rowspan="2">任副科时间</th>
						<th rowspan="2">任正科时间</th>
						<th rowspan="2">任现职级时间</th>
						<th colspan="3">全日制</th>
						<th colspan="3">在职</th>
						<td rowspan="2">职称</td>
						<td rowspan="2">备注</td>
						<td align="center" rowspan="2">操作</td>
					</tr>
					<tr>
						<td>学历</td>
						<td>学位</td>
						<td>毕业院校</td>
						<td>学历</td>
						<td>学位</td>
						<td>毕业院校</td>
					</tr>
					<tr v-for="SchoolkeLeader in SchoolkeLeaders">
						<td><input type="checkbox" id="box_${stat.index}" value="${employee.id}">{{SchoolkeLeader.id}}</td>
						<td>{{SchoolkeLeader.name }}</td>
						<td>{{SchoolkeLeader.position}}</td>
						<td>{{SchoolkeLeader.sex }}</td>
						<td>{{SchoolkeLeader.nation }}</td>
						<td>{{SchoolkeLeader.nativeplc }}</td>
						<td>{{SchoolkeLeader.birthday }}</td>
						<td>{{SchoolkeLeader.worktime }}</td>
						<td>{{SchoolkeLeader.theparty }}</td>
						<td>{{SchoolkeLeader.zktime }}</td>
						<td>{{SchoolkeLeader.fktime }}</td>
						<td>{{SchoolkeLeader.postime }}</td>
						<td>{{SchoolkeLeader.q_educationbg }}</td>
						<td>{{SchoolkeLeader.q_degree }}</td>
						<td>{{SchoolkeLeader.q_graduateinst }}</td>
						<td>{{SchoolkeLeader.z_educationbg }}</td>
						<td>{{SchoolkeLeader.z_degree }}</td>
						<td>{{SchoolkeLeader.z_graduateinst }}</td>
						<td>{{SchoolkeLeader.title }}</td>
						<td>{{SchoolkeLeader.comm }}</td>
						<%--				  v-bind:href="['${pageContext.request.contextPath}/toView/'+SchoolLeader.id]">{{ article.title }}--%>
						<td><a v-bind:href="['${pageContext.request.contextPath}/employee/findSchoolkeLeaderById/'+SchoolkeLeader.id]" target="main"><button name="">编辑</button></a>
							<a v-bind:href="['${pageContext.request.contextPath}/employee/deleteSchoolkeLeaderById/'+SchoolkeLeader.id]" target="main" ><button name="">删除</button></a></td>
					</tr>
				</table>
			</td>
		</tr>
		<!-- 分页标签 -->
		<tr valign="top"></tr>
	</table>
	<div style="height:10px;"></div>
</div>

<!-- 引入axios   -->
</body>
<script src="${pageContext.request.contextPath}/js/axios.min.js"></script>
<script>
	new Vue({
		el:'#app',
		data:{
			SchoolkeLeaders:[],
			name:'',
		},
		mounted:function (){
			this.findAllSchoolkeLeader();
		},
		methods:{
			findAllSchoolkeLeader(){
				axios.get('/LeaderManger/employee/findSchoolkeleader')
						.then((response) => {
							for (i=0;i<response.data.length;i++){
								this.SchoolkeLeaders.push(response.data[i])
							}
						})
						.catch((error) => {
							console.log(error);
						});
			},
			findAllSchoolkeLeaderByName(){
				axios.post('/LeaderManger/employee/findSchoolkeLeaderByName',{
					name : this.name
				})
						.then((response) => {
							this.SchoolkeLeaders=response.data
						})
						.catch((error) => {
							console.log(error);
						});
			},

		}
	})
</script>
</html>