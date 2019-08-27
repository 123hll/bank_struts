<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 2019/8/24
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@  page  isELIgnored="false" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
            if( document.getElementById("text").value==""){
                alert("请输入修改内容");
                return false;
            }
            if( document.getElementById("head").value==""){
                alert("请输入标题");
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
<form action="<%=path %>/UpdataTitleAfter" name="formAdd" method="post">
    <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
        <tr bgcolor="#EEF4EA">
            <td colspan="3" background="<%=path %>/images/wbg.gif" class='title' align='center'><span>查看通告</span></td>
        </tr>
        <c:forEach items="${title}" var="s">
        <input type="hidden" name="id" size="20" value="${s.id}"/>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                标题名：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="head" size="30" value='${s.head}' />
            </td>
        </tr>
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                正文内容：
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <textarea rows="12" cols="80" name="text" >${s.text}</textarea>
            </td>
        </tr>

        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td width="25%" bgcolor="#FFFFFF" align="right">
                &nbsp;
            </td>
            <td width="75%" bgcolor="#FFFFFF" align="left">
                <input type="submit" value="修改" onClick="check1()"/>&nbsp;
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
          </c:forEach>
    </table>
</form>
</body>
</html>
