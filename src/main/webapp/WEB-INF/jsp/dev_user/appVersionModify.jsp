<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2019-09-11
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="bai-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>app info modify</title>
    <base href="<%=basePath%>">
    <!-- Bootstrap -->
    <link href="statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="statics/css/nprogress.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="statics/css/custom.min.css" rel="stylesheet">
    <style>
        #versionTable{
            text-align: center;
            font-size: 12px;
            width: 100%;
            line-height: 40px
        }
    </style>
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>APP Manager</h3>
                    </div>
                </div>

                <div class="clearfix"></div>
                <!-- version表格 -->
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>APP VERSION LIST
                                    <small>${sessionScope.session_user.devName}</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <table id="versionTable" border="1" cellpadding="0" cellspacing="0">
                                    <tr style="font-weight: bold">
                                        <td width="20%">软件名称</td>
                                        <td width="15%">版本号</td>
                                        <td width="10%">版本大小(M)</td>
                                        <td width="15%">发布状态</td>
                                        <td width="25%">APK文件下载</td>
                                        <td width="15%">最近更新时间</td>
                                    </tr>
                                    <c:forEach var="version" items="${requestScope.versionList}">
                                        <tr>
                                            <td>${version.softwareName}</td>
                                            <td>${version.versionNo}</td>
                                            <td>${version.versionSize}</td>
                                            <td>${version.publishStatusName}</td>
                                            <td>${version.apkFileName}</td>
                                            <!-- 使用自定义标签转换日期格式 -->
                                            <td><s:dateFormat date="${version.modifyDate}"/></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <!-- 新增form表单 -->
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>APP VERSION MODIFY
                                    <small>${sessionScope.session_user.devName}</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <!-- form -->
                                <form class="form-horizontal form-label-left" novalidate method="post" id="addForm" action="version/versionModify" enctype="multipart/form-data">
                                    <span class="section">${sessionScope.modifyResult}</span>
                                    <c:remove var="modifyResult" scope="session"/>
                                    <!-- 存储软件编号 -->
                                    <input type="hidden" value="${requestScope.appId}" name="appId">
                                    <!-- 存储版本编号 -->
                                    <input type="hidden" value="${newVersion.id}" name="id">
                                    <!-- 软件名称 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionNo">版本号 <span
                                                class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input id="versionNo" class="form-control col-md-7 col-xs-12" readonly
                                                   name="versionNo" required="required" type="text" value="${newVersion.versionNo}">
                                        </div>
                                    </div>
                                    <!-- 版本大小 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionSize">版本大小 <span
                                                class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="number" id="versionSize" name="versionSize" required="required"
                                                   data-validate-minmax="0,500"
                                                   class="form-control col-md-7 col-xs-12" value="${newVersion.versionSize}">
                                        </div>
                                    </div>
                                    <!-- 发布状态 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">发布状态
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <span>${newVersion.publishStatusName}</span>
                                            <input type="hidden" value="${newVersion.publishStatus}" id="publishStatus" name="publishStatus">
                                        </div>
                                    </div>
                                    <!-- 版本简介 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionInfo">版本简介
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <textarea id="versionInfo" name="versionInfo"
                                                      class="form-control col-md-7 col-xs-12">${newVersion.versionInfo}</textarea>
                                        </div>
                                    </div>
                                    <!-- apk文件 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">apk文件
                                            <span class="required">*</span>
                                        </label>
                                        <span id="apkFileName">${newVersion.apkFileName}</span>
                                        <a href="javascript:;" id="deleteApkButton">删除</a>
                                        <input type="hidden" name="apkFileName" value="${newVersion.apkFileName}">
                                        <input type="hidden" name="apkLocPath" value="${newVersion.apkLocPath}">
                                    </div>
                                    <div class="ln_solid"></div>
                                    <!-- 按钮 -->
                                    <div class="form-group">
                                        <div class="col-md-6 col-md-offset-3">
                                            <button type="button" class="btn btn-primary" id="backButton">返回</button>
                                            <button id="send" type="submit" class="btn btn-success">保存</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->
    </div>
</div>
<!-- jQuery -->
<script src="statics/js/jquery.min.js"></script>
<script src="statics/js/dev/dev_version.js"></script>
<!-- Bootstrap -->
<script src="statics/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="statics/js/fastclick.js"></script>
<!-- NProgress -->
<script src="statics/js/nprogress.js"></script>
<!-- validator -->
<script src="statics/js/validator.js"></script>

<!-- Custom Theme Scripts -->
<script src="statics/js/custom.min.js"></script>

<!-- validator -->
<script>
    // initialize the validator function
    validator.message.date = 'not a real date';

    // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
    $('form')
        .on('blur', 'input[required], input.optional, select.required', validator.checkField)
        .on('change', 'select.required', validator.checkField)
        .on('keypress', 'input[required][pattern]', validator.keypress);

    $('.multi.required').on('keyup blur', 'input', function () {
        validator.checkField.apply($(this).siblings().last()[0]);
    });

    $('form').submit(function (e) {
        e.preventDefault();
        var submit = true;

        // evaluate the form using generic validaing
        if (!validator.checkAll($(this))) {
            submit = false;
        }

        if (submit)
            this.submit();

        return false;
    });
</script>
<!-- /validator -->
</body>
</html>
