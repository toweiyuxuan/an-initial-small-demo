<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录页面</title>
	</head>
	<body>
		<form action="LoginServlet" method="post">	
			<table background="images/login1.jpg"  align="center" width="1200" height="700" border="0" cellspacing="0" cellpadding="0"">
				<tr>
					<td>
						<table width="400" height="300" border="1" cellspacing="0" cellpadding="0" style="border-color:#D9D4D0;margin-top: -100px;margin-left:550px;">
							<tr>
								<td width="100%" colspan="3" align="center">
									<font size="6" color="#DBD3D0" face="楷体">꧁推荐使用谷歌浏览器꧂</font></br>
									<font size="3" color="#DBD3D0" face="楷体">本站不允许个人注册 登录请联系站长</font>
								</td>
							</tr>
							<tr align="center">
								<td width="20%" >
									<img alt="" src="images/login2.png">
								</td>								
								<td width="80%" colspan="2">
									<font size="6" color="#DBD3D0" face="楷体">
										<b>
											魏宇轩后台管理
										</b>
									</font>
								</td>
							</tr>
							<tr align="center">
								<td class="default-td">
									<font size="5" color="#DBD3D0" face="楷体"><b>用户</b></font>
								</td>
								<td class="default-td" colspan="2">
									<input placeholder="请输入用户名" type="text" name="username" style="border:0px; width:100%;height:100%;background-color:transparent;text-align:center;font-size:15px;color:gray;font-family: 楷体;"/>
								</td>									
							</tr>
							<tr align="center">
								<td>
									<font size="5" color="#DBD3D0" face="楷体"><b>密码</b></font>
								</td>
								<td colspan="2">
									<input placeholder="请输入密码" type="password" name="password" style="border:0px;width:100%;height:100%;background-color:transparent;text-align:center;font-size:15px;color:gray;font-family: 楷体;"/>
								</td>
							</tr>
							<tr align="center">
								<td width="20%"><font size="4" color="#DBD3D0" face="楷体"><b>V2.0</b></font></td>
								<td width="40%">
									<input type="reset" name="registerbtn" value="重置" style="vertical-align:middle;width:80%;height:80%; border-color:#D9D4D0; background-color:transparent;text-align:center;font-size:16px;color:#DBD3D0;font-family: 楷体;"/>
								</td>						
								<td width="40%">
									<input type="submit" name="loginbtn" value="登录" style="vertical-align:middle;width:80%;height:80%; border-color:#D9D4D0; background-color:transparent;text-align:center;font-size:16px;color:#DBD3D0;font-family: 楷体;"/>
								</td>					
							</tr>
						</table>	
					</td>
				</tr>
			</table>	
		</form>		
	</body>
</html>