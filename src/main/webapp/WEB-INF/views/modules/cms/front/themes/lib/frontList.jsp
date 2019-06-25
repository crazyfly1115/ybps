<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/modules/cms/front/include/taglib.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" name="viewport">
    <meta content="webkit" name="renderer">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="format-detection" content="telephone=no">
    <meta content="email=no" name="format-detection">
    <meta itemprop="name" content="铜梁图书馆">
    <meta name="description" itemprop="description" content="铜梁图书馆">

    <title>铜梁图书馆</title>

    <link rel="stylesheet" href="${ctxStatic}/lib/css/bootstrap.min.css?v=d48c86fa-11ee-48f5-afe2-3b33b05037cb">
    <link rel="stylesheet" href="${ctxStatic}/lib/css/styles.css?v=5eb59a37-1dba-4f98-a9e5-6bad2f97fe66">

</head>
<body>
<div class="columns list">
    <div class="header">
        <div class="header-link">
            <a href="javascript:void(0)" target="_blank">入驻</a>
            <a href="javascript:void(0)" target="_blank">登录</a>
            <a href="javascript:void(0)" target="_blank">注册</a>
        </div>
    </div>
    <div class="middle">
        <div class="menu">
            <div class="container">
                <img class="logo" src="${ctxStatic}/lib/images/logo.png?v=ef0f2c0e-4c7a-48e0-b118-a13fb8bcab25" alt="logo">
                <ul class="menu-nav">
                    <li><a href="javascript:void (0)">首页</a></li>
                    <li><a class="hover" href="javascript:void (0)">动态</a></li>
                    <li><a href="javascript:void (0)">关于</a></li>
                    <li><a href="javascript:void (0)">帮助</a></li>
                </ul>
            </div>
        </div>
        <div class="container main">
            <div class="main-left">
                <div class="main-left-title">${category.name} <span>NEW</span></div>
            </div>
            <div class="main-content">
                <ul class="news-list">
                    <c:forEach items="${page.list}" var="article">
                    <li>
                        <a href="${article.url}" target="_blank">${fns:abbr(article.title,96)} <span><fmt:formatDate value="${article.updateDate}" pattern="yyyy.MM.dd"/></span></a>
                    </li>
                    </c:forEach>
                </ul>
                <nav class="page" aria-label="Page navigation">
                    <ul class="pagination">
                        ${page.libPage}
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="container">
            <address class="address">
                <h4 class="address-title">热线电话</h4>
                <p class="address-phone"> 023-000000</p>
                <span>微博：http://weibo.com/abcdefg</span>
                <span>地址：这就是一个地址而已2栋2-2</span><br>
                <span>微信：abcdefg </span>
                <span>订阅号：bbcdefg </span>
                <span>邮箱：abcdefg@abcd.com</span>
            </address>
            <div class="map">
                <ul>
                    <li>
                        <a href="javascript:void (0)">网站首页</a>
                    </li>
                    <li>
                        <a href="javascript:void (0)">关于我们</a>
                    </li>
                    <li>
                        <a href="javascript:void (0)">友情链接</a>
                    </li>
                    <li>
                        <a href="javascript:void (0)">新闻中心</a>
                    </li>
                    <li>
                        <a href="javascript:void (0)">联系我们</a>
                    </li>
                </ul>
            </div>
            <p class="beian">
                <a href="javascript:void(0)" target="_blank">网站备案号</a>
            </p>
        </div>
    </div>
</div>
</body>
</html>