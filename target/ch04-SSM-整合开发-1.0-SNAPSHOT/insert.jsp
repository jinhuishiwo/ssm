
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+
            request.getServerName()+":"+request.getServerPort()+
            request.getContextPath()+"/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>">
</head>
<body>
<form action="student/addStudent.do">
    <input type="text" name="name" align="center">
    <input type="text" name="age" align="center">
    <input type="submit" value="提交" align="center">
</form>
</body>
</html>
