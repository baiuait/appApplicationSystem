<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2019-09-17
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="s" uri="bai-tags" %>
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
        #versionTable {
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
                        <h3>APP VIEW</h3>
                    </div>
                </div>
                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>APP INFO
                                    <small>${sessionScope.session_backend_user.userName}</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <!-- form -->
                                <form class="form-horizontal form-label-left" novalidate>
                                    <span class="section">APP Info</span>
                                    <!-- 软件编号 -->
                                    <input type="hidden" name="id" value="${appInfo.id}" id="appId">
                                    <!-- 软件名称 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwareName">软件名称
                                            <span
                                                    class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input id="softwareName" class="form-control col-md-7 col-xs-12"
                                                   name="softwareName" required="required" type="text" readonly
                                                   value="${appInfo.softwareName}">
                                        </div>
                                    </div>
                                    <!-- APK名称 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="APKName">APK名称 <span
                                                class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="APKName" name="APKName" required="required" readonly
                                                   class="form-control col-md-7 col-xs-12" value="${appInfo.APKName}">
                                        </div>
                                    </div>
                                    <!-- 支持ROM -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supportROM">支持ROM
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="supportROM" name="supportROM"
                                            <%--data-validate-linked="email"--%> required="required" readonly
                                                   class="form-control col-md-7 col-xs-12" value="${appInfo.supportROM}">
                                        </div>
                                    </div>
                                    <!-- 界面语言 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="interfaceLanguage">界面语言
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="interfaceLanguage" name="interfaceLanguage"
                                                   required="required" class="form-control col-md-7 col-xs-12" readonly
                                                   value="${appInfo.interfaceLanguage}">
                                        </div>
                                    </div>
                                    <!-- 软件大小 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwareSize">软件大小
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="softwareSize" name="softwareSize" required="required" readonly
                                                   class="form-control col-md-7 col-xs-12" value="${appInfo.softwareSize}">
                                        </div>
                                    </div>
                                    <!-- 下载次数 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="downloads">下载次数
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="downloads" name="downloads" required="required" readonly
                                                   class="form-control col-md-7 col-xs-12" value="${appInfo.downloads}">
                                        </div>
                                    </div>
                                    <!-- 所属平台 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3">所属平台
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="flatformName" name="flatformName" required="required" readonly
                                                   class="form-control col-md-7 col-xs-12" value="${appInfo.flatformName}">
                                        </div>
                                    </div>
                                    <!-- 分类 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">所属分类
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="categoryName" name="categoryName" required="required" readonly
                                                   class="form-control col-md-7 col-xs-12"
                                                   value="${appInfo.category1Name}->${appInfo.category2Name}->${appInfo.category3Name}">
                                        </div>
                                    </div>
                                    <!-- APP状态 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="statusName" name="statusName" required="required" readonly
                                                   class="form-control col-md-7 col-xs-12" value="${appInfo.statusName}">
                                        </div>
                                    </div>
                                    <!-- 应用简介 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="appInfo">应用简介
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                <textarea id="appInfo" name="appInfo"
                                                          class="form-control col-md-7 col-xs-12"
                                                          readonly>${appInfo.appInfo}</textarea>
                                        </div>
                                    </div>
                                    <!-- LOGO图片 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">LOGO图片
                                            <span class="required">*</span>
                                        </label>
                                        <input type="hidden" value="${appInfo.logoLocPath}" id="logoLocPath">
                                        <input type="hidden" value="${appInfo.logoPicPath}" id="logoPicPath">
                                        <!-- 判断是否有LOGO图片 -->
                                        <c:choose>
                                            <c:when test="${appInfo.logoLocPath != '' && appInfo.logoPicPath != null}">
                                                <img src="" alt="" width="150px" id="logoPic">
                                                <a href="javascript:;" id="deleteImgButton">删除</a>
                                            </c:when>
                                            <c:otherwise>
                                                无LOGO图片
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <!-- 按钮 -->
                                    <div class="form-group">
                                        <div class="col-md-6 col-md-offset-3">
                                            <button id="sendOK" type="button" class="btn btn-success">审核通过</button>
                                            <button id="sendNO" type="button" class="btn btn-success">审核不通过</button>
                                            <button type="button" class="btn btn-primary" id="backButton">返回</button>
                                        </div>
                                    </div>
                                    <div class="ln_solid"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <!-- version最新信息 -->
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>NEW APP VERSION
                                    <small>${sessionScope.session_backend_user.userName}</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <!-- form -->
                                <form class="form-horizontal form-label-left" novalidate>
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
                                            <input type="text" id="versionSize" name="versionSize" required="required" readonly
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
                                        </div>
                                    </div>
                                    <!-- 版本简介 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="versionInfo">版本简介
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <textarea id="versionInfo" name="versionInfo" readonly
                                                      class="form-control col-md-7 col-xs-12">${newVersion.versionInfo}</textarea>
                                        </div>
                                    </div>
                                    <!-- apk文件 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">apk文件
                                            <span class="required">*</span>
                                        </label>
                                        <span id="apkFileName">${newVersion.apkFileName}</span>
                                        <!-- apk文件下载按钮 -->
                                        <a href="${newVersion.apkLocPath}" id="downloadApkButton">下载</a>
                                        <input type="hidden" name="apkFileName" value="${newVersion.apkFileName}">
                                        <input type="hidden" name="apkLocPath" value="${newVersion.apkLocPath}">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
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
<script src="statics/js/backend/appExamine.js"></script>
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