<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改页面</title>
	</head>
	<body>
		<form action="${rpath}/UpdateServlet" method="post" enctype="multipart/form-data">
			<table width="756" height="268"  border="2" cellspacing="0" cellpadding="0" align="center" bordercolor="skyblue"  style="border-collapse: collapse; margin-top:100px;">							
				<tr align="left" height="16%"> 
					<td width="100%" colspan="3">
						<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" bordercolor="skyblue">
							<tr>
								<td width="5%" align="center"><img src="${rpath}/images/tb.gif" width="17" height="17"/></td>
								<td width="60%" align="left"><font size="" color="gray" face="楷体">[业务中心]-[用户资料]-[修改]</font></td>
								<td width="35%" align="right">
									<font size="" color="gray" face="楷体">
										<input type="button" value="取消" onclick="window.history.back()" style="width:20%;height:60%;background-color:transparent;border:1;color:gray;font-size:15px;text-align:center;font-family:楷体;">
										<input type="reset" value="重置" style="width:20%;height:60%;background-color:transparent;border:1;color:gray;font-size:15px;text-align:center;font-family:楷体;">
										<input type="submit" value="提交" style="width:20%;height:60%;background-color:transparent;border:1;color:gray;font-size:15px;text-align:center;font-family:楷体;">&nbsp;
									</font>
								</td>
							</tr>
						</table>
					</td>		
				</tr>		
				<tr align="center" height="12%">
					<td rowspan="7" width="40%"><img src="${rpath}/images/toupdate.jpg" width="300" height="222" align="center"/></td>
					<td width="20%"><font size="4" color="blue" face="楷体">头像</font></td>
					<td width="40%">
						<input type="hidden" value="${user.userId }" name="userId">
						<input type="hidden" type="text" name="StartPic" value="${user.pic}">
						<input type="file" name="pic" style="width:100%;height:80%;background-color:transparent;border:0;color:blue;font-size:15px;text-align:center;font-family:楷体;"/>	
					</td>				
				</tr>
				<tr align="center" height="12%">
					<td><font size="4" color="blue" face="楷体">用户</font></td>
					<td><input maxlength="8" type="text" name="username" required="required" value="${user.username}" style="width:100%;height:100%;background-color:transparent;border:0;color:blue;font-size:15px;text-align:center;text-align:center;font-family:楷体;"/></td>
				</tr>
				<tr align="center" height="12%">
					<td><font size="4" color="blue" face="楷体">密码</font></td>
					<td><input type="text" name="password" value="${user.password }" style="width:100%;height:100%;background-color:transparent;border:0;color:blue;font-size:15px;text-align:center;text-align:center;font-family:楷体;"/></td>
				</tr>
				<tr align="center" height="12%">
					<td><font size="4" color="blue" face="楷体">性别</font></td>
					<td>
						<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">					
							<tr>
								<td width="25%" align="right">			
									<input type="radio" name="gender"<c:if test="${user.gender == 1}">checked</c:if> value="1" style="width:50%;height:80%;"/>
								</td>
								<td width="25%" align="left">			
									<font size="3" color="blue" face="楷体">男</font>
								</td>
								<td width="25%" align="right">
									<input type="radio" name="gender" <c:if test="${user.gender == 0 }">checked</c:if> value="0" style="width:50%;height:80%;"/>		
								</td>
								<td width="25%" align="left">
									<font size="3" color="blue" face="楷体">女</font>		
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr align="center" height="12%">
					<td><font size="4" color="blue" face="楷体">生日</font></td>
					<td><input type="date" name="birthday" value="${user.birthday }" style="width:100%;height:100%;background-color:transparent;border:0;color:blue;font-size:15px;text-align:center;font-family:楷体;"/></td>
				</tr>
				<tr align="center" height="12%">
					<td><font size="4" color="blue" face="楷体">工资</font></td>
					<td><input maxlength="7" type="number" min="0" step="1" name="sal" value="${user.sal}" style="width:100%;height:100%;background-color:transparent;border:0;color:blue;font-size:15px;text-align:center;font-family:楷体;"/></td>
				</tr>
				<tr align="center" height="12%">
					<td><font size="4" color="blue" face="楷体">邮箱</font></td>
					<td><input maxlength="17" type="email" name="email" value="${user.email}" style="width:100%;height:100%;background-color:transparent;border:0;color:blue;font-size:15px;text-align:center;font-family:楷体;"/></td>		
				</tr>
			</table>
		</form>
	</body>
</html>
