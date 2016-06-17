<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/16
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>download</title>
    <link rel="stylesheet" href="/static/js/bootstrap.min.css">
</head>
<body>

    <div class="container" style="padding: 20px">

        <a href="/uploadcommons" class="btn btn-success">新建文件库</a>

        <div class="bs-example" data-example-id="hoverable-table">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>文件名</th>
                    <th>文件大小</th>
                    <th>md5</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.documentList}" var="doc">
                <tr>
                    <th scope="row">${doc.fileName}</th>
                    <td>${doc.displaySize}</td>
                    <td>${doc.md5}</td>
                    <td>
                        <a href="/preview?md5=${doc.md5}&down=true" class="btn">下载</a>
                        <c:if test="${doc.preview}">
                            <a href="/preview?md5=${doc.md5}" target="_blank">预览</a>
                        </c:if>

                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</body>
</html>
