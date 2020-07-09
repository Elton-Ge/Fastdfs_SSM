<%--
  Created by IntelliJ IDEA.
  User: elton
  Date: 9/7/20
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>--%>

<html>
<head>
    <%--     <base href="<%=basePath%>"/>--%>
    <title>首页</title>
</head>
<body>
 <h1 align="center">首页测试</h1>


     <form action="/uploadFile" method="post" enctype="multipart/form-data">
         选择要上传的文件:<input type="file" name="uploadFile">&nbsp;  &nbsp;&nbsp;
         <input type="submit" value="上传">
     </form>

<table border="1" align="center" width="800">
    <thead>
    <tr>
        <th>文件原始名称</th>
        <th>文件卷标名称</th>
        <th>文件远程名称</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="fileInfo">
        <tr>
            <th>${fileInfo.fileName}</th>
            <th>${fileInfo.groupName}</th>
            <th>${fileInfo.remoteFileName}</th>
            <th><a href="/downloadFile/${fileInfo.id}">下载</a> <a href="http://192.168.64.5:8888/${fileInfo.filePath}" target="_blank">预览</a></th>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
