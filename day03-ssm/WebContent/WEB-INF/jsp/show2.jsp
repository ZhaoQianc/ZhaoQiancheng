<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"  src="${pageContext.request.contextPath}/js/vue.js"> </script>
<script type="text/javascript"  src="${pageContext.request.contextPath}/js/axios-0.18.0.js"> </script>
<style>
	.show{
	display:black
	}
	.hidden{
	display:none
	}
</style>
</head>
<body>
<a href="${pageContext.request.contextPath}/stu/toadd.action">添加</a>
<div id="did">
<table id="tid" border="1" :class="flag2">
	<tr>
		<td>多选</td>
		<td>编号</td>
		<td>姓名</td>
		<td>性别</td>
		<td>照片</td>
		<td>生日</td>
		<td>班级</td>
		<td>操作</td>
	</tr>
	<tr v-for="(stu,index) in slist">
		<td><input type="checkbox" v-model="ids" :value="stu.id"> </td>
		<td v-text="stu.id"></td>
		<td v-text="stu.name">姓名</td>
		<td v-text="stu.sex">性别</td>
		<td>照片</td>
		<td v-text="format(stu.sr)"></td>
		<td v-text="stu.clazz.cname"></td>
		<td><input type="button" @click="toUpdate(index)" value="修改"></td>
	</tr>
</table>
<input type="button" @click="del" value="删除">
<!--  -->
<form action="" id="fid" :class="flag">
<input type="hidden" v-model="stu.id">
	姓名:<input type="text" v-model="stu.name"><br/>
	性别:<input type="radio" value="男" v-model="stu.sex">  男
		<input type="radio" value="女" v-model="stu.sex">  女<br/>
	图片:<input type="file" ><br/>
	生日:<input type="date" v-model = "stu.sr" ><br/>
	班级: <select v-model="stu.cid">
		<option v-for="clazz in clist" :value="clazz.cid" v-text = "clazz.cname"></option>
	</select><br/> 
	<input type="button" @click="update" value="修改">
</form>
</div>
<script type="text/javascript">
	var table= new Vue({
		el:"#did",
		data:{
			slist:[],
			stu:{},
			clist:[],
			flag:'hidden',
			flag2:'show',
			ids:[]
		},
		created(){
			axios.post("${pageContext.request.contextPath}/stu/toshow.action").then(function(res){
				table.slist = res.data;		
			});
			axios.post("${pageContext.request.contextPath}/stu/findClazz.action").then(function(res){
				table.clist=res.data;
			})
			},
		methods:{
			format(datetime){
				var year = new Date(datetime).getFullYear();
				var month1= new Date(datetime).getMonth()+1;
				var month = month1<10?"0"+month1:month1;
				var date = new Date(datetime).getDate()<10?"0"+new Date(datetime).getDate():new Date(datetime).getDate();
				return  year+"-"+month+"-"+date
			},
			toUpdate(i){
				this.stu=this.slist[i];
				this.stu.sr=this.format(this.stu.sr);
				this.flag="show"
				this.flag2="hidden"
			},
			update(){
				axios.post("${pageContext.request.contextPath}/stu/updateStu.action",table.stu).then(function(res){
					if(res.data>0){
						table.flag="hidden",
						table.flag2="show",
						location.href="${pageContext.request.contextPath}/stu/findall.action" ;
					};
				})
			},
			del(){
				axios.post("${pageContext.request.contextPath}/stu/delStu.action",this.ids).then(function(res){
					if(res.data>0){
						location.href="${pageContext.request.contextPath}/stu/findall.action" ;	
					};
				})
			}
		}
	})
</script>
</body>
</html>