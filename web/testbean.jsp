<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/26
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
 3 在jsp中使用jsp:useBean标签来实例化一个Java类的对象
 4 <jsp:useBean id="person" class="gacl.javabean.study.Person" scope="page"/>
 5     ┝<jsp:useBean>：表示在JSP中要使用JavaBean。
 6     ┝id:表示生成的实例化对象，凡是在标签中看见了id，则肯定表示一个实例对象。
 7     ┝class：此对象对应的包.类名称
 8     ┝scope：此javaBean的保存范围，四种范围：page、request、session、application
 9 --%>
<jsp:useBean id="person" class="bean.Person" scope="page"/>

<%
    person.setName("wdj");
    person.setAge(23);
    person.setMarried(true);
    person.setSex("Male");
%>

<jsp:useBean id="person1" class="bean.Person" scope="page"/>
<jsp:setProperty property="name" name="person1" value="白虎神皇"/>
<jsp:setProperty property="sex" name="person1" value="男"/>
<jsp:setProperty property="age" name="person1" value="24"/>
<jsp:setProperty property="married" name="person1" value="false"/>
<jsp:setProperty property="birthday" name="person1" value="<%=new Date()%>"/>


<%--
13     jsp:setProperty标签可以使用请求参数为bean的属性赋值
14     param="param_name"用于接收参数名为param_name的参数值，然后将接收到的值赋给name属性
15 --%>
<jsp:useBean id="person2" class="bean.Person" scope="page"/>
<jsp:setProperty property="name" name="person2" param="name"/>


<%--
13     jsp:setProperty标签用所有的请求参数为bean的属性赋值
14     property="*"代表bean的所有属性
15 --%>
<jsp:useBean id="person3" class="bean.Person" scope="page"/>
<jsp:setProperty property="*" name="person3"/>

<!DOCTYPE HTML>

<html>
<head>
    <title>jsp:useBean标签使用范例</title>
</head>

<h2>姓名：<%=person.getName()%>
</h2>

<h2>性别：<%=person.getSex()%>
</h2>

<h2>年龄：<%=person.getAge()%>
</h2>

<h2>已婚：<%=person.isMarried()%>
</h2>

<h2>姓名：<%=person1.getName()%>
</h2>

<h2>性别：<%=person1.getSex()%>
</h2>

<h2>年龄：<%=person1.getAge()%>
</h2>

<h2>已婚：<%=person1.isMarried()%>
</h2>

<h2>出生日期：<%=person1.getBirthday()%>
</h2>


<h2>姓名：<%=person2.getName()%>
</h2>


<%--使用getXxx()方法获取对象的属性值 --%>
<h2>姓名：<%=person3.getName()%></h2>
<h2>性别：<%=person3.getSex()%></h2>
<h2>年龄：<%=person3.getAge()%></h2>

<body>

</body>
</html>
