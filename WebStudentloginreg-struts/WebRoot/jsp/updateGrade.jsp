<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isELIgnored="false" %> 
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        
        <script language="javascript">
            function closeOpen()
		    {
		       window.returnValue=false;
		       window.close();
		    }
		    
			function check1(){
				if( document.getElementById("userName").value==""){
					alert("请输入学生名");
					return false;
				}
				if((Integer.parseInt(document.getElementById("userName").value)>100)||(Integer.parseInt(document.getElementById("userName").value)<0)){
					alert("成绩输入有误");
					return false;
				}
					document.text.submit();
			}
        </script>
        <style type="text/css">
	body {
		 background:url(images/bg.gif);
		}
	</style>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/images/allbg.gif'> 
			<form action="<%=path %>/student.do?command=modifyGrade?id=${id}" name="formAdd" method="post">
				     <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
						<tr bgcolor="#EEF4EA">
					        <td colspan="3" background="<%=path %>/images/wbg.gif" class='title' align='center'><span>学生成绩修改</span></td>
					    </tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						         学生名：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input  readonly="readonly" type="text" name="studentname"  id="studentname" size="20" value="${studentname}" />
						  
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        课程：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						    	${studentclass}
							    <!-- 
							        <select name="class">
							        		<option value=0 selected>请选择</option>
											<c:forEach items="${user}" var="s">
												<option value=${s.id} >${s.class_class}</option>
											</c:forEach>
									</select>	
								 -->
						    </td>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						     成绩：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="grade" id="grade" size="22" value="${studentgrade}"/>
						    </td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="submit" value="提交" onClick="check1()"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						       <input type="button" value="取消" onclick="closeOpen()"/>
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
