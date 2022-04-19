<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="xsk" uri="http://xsk.pager-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>领导干部信息管理 ——校级领导信息管理</title>
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
	    					   // alert("删除："+ids.get());
	    					   // 发送请求
	    					   //window.location = "${pageContext.request.contextPath}/employee/removeEmployee?ids=" + ids.get();
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
		<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：领导信息管理 &gt; 校级领导信息管理</td>
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
					  <form id="updateForm" action="${pageContext.request.contextPath }/employee/fileUploadXexcel" method="post" enctype="multipart/form-data">
						  选择excel：<input   type="file" name="xexcel">
						  <input style="background-color: #FFC0CB;" type="submit" value="excel导入">
					  </form>
				  </td>
				  <td class="font3">
					  <form action="${pageContext.request.contextPath }/employee/fileDownloadXexcel" method="get">
						  <input style="background-color: #FFC0CB;" type="submit" value="导出数据">
					  </form>
				  </td>
			  </tr>
			  <tr>
					    <td class="font3">
					    	姓名：<input type="text" name="name" v-model="name">
							<input style="background-color: #FFC0CB;" type="submit" v-on:click="findAllSchoolLeaderByName" value="搜索"/>
					    </td>
						  <td class="font3">
						  </td>
			  </tr>
			  </td>
			</tr>
		  </table>
		</td>
	  </tr>
	  
	  <!-- 数据展示区 -->
	  <tr valign="top">
	    <td height="20">
		  <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		    <tr class="main_trbg_tit" align="center">
			  <th><input type="checkbox" name="checkAll" id="checkAll"></th>
			  <th>姓名</th>
			  <th>职务</th>
			  <th>性别</th>
			  <th>民族</th>
			  <th>籍贯</th>
			  <th>出生年月</th>
			  <th>参加工作时间</th>
			  <th>入党时间</th>
			  <th>任现职级时间</th>
			  <th>学历</th>
			  <th>学位</th>
			  <th>毕业院校</th>
			  <th>职称</th>
			  <th>备注</th>
			  <th align="center">操作</th>
			</tr>
			  <tr v-for="SchoolLeader in SchoolLeaders">
				  <td><input type="checkbox" id="box_${stat.index}" value="${employee.id}">{{SchoolLeader.id}}</td>
						 <td>{{SchoolLeader.name }}</td>
						  <td>{{SchoolLeader.position}}</td>
						  <td>{{SchoolLeader.sex }}</td>
						  <td>{{SchoolLeader.nation }}</td>
						  <td>{{SchoolLeader.nativeplc }}</td>
						  <td>{{SchoolLeader.birthday }}</td>
						  <td>{{SchoolLeader.worktime }}</td>
						  <td>{{SchoolLeader.theparty }}</td>
						  <td>{{SchoolLeader.postime }}</td>
						  <td>{{SchoolLeader.educationbg }}</td>
						  <td>{{SchoolLeader.degree }}</td>
						  <td>{{SchoolLeader.graduateinst }}</td>
						  <td>{{SchoolLeader.title }}</td>
						  <td>{{SchoolLeader.comm }}</td>
<%--				  v-bind:href="['${pageContext.request.contextPath}/toView/'+SchoolLeader.id]">{{ article.title }}--%>
				  		 <td><a v-bind:href="['${pageContext.request.contextPath}/employee/findSchoolLeaderById/'+SchoolLeader.id]" target="main"><button name="">编辑</button></a>
							 <a v-bind:href="['${pageContext.request.contextPath}/employee/deleteSchoolLeaderById/'+SchoolLeader.id]" target="main" ><button name="">删除</button></a></td>
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
			SchoolLeaders:[],
			name:'',
		},
		mounted:function (){
			this.findAllSchoolLeader();
		},
		methods:{
			findAllSchoolLeader(){
				axios.get('/LeaderManger/employee/findSchoolleader')
						.then((response) => {
							console.log(response.data)
							for (i=0;i<response.data.length;i++){
								this.SchoolLeaders.push(response.data[i])
							}
						})
						.catch((error) => {
							console.log(error);
						});
			},
			findAllSchoolLeaderByName(){
				axios.post('/LeaderManger/employee/findSchoolLeaderByName',{
							name : this.name
						})
						.then((response) => {
							this.SchoolLeaders=response.data
						})
						.catch((error) => {
							console.log(error);
						});
			},

			updataSchoolLeader(){
				axios.post('/LeaderManger/employee/updataSchoolLeader')
						.then((response) => {
							for (i=0;i<response.data.length;i++){
								this.SchoolLeaders.push(response.data[i])
							}
						})
						.catch((error) => {
							console.log(error);
						});
			},
		}
	})
</script>
</html>