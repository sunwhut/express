<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="panel">
    	
        <div class="panel-body">
<form id="userAddForm" role="form" class="form-horizontal" method="post">
<input type="hidden" name="userId" value="${user.userId}"/>
      <div class="form-group">
        <label class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
          <input class="form-control" disabled="disabled"  type="text" name="userName" value="${user.userName}">
        </div>
      </div>
      
      <div class="form-group">
        <label class="col-sm-2 control-label">真实姓名</label>
        <div class="col-sm-4">
          <input value="${user.userRealName }" class="form-control"  type="text" name="userRealName" placeholder="请输入2-6位的中文姓名" required pattern="^[\u4e00-\u9fa5]{2,6}$">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">联系电话</label>
        <div class="col-sm-10">
          <input value="${user.userTel }" class="form-control"  type="text" name="userTel" placeholder="请在这里输入手机号码" required pattern="^\w{7,15}$">
        </div>
      </div>
      
      <div class="form-group">
        <label class="col-sm-2 control-label">性别</label>
        <div class="col-sm-10">
         <select class="form-control" name="userSex">
  		<option value="true">男</option>
      	<option value="false">女</option>
      
      </select>
        </div>
      </div>
      
      <div class="form-group">
        <label class="col-sm-2 control-label">系统角色</label>
        <div class="col-sm-10">
         <select class="form-control" name="userTypeId">
      	<c:forEach items="${list }" var="vo">
      	<option value="${vo.userTypeId }"<c:if test="${vo.userTypeId==user.userTypeId}"> selected="selected"</c:if>>${vo.userTypeName }</option>
      	</c:forEach>
      </select>
        </div>
      </div>
      


      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button class="btn btn-primary" type="submit"><i class="fa fa-plus"></i> 修改用户</button>
        </div>
      </div>
    </form>
        </div>
    </div>


<script language="javascript">
$(function(){
	var form = $("#userAddForm");
	form.submit(function(){
		$.post(
			"user-modify.action",
			form.serializeArray(),
			function(data){
				if(data.msg!=null){
					$.alert("错误提示",data.msg);
				}else{
					form.parents(".modal").modal('hide');
					$("#userListSearchForm").submit();
					$.alert("成功提示","添加用户成功");
				}
			},"json"
		);
		
		return false;
	});
});

</script>