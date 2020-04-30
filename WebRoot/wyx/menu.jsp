<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/SimpleTree.css"/>
<script type="text/javascript" src="../js/jquery-1.4.min.js"></script>
<script type="text/javascript" src="../js/SimpleTree.js"></script>
<script type="text/javascript">
$(function(){

	$(".st_tree").SimpleTree({
	
		/* 可无视代码部分*/
		click:function(a){
			if(!$(a).attr("hasChild"))
				alert($(a).attr("ref"));
		}
		
	});
	
});
</script>
</head>
<body>
<div class="st_tree" style="width:400px;margin:0 auto;">
	<ul>
		<li><a href="homepage.jsp" target="mainFrame">本站简介</a></li>
		<li><a href="#">业务中心</a></li>
		<ul show="true">
			<li><a href="../QueryServlet" target="mainFrame">用户资料</a></li>
			<li><a href="#">预留位置</a></li>
		</ul>
		<li><a href="#">工程项目</a></li>
		<ul show="true">
			<li><a href="#">预留位置</a></li>
			<li><a href="#">预留位置</a></li>
			<li><a href="#">预留位置</a></li>
		</ul>
		<li><a href="#">网站管理</a></li>
		<ul show="true">
			<li><a href="#">预留位置</a></li>
			<li><a href="#">预留位置</a></li>
			<li><a href="#">预留位置</a></li>
		</ul>
	</ul>
</div>
</body>
</html>