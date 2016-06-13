<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/13
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pay</title>
</head>
<body>
<form action="/pay" method="post">
    <input type="hidden" name="token" value="${requestScope.token}">
    <input type="text" name="money">
    <button type="submit">支付</button>
</form>

</body>
</html>
