<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="/myTags" prefix="my" %>
<table style="margin-top: 10px;"
	class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>用户名</th>
			<th>姓名</th>
			<th width="60">性别</th>
			<th>电话</th>
			<th>注册时间</th>
			<th>角色</th>
			<th width="220">操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="vo">
		<tr data-id="${vo.userId}">
			<td>${vo.userName }</td>
			<td class="_userRealName">${vo.userRealName }</td>
			<td class="text-center">${vo.userSex?"男":"女" }</td>
			<td>${vo.userTel }</td>
			<td><f:formatDate value="${vo.createTime }" pattern="yyyy-MM-dd HH:mm"/> </td>
			<td>${vo.userTypeName }</td>
			<td><button href="user-modify-form.action?id=${vo.userId}" data-dialog=""
					 class="btn btn-primary btn-xs">
					<i class="fa fa-pencil-square-o"></i> 修改
				</button>
				<button data-dialog="" href="user-set-pwd-form.action" class="btn btn-success btn-xs">
					<i class="fa fa-check"></i> 重置密码
				</button>
				<button class="btn btn-danger btn-xs _delete">
					<i class="fa fa-close"></i> 删除
				</button></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<nav style="text-align:center;">
      <ul class="pagination" style="margin:0;">
        <my:page rowAll="${a }" pagination="${p }" >
        <li<c:if test="${text eq p }"> class="active"</c:if>><a href="javascript:void(0);" data-page="${page }">${text }</a></li>
        </my:page>
     </ul>
</nav>
