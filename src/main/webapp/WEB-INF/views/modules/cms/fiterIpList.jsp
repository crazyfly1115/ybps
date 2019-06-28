<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>IP过滤管理</title>
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
		<li class="active"><a href="${ctx}/cms/fiterIp/">IP过滤列表</a></li>
		<shiro:hasPermission name="cms:fiterIp:edit"><li><a href="${ctx}/cms/fiterIp/form">IP过滤添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="fiterIp" action="${ctx}/cms/fiterIp/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>起始IP：</label>
				<form:input path="startIp" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>结束IP：</label>
				<form:input path="endIp" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>起始IP</th>
				<th>结束IP</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="cms:fiterIp:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="fiterIp">
			<tr>
				<td><a href="${ctx}/cms/fiterIp/form?id=${fiterIp.id}">
					${fiterIp.startIp}
				</a></td>
				<td>
					${fiterIp.endIp}
				</td>
				<td>
					<fmt:formatDate value="${fiterIp.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fiterIp.remarks}
				</td>
				<shiro:hasPermission name="cms:fiterIp:edit"><td>
    				<a href="${ctx}/cms/fiterIp/form?id=${fiterIp.id}">修改</a>
					<a href="${ctx}/cms/fiterIp/delete?id=${fiterIp.id}" onclick="return confirmx('确认要删除该IP过滤吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>