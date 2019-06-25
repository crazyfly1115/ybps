<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>推荐管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/cms/cmsBook/">推荐列表</a></li>
		<shiro:hasPermission name="cms:cmsBook:edit"><li><a href="${ctx}/cms/cmsBook/form">推荐添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="cmsBook" action="${ctx}/cms/cmsBook/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
				<th>作者</th>
				<th>出版社</th>
				<th>出版时间</th>
				<shiro:hasPermission name="cms:cmsBook:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="cmsBook">
			<tr>
				<td><a href="${ctx}/cms/cmsBook/form?id=${cmsBook.id}">
					${cmsBook.title}
				</a></td>
				<td>
					${cmsBook.author}
				</td>
				<td>
					${cmsBook.puhlishHouse}
				</td>
				<td>
					${cmsBook.publishYear}
				</td>
				<shiro:hasPermission name="cms:cmsBook:edit"><td>
    				<a href="${ctx}/cms/cmsBook/form?id=${cmsBook.id}">修改</a>
					<a href="${ctx}/cms/cmsBook/delete?id=${cmsBook.id}" onclick="return confirmx('确认要删除该推荐吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>