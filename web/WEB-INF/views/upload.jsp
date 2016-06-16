<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/16
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
    <link rel="stylesheet" href="/static/js/bootstrap.min.css">
</head>
<body>

    <div class="container">

        <form action="/upload" method="post" enctype="multipart/form-data">
            <label>文件描述:</label>
            <input type="text" class="form" name="desc"><br/><br/>
            <label>请选择文件:</label>
            <input type="file" name="doc"><br/><br/>
            <button type="submit">保存</button>
        </form>

    </div>

</body>
</html>
