<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/9
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="/ErrorPage/error.jsp" language="java" %>

<html>
<head>
    <title>气表管理</title>
</head>
<body>
<h1>集中器</h1>

<div style="float: left">
    <table border="1" bgcolor="#ff7f50" style="align-content: center">
        <tr>
            <td>
                <button type="button">Click Me!</button>
            </td>
        </tr>
        <tr>
            <td>row 2, cell 1</td>
        </tr>
    </table>
</div>

<div style="float: inherit">

    <table border="1" bgcolor="#ffe4c4" style="align-content: center">
        <tr>
            <td>
                <button type="button">Click Me!</button>
            </td>
        </tr>
        <tr>
            <td>row 2, cell 1</td>
        </tr>
    </table>
</div>

<%
    //这行代码肯定会出错，因为除数是0，一运行就会抛出异常
    int x = 1 / 0;
%>

</body>

</html>
