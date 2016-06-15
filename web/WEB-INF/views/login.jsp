<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/13
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>login</title>
    <link rel="stylesheet" href="/static/js/bootstrap.min.css">
</head>
<body>

<div class="container">
    <c:choose>
        <c:when test="${1001 eq param.error}">
            <div class="alert alert-danger">验证码错误</div>
        </c:when>

        <c:when test="${1002 eq param.error}">
            <div class="alert alert-danger">用户名或密码错误</div>
        </c:when>
    </c:choose>

    <form action="/login" method="post" id="loginForm">


        用户名：<input type="text"  name="name"><br><br>


        密码：&nbsp;&nbsp;&nbsp;<input type="password" name="password" id="password"><br><br>


        验证码：<input type="text" name="captcha"><br><br>

        <a href="javascript:;" id="capt"><img src="/captcha.png" id="captcha" alt=""></a>

        <button type="button" id="submitBtn">登录</button>
    </form>
</div>
<script src="/static/js/jquery-3.0.0.min.js"></script>
<script src="/static/js/cryptojs/core-min.js"></script>
<script src="/static/js/cryptojs/md5-min.js"></script>
<script>

    $(function () {
        $("a").click(function () {
            $("#captcha").attr("src", "/captcha.png?id=" + new Date().getTime());
        });
        $("#submitBtn").click(function () {
            var password = $("#password").val();
            password = CryptoJS.MD5(password);
            $("#password").val(password);
            console.log(password.toString());

            $("#loginForm").submit();
        });
    });

</script>
</body>
</html>
