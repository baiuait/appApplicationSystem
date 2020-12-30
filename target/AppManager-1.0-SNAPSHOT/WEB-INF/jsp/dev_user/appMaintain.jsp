<%--
  Created by IntelliJ IDEA.
  User: Stand
  Date: 2019-09-09
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>APP Manager</title>
    <style>
        #softwareName{
            margin-right: 150px;
            margin-left: 0px;
            width: 150px;
        }
        form select{
            margin-left: 0px;
            margin-right: 150px;
            width: 150px;
            padding: 5px;
        }
        form input[value="查询"]{
            width: 150px;
            padding: 3px;
            font-size: 14px;
        }
        #appInfoTable{
            text-align: center;
            font-size: 12px;
            width: 100%;
            line-height: 40px
        }
        #appInfoTable tr td{
            position: relative;
        }
        #appInfoTable tr td ul{
            list-style: none;
            display: none;
            position: absolute;
            padding-inline-start: 0px;
            width: 100%;
            top : 40px;
            background-color: #ffffff;
            z-index: 100;
        }
        #appInfoTable tr td ul li{
            border-top: brown solid 1px;
            cursor: pointer;
        }
        #createButton{
            font-size: 18px;
        }
        .headSpan{
            display: inline-block;
            width: 80px;
            text-align: left;
        }
    </style>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <!-- left navigation -->
        <jsp:include page="../nav/dev_user/left_nav.jsp"/>
        <!-- /left navigation -->
        <!-- top navigation -->
        <jsp:include page="../nav/dev_user/top_nav.jsp"/>
        <!-- /top navigation -->

        <!-- 内容替换区域 -->
        <div class="right_col" role="main" id="content-area">
            <div class="row tile_count">
                <b>APP信息管理维护</b>
                <span>
                    ${sessionScope.session_user.devName} - 您可以通过搜索或者其他的筛选项对APP的信息进行修改,删除等管理操作
                </span>
            </div>

            <div class="row">
                <form action="appInfo/appInfoList" method="post">
                    <!-- 使用hidden存放从c层传来的值 -->
                    <input type="hidden" id="statusValue" value="${requestScope.statusValue}">
                    <input type="hidden" id="flatformIdValue" value="${requestScope.flatformIdValue}">
                    <input type="hidden" id="categoryLevel1Value" value="${requestScope.categoryLevel1Value}">
                    <input type="hidden" id="categoryLevel2Value" value="${requestScope.categoryLevel2Value}">
                    <input type="hidden" id="categoryLevel3Value" value="${requestScope.categoryLevel3Value}">
                    <input type="hidden" id="currentPageNo" name="currentPageNo" value="${requestScope.currentPageNoValue}">
                    <input type="hidden" id="pagesCount" value="${requestScope.pagesCount}">
                    <!-- /使用hidden存放从c层传来的值 -->
                    <span class="headSpan">软件名称</span>
                    <input type="text" name="softwareName" id="softwareName" value="${requestScope.softwareNameValue}">
                    <span class="headSpan">APP状态</span>
                    <select name="status" id="status">
                        <option value="-1">-请选择-</option>
                    </select>
                    <span class="headSpan">所属平台</span>
                    <select name="flatformId" id="flatformId">
                        <option value="-1">-请选择-</option>
                    </select>
                    <br><br>
                    <span class="headSpan">一级分类</span>
                    <select name="categoryLevel1" id="categoryLevel1">
                        <option value="-1">-请选择-</option>
                    </select>
                    <span class="headSpan">二级分类</span>
                    <select name="categoryLevel2" id="categoryLevel2"></select>
                    <span class="headSpan">三级分类</span>
                    <select name="categoryLevel3" id="categoryLevel3"></select>
                    <br><br>
                    <input type="submit" value="查询">
                </form>
            </div>

            <div class="row">
                <a href="appInfo/toAdd" id="createButton">新增APP基础信息</a>
                <table id="appInfoTable" border="1" cellpadding="0" cellspacing="0">
                    <tr style="font-weight: bold">
                        <td width="15%">软件名称</td>
                        <td width="15%">APK名称</td>
                        <td width="8%">软件大小(M)</td>
                        <td width="8%">所属平台</td>
                        <td width="20%">所属分类(一-二-三)</td>
                        <td width="8%">状态</td>
                        <td width="8%">下载次数</td>
                        <td width="8%">最新版本号</td>
                        <td width="10%">操作</td>
                    </tr>
                    <c:forEach items="${requestScope.appInfoList}" var="appInfo">
                        <tr>
                            <input type="hidden" class="appId" value="${appInfo.id}">
                            <td>${appInfo.softwareName}</td>
                            <td>${appInfo.APKName}</td>
                            <td>${appInfo.softwareSize}</td>
                            <td>${appInfo.flatformName}</td>
                            <td>${appInfo.category1Name}->${appInfo.category2Name}->${appInfo.category3Name}</td>
                            <td class="statusName">${appInfo.statusName}</td>
                            <td>${appInfo.downloads}</td>
                            <td>${appInfo.versionSize}</td>
                            <td>
                                <a href="javascript:;" class="optionsButton">点击操作</a>
                                <ul>
                                    <li>
                                        <a href="version/versionList/${appInfo.id}">新增版本</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" class="editVersionButton">修改版本</a>
                                    </li>
                                    <li>
                                        <a href="javascript:;" class="deleteAppButton">删除</a>
                                    </li>
                                    <c:if test="${appInfo.statusName == '审核未通过' || appInfo.statusName == '待审核'}">
                                       <li>
                                           <a href="appInfo/toModify/${appInfo.id}">修改</a>
                                       </li>
                                    </c:if>
                                    <li>
                                        <a href="appInfo/view/${appInfo.id}">查看</a>
                                    </li>
                                    <c:if test="${appInfo.statusName == '审核通过' || appInfo.statusName == '已下架'}">
                                        <li>
                                            <a href="javascript:;" class="upApp">上架</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${appInfo.statusName == '已上架'}">
                                        <li>
                                            <a href="javascript:;" class="downApp">下架</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <p>共${requestScope.appInfoDataCount}条记录 ${requestScope.currentPageNoValue}/${requestScope.pagesCount}页</p>
                <p style="text-align: right">
                    <!-- 判断是否有上一页 第一页 -->
                    <c:if test="${requestScope.currentPageNoValue > 1}">
                        <a href="javascript:;" id="firstPage">首页</a> &nbsp;
                        <a href="javascript:;" id="prevPage">上一页</a> &nbsp;
                    </c:if>
                    <!-- 判断是否有下一页 最后一页 -->
                    <c:if test="${requestScope.currentPageNoValue < requestScope.pagesCount}">
                        <a href="javascript:;" id="nextPage">下一页</a> &nbsp;
                        <a href="javascript:;" id="endPage">末页</a>
                    </c:if>
                </p>
            </div>
        </div>
    </div>
</div>
<script src="statics/js/dev/dev_appMaintain.js"></script>
</body>
</html>
