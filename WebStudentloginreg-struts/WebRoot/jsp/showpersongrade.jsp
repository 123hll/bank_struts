<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 2019/8/19
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  page  isELIgnored="false" %>
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

    <!-- 	<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />	 -->


    <style type="text/css">
        body {
            background:url(images/bg.gif);
        }
    </style>

</head>

<body leftmargin="2" topmargin="2" >

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
    <tr bgcolor="#E7E7E7">
            <td height="14" colspan="6" align='center'>&nbsp;学生成绩&nbsp;</td>
    </tr>
    <tr align="center" bgcolor="#FAFAF1" height="22">
        <td width="15%">ID</td>
        <td width="15%">学生名</td>
        <td width="15%">课程名</td>
        <td width="15%">任课老师</td>
        <td width="15%">学分</td>
        <td width="15%">分数</td>
    </tr>
    <c:forEach items="${user}" var="s">
        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td bgcolor="#FFFFFF" align="center">
                    ${s.id}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${s.register_name}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${s.class_class}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${s.class_teacher}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${s.class_score}
            </td>
            <td bgcolor="#FFFFFF" align="center">
                    ${s.grade_grade}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

