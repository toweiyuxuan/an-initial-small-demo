<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ include file="taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>魏宇轩后台管理</title>
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
		<table border="1" align="center" width="1200" height="700" cellspacing="0" cellpadding="0" background="../images/main.jpg">
			<tr height="20%" align="center">
				<td width="10%"><img src="${image_path}${user.pic}" width="100px" height="100px"><font size="5" color="blue" face="楷体"><br/>${user.username}</font></td>
				<td width="50%">
					<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" style="border-color:transparent;">
						<tr height="25%">
							<td colspan="6" align="left"><font color="royalblue" size="3" face="楷体">&nbsp;MAYBE THAT'S LIFE</font></td>										
						</tr>
						<tr height="50%">
							<td colspan="6">
								<font size="7" color="blue" face="楷体">项目综合管理后台系统</font>
							</td>
						</tr>
						<tr height="25%" align="center">
							<td width="10%">
								<a href="main.jsp" style="text-decoration: none;"><font size="4" color="blue" face="楷体">首页</font></a>
							</td>
							<td width="10%">
								<a href="" style="text-decoration: none;"><font size="4" color="blue"  face="楷体">刷新</font></a>
							</td>
							<td width="10%">
								<a href="" style="text-decoration: none;"><font size="4" color="blue" face="楷体">前进</font></a>
							</td>
							<td width="10%">
								<a href="" style="text-decoration: none;"><font size="4" color="blue" face="楷体">后退</font></a>
							</td>
							<td width="10%">
								<a href="../LogoutServlet" style="text-decoration: none;"><font size="4" color="blue" face="楷体">注销</font></a>
							</td>
							<td width="75%"></td>											
						</tr>										
					</table>						
				</td>	
				<td width="10%" align="center">
					<iframe scrolling="no" name="calendarFrame" height="100%" width="100%" marginheight="0" marginwidth="0" frameborder="0" src="calendar.jsp">
					</iframe>
				</td>							
			</tr>
			<tr height="80%">
				<td>
					<table width="100%" height="100%" border="10" cellspacing="0" cellpadding="0" style="border-color:transparent;">
						<tr>
							<td valign="top">
								<iframe scrolling="no" name="menuFrame" height="100%" width="100%" marginheight="0" marginwidth="0" frameborder="1" src="menu.jsp">
									
								</iframe>
							</td>
						</tr>
					</table>
				</td>	
				<td colspan="2">		
					<table width="100%" height="100%" border="10" cellspacing="0" cellpadding="0" style="border-color:transparent;">
						<tr>
							<td>
								<iframe scrolling="no" name="mainFrame" height="100%" width="100%" marginheight="0" marginwidth="0" frameborder="1" src="homepage1.jsp">
								
								</iframe>
							</td>
						</tr>
					</table>
				</td>								
			</tr>
		</table>
	</body>
</html>