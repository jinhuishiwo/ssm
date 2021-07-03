
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+
            request.getServerName()+":"+request.getServerPort()+
            request.getContextPath()+"/";
%>
<html>
<head>
    <title>Title</title>
    <link rel="shortcut icon" href="#">
    <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function(){
            x()
            $("#select").click(function () {
                x()
            })
            function x() {
                $.ajax({
                    url:"student/selectStudent.do",
                    type:"get",
                    dataType:"json",
                    success:function (resp) {
                        $("#body").html("")
                        $.each(resp,function (i,n) {
                            $("#body").append("<tr><td>"+n.id+"</td>"+"<td>"+n.name+"</td>"+"<td>"+n.age+"</td></tr>")
                        })}})}})
    </script>
</head>
<body>
<div align="center">
<table align="center">
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
    </tr>
    </thead>

    <tbody id="body">

    </tbody>
</table>
<input type="button" value="刷新" id="select">
</div>
</body>
</html>
