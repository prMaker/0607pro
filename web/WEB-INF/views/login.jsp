<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/13
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<form action="/login" method="post">
    用户名：<input type="text" name="name"><br><br>
    密码：&nbsp;<input type="password" name="password"><br><br>
    验证码：<input type="text" name="captcha"><br><br>
    <img src="/captcha.png" id="captcha" alt="">
    <button type="submit">登录</button>
</form>

</body>
</html>
