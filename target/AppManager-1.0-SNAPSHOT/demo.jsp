<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2019-09-11
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String path = new java.io.File(application.getRealPath(request.getRequestURI())).getParent();
        request.setAttribute("path", path);
    %>
${path}
</body>
</html>
