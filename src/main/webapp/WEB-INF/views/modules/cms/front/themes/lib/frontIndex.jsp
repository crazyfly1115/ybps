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
    <meta name="format-detection" content="telephone=no" />
    <meta content="email=no" name="format-detection" />
    <!-- 分享显示的标题-->
    <meta itemprop="name" content="铜梁图书馆" />
    <!-- 分享显示的简介-->
    <meta name="description" itemprop="description" content="铜梁图书馆" />

    <title>铜梁图书馆</title>

    <link rel="stylesheet" href="${ctxStatic}/lib/css/bootstrap.min.css">
    <link rel="stylesheet" href="${ctxStatic}/lib/css/styles.css"/>
</head>
<body>


<div class="index container">
    <div class="row">
        <div class="col-xs-4 col-sm-4">
            <img src="${ctxStatic}/lib/images/logo.png" class="logo" alt="标题">
        </div>
        <div class="col-xs-7 col-sm-7 datetime">
            <p class="content">今天是 <fmt:formatDate value="<%=new Date() %>" type="date" dateStyle="full"/> 重庆铜梁图书馆图书馆欢迎您！</p>
        </div>
        <div class="col-xs-1 col-sm-1 weather">
            <img src="${ctxStatic}/lib/images/weather.png" alt="天气">
        </div>
    </div>
    <div class="row">
        <div class="col-xs-7 col-sm-7 left">
            <div class="left-icon" >
                <img class="center-block" src="${ctxStatic}/lib/images/retrieval.png" alt="检索">
            </div>
            <div class="left-search">
                <input type="text" class="search-input" id="searchInput">
                <div class="search-icon" id="searchBtn"></div>
            </div>
            <a href="javascript:void(0)" class="search-help">
                检索项目文字说明
            </a>
        </div>
        <div class="col-xs-2 col-sm-2">
            <div class="middle">
                <div class="middle-position library pointer">
                    <p class="title middle-title">本馆概况</p>
                    <a href="javascript:void(0)" class="link-msg">
                        <p>
                            ${fnc:getCategory("e15701ef67c145d3b8a957713600a512").getDescription()}
                        </p>
                    </a>

                </div>
                <div class="middle-position service pointer">
                    <p class="title middle-title">服务指南</p>
                    <a href="javascript:void(0)" class="link-msg">
                        <p>
                           读者须知
                        </p>

                    </a>
                    <a href="javascript:void(0)" class="link-msg">
                        <p>
                            读者须知
                        </p>

                    </a>
                </div>
            </div>
        </div>
        <div class="col-xs-3 col-sm-3 right pointer">
            <p class="title right-title">常用资源</p>
            <div class="link-msg">
                <div class="msg-box">
                    <a href="${ctx}/list-892e39417c1e4101b32dc4109c0b6cde${urlSuffix}" class="msg-link">
                        数字资源
                    </a>
                    <a href=" " class="msg-link">
                         资源
                    </a>
                </div>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="banner" id="banner">
            <ul>
                <c:forEach items="${fnc:getLinkList(site.id, 'decdecad91bb4e8c8225d6b3ff13868d', 4, '')}" var="link"  varStatus="status">
                    <li data-id="${status.index}"><img src="${link.image}"></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-4 col-sm-4 left pointer">
            <img class="photo" src=" ${fnc:getCategory("ddc00e2cc30d4db8a40c6a76e5fec074").image}" alt="照片">
            <a href="javascript:void(0)" class="link-msg">
                <p>
                    ${fnc:getCategory("ddc00e2cc30d4db8a40c6a76e5fec074").getDescription()}
                </p>
            </a>
        </div>
        <div class="col-xs-4 col-sm-4 middle pointer">
            <div class="icon">

                <div class="link-msg">
                    <div class="msg-box">
                        <c:forEach items="${fnc:getArticleList(site.id, '8abcc372dbb54fc3a5087b2381608323', 5, '')}" var="art"  varStatus="status">
                            <a href="${art.id}" class="msg-link">
                                ${art.title}
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-4 col-sm-4 right pointer">
            <div class="icon">
                <div class="link-msg">
                   <div class="msg-box">
                    <c:forEach items="${fnc:getArticleList(site.id, 'de936c63975041ba843ee66468bebdec', 5, '')}" var="art"  varStatus="status">
                        <a href="${art.id}" class="msg-link">
                                ${art.title}
                        </a>
                    </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">

        <ul class="consult">
            <li class="pointer">
                <a href="javascript:void(0)">
                    <img src="${ctxStatic}/lib/images/qq.jpg" alt="QQ">
                </a>
            </li>
            <li class="pointer">
                <img src="${ctxStatic}/lib/images/consult.jpg" alt="参考咨询">
            </li>
            <li class="pointer">
                <img src="${ctxStatic}/lib/images/wifi.jpg" alt="wifi">
            </li>
            <li class="pointer">
                <img src="${ctxStatic}/lib/images/code1.jpg" alt="微信公众">
            </li>
            <li class="pointer">
                <img src="${ctxStatic}/lib/images/code2.jpg" alt="图书馆二维码">
            </li>
        </ul>

    </div>
    <div class="row books">
        <p class="title"><span>新书推荐</span></p>
        <c:forEach items="${fnc:getCmsBookList(5, '')}" var="bean"  varStatus="status">
        <div class="col-xs-3 col-sm-6">
            <a href="javascript:void(0)" target="_blank">
                <div class="book-info">
          <span class="book-img">
            <img src="${bean.image}" alt="图书图片" >
          </span>
                    <div class="book-about">
                        <h3 class="book-name f-toe">${bean.title}</h3>
                        <div class="book-author hidden-xs">
                            <p class="f-toe"><span>作者：</span>${bean.author}</p>
                            <p class="f-toe"><span>出版社：</span>${bean.puhlishHouse}</p>
                            <p class="f-toe"><span>出版年：</span>${bean.publishYear}</p>
                            <p class="f-toe"><span>馆藏地：</span>${bean.library}</p>
                            <p class="f-toe"><span>索书号：</span>${bean.indexNo}</p>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        </c:forEach>

    </div>
</div>

<script src="${ctxStatic}/lib/js/jquery.min.js"></script>
<script src="${ctxStatic}/lib/js/unslider.min.js"></script>
<script src="${ctxStatic}/lib/js/index.js"></script>
</body>
</html>