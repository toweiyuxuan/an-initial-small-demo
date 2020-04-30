<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp"%>
<%@ page language="java" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script>
			var highlightcolor='skyblue';
			//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
			var clickcolor='Pink';
			function  changeto()
			{
				source=event.srcElement;
				if  (source.tagName=="TR"||source.tagName=="TABLE")
				return;
				while(source.tagName!="TD")
				source=source.parentElement;
				source=source.parentElement;
				cs  =  source.children;
				//alert(cs.length);
				if(cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
				for(i=0;i<cs.length;i++)
				{
					cs[i].style.backgroundColor=highlightcolor;
				}
			}
			
			function changeback()
			{
				if(event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
				return;
				if(event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
				//source.style.backgroundColor=originalcolor
				for(i=0;i<cs.length;i++)
				{
					cs[i].style.backgroundColor="";
				}
			}
			
			function  clickto()
			{
				source=event.srcElement;
				if(source.tagName=="TR"||source.tagName=="TABLE")
				return;
				while(source.tagName!="TD")
				source=source.parentElement;
				source=source.parentElement;
				cs  =  source.children;
				//alert(cs.length);
				if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
				for(i=0;i<cs.length;i++)
				{
					cs[i].style.backgroundColor=clickcolor;
				}
				else
				for(i=0;i<cs.length;i++)
				{
					cs[i].style.backgroundColor="";
				}
			}
		</script>			
	</head>
	<body>
		<table align="left" width="1006" height="530" border="1" cellspacing="0" cellpadding="0" style="border-color:skyblue;border-collapse:collapse;">						
			<tr height="50px">
				<td colspan="9">
					<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" style="border-color:skyblue;border-collapse:inherit;">
						<tr>  
							 <td width="4%" align="center"><img src="${rpath}/images/tb.gif"/></td>
							 <td width="81%" align="left"><font size="" color="gray" face="楷体">[业务中心]-[用户资料]</font>
							 <td width="15%" align="center">
							 	<img src="${rpath}/images/22.gif"/>
							 	<font size="" color="gray" face="楷体">
							 		<a name="addbtn" href="${rpath}/wyx/toAdd.jsp" style="text-decoration: none;">新增</a>
							 	</font>
							 </td>
						</tr>
					</table>	
				</td>
			</tr>
			<tr>
				<td colspan="9">
					<table width="100%" height="100%" border="1" cellspacing="0" cellpadding="0" style="border-color:skyblue;border-collapse:inherit;" onmouseover="changeto()"  onmouseout="changeback()">
						<tr height="29" align="center">
							<th width="6%" style="min-width:50px;"><font size="" color="blue" face="楷体">序号</font></th>
							<th width="10%" style="min-width:50px;"><font size="" color="blue" face="楷体">头像</font></th>
							<th width="10%" style="min-width:50px;"><font size="" color="blue" face="楷体">用户</font></th>
							<th width="10%" style="min-width:50px;"><font size="" color="blue" face="楷体">密码</font></th>
							<th width="7%" style="min-width:50px;"><font size="" color="blue" face="楷体">性别</font></th>
							<th width="13%" style="min-width:50px;"><font size="" color="blue" face="楷体">生日</font></th>
							<th width="10%" style="min-width:50px;"><font size="" color="blue" face="楷体">工资</font></th>
							<th width="20%" style="min-width:50px;"><font size="" color="blue" face="楷体">邮箱</font></th>
							<th width="10%" style="min-width:50px;"><font size="" color="blue" face="楷体">操作</font></th>
						</tr>
						<c:forEach items="${userList}" var="user">
							<tr align="center" height="41px">
								<td width="6%">
									<font size="" color="blue" face="楷体">${user.userId}</font>	
								</td>
								<td width="10%">									
									<img src="${image_path}${user.pic}" width="35" height="35">	
								</td>
								<td width="10%">
									<font size="" color="blue" face="楷体">${user.username}</font>
								</td>
								<td width="10%">
									<font size="" color="blue" face="楷体">${user.password}</font>
								</td>
								<td width="7%">	
									<font size="" color="blue" face="楷体">
										<c:if test="${user.gender == 1}">男</c:if>
										<c:if test="${user.gender == 0}">女</c:if>
									</font>
								</td>
								<td width="13%">
									<font size="" color="blue" face="楷体">${user.birthday}</font>
								</td>
								<td width="10%">
									<font size="" color="blue" face="楷体">${user.sal}</font>
								</td>
								<td width="20%">
									<font size="" color="blue" face="楷体">${user.email}</font>
								</td>
								<td width="10%">
									<font size="" color="blue" face="楷体">
										<a href="${rpath}/QuerySingleUser?userId=${user.userId}" style="text-decoration: none;">
											<img src="${rpath}/images/edt.gif" title="编辑"/>
										</a>
										<a href="${rpath}/DeleteServlet?userId=${user.userId }" style="text-decoration: none;">
											<img src="${rpath}/images/del.gif" title="删除"/>
										</a>		
									</font>
								</td>
								</tr>
						</c:forEach>
						<tr></tr>
					</table>
				</td>
			</tr>	
			<tr height="41px">
				<td colspan="9">
					<table width="100%" height="100%"  border="0" cellspacing="0" cellpadding="0" style="border-color:skyblue;border-collapse:collapse;">
						<tr>
							<td width="70%"><font size="" color="gray" face="楷体">共有 ${count} 条记录，当前第 ${cpage}/<%=request.getAttribute("all")%> 页</font></td>
							<td width="30%">
								<table width="100%" height="100%" border="0" align="right" cellpadding="0" cellspacing="0" style="border-color:skyblue;">
									<tr>
										<td align="center">
											<table  width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" style="border-color:skyblue;">
												<tr>
													<td width="25%" align="right"><font size="" color="blue" face="楷体"><a href="<%=request.getAttribute("address") %>?currentpage=${1}&&sqls=<%=request.getParameter("sql")%>" style="text-decoration: none;"><b>首页</b></a></font></td>
													<td width="25%" align="right"><font size="" color="blue" face="楷体"><a href="<%=request.getAttribute("address") %>?currentpage=${cpage-1}&&sqls=<%=request.getParameter("sql")%>" style="text-decoration: none;"><b>上一页</b></a></font></td>
													<td width="25%" align="right"><font size="" color="blue" face="楷体"><a href="<%=request.getAttribute("address") %>?currentpage=${cpage+1}&&sqls=<%=request.getParameter("sql")%>" style="text-decoration: none;"><b>下一页</b></a></font></td>
													<td width="25%" align="right"><font size="" color="blue" face="楷体"><a href="<%=request.getAttribute("address") %>?currentpage=${all}&&sqls=<%=request.getParameter("sql")%>" style="text-decoration: none;"><b>尾页&nbsp;</b></a></font></td>													
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>