<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/24
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404错误友好提示页面</title>
    <!-- 3秒钟后自动跳转回首页 -->
    <meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath}/index.jsp">
</head>
<body>
<img alt="你要访问的页面没有找到，请联系管理员处理!"
     10 src="${pageContext.request.contextPath}/img/404Error.png"/><br/>
3秒钟后自动跳转回首页，如果没有跳转，请点击<a href="${pageContext.request.contextPath}/index.jsp">这里</a>
</body>
</html>
