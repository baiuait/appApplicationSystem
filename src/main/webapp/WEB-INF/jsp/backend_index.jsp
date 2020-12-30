<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2019-09-16
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>ADMIN Manager</title>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- left navigation -->
        <jsp:include page="nav/backend_user/left_nav.jsp"/>
        <!-- /left navigation -->
        <!-- top navigation -->
        <jsp:include page="nav/backend_user/top_nav.jsp"/>
        <!-- /top navigation -->

        <!-- 内容替换区域 -->
        <div class="right_col" role="main" id="content-area">
            <div class="row tile_count">
                <h2>欢迎你: ${sessionScope.session_backend_user.userName} | 角色: 管理员账户</h2>
            </div>
        </div>
    </div>
</div>
</body>
</html>
