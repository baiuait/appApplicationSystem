<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2019-09-11
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>APP MODIFY
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
                                <form class="form-horizontal form-label-left" novalidate method="post" id="addForm" action="appInfo/doModify" enctype="multipart/form-data">
                                    <span class="section">APP Info</span>
                                    <!-- 软件编号 -->
                                    <input type="hidden" name="id" value="${appInfo.id}">
                                    <!-- 软件名称 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwareName">软件名称 <span
                                                class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input id="softwareName" class="form-control col-md-7 col-xs-12"
                                                   name="softwareName" required="required" type="text" value="${appInfo.softwareName}">
                                        </div>
                                    </div>
                                    <!-- APK名称 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="APKName">APK名称 <span
                                                class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" id="APKName" name="APKName" required="required"
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
                                            <%--data-validate-linked="email"--%> required="required"
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
                                                   required="required" class="form-control col-md-7 col-xs-12" value="${appInfo.interfaceLanguage}">
                                        </div>
                                    </div>
                                    <!-- 软件大小 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="softwareSize">软件大小
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="number" id="softwareSize" name="softwareSize" required="required"
                                                   data-validate-minmax="0,500"
                                                   class="form-control col-md-7 col-xs-12" value="${appInfo.softwareSize}">
                                        </div>
                                    </div>
                                    <!-- 下载次数 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="downloads">下载次数
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="number" id="downloads" name="downloads" required="required"
                                                   data-validate-minmax="0,100000"
                                                   class="form-control col-md-7 col-xs-12" value="${appInfo.downloads}">
                                        </div>
                                    </div>
                                    <!-- 所属平台 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3">所属平台
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <%--<input id="password" type="text" name="password"--%>
                                            <%--data-validate-length="6,8" class="form-control col-md-7 col-xs-12"--%>
                                            <%--required="required">--%>
                                                <input type="hidden" id="flatformIdValue" value="${appInfo.flatformId}">
                                            <select class="form-control col-md-7 col-xs-12" id="flatformId" name="flatformId" >
                                                <option value="-1">-请选择-</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- 一级分类 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">一级分类
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="hidden" id="categoryLevel1Value" value="${appInfo.categoryLevel1}">
                                            <select class="form-control col-md-7 col-xs-12" id="categoryLevel1" name="categoryLevel1" >
                                                <option value="-1">-请选择-</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- 二级分类 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="categoryLevel2">二级分类
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="hidden" id="categoryLevel2Value" value="${appInfo.categoryLevel2}">
                                            <select class="form-control col-md-7 col-xs-12" id="categoryLevel2" name="categoryLevel2" >
                                                <%--<option value="-1">-请选择-</option>--%>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- 三级分类 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="categoryLevel3">三级分类
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="hidden" id="categoryLevel3Value" value="${appInfo.categoryLevel3}">
                                            <select class="form-control col-md-7 col-xs-12" id="categoryLevel3" name="categoryLevel3" >
                                                <%--<option value="-1">-请选择-</option>--%>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- APP状态 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">APP状态
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <input type="text" value="${appInfo.statusName}" readonly/>
                                            <input type="hidden" value="${appInfo.status}" id="status" name="status">
                                        </div>
                                    </div>
                                    <!-- 应用简介 -->
                                    <div class="item form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="appInfo">应用简介
                                            <span class="required">*</span>
                                        </label>
                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                            <textarea id="appInfo" name="appInfo"
                                                      class="form-control col-md-7 col-xs-12">${appInfo.appInfo}</textarea>
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
                                    <div class="ln_solid"></div>
                                    <!-- 按钮 -->
                                    <div class="form-group">
                                        <div class="col-md-6 col-md-offset-3">
                                            <!-- 判断审核是否未通过 -->
                                            <c:if test="${appInfo.status == 3}">
                                                <button type="button" class="btn btn-primary" id="saveAndSend">保存并再次提交审核</button>
                                            </c:if>
                                            <button id="send" type="submit" class="btn btn-success">提交</button>
                                            <button type="button" class="btn btn-primary" id="backButton">返回</button>
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
<script src="statics/js/dev/dev_appModify.js"></script>
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