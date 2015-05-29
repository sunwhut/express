<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="panel">
    	
        <div class="panel-body">
<form id="userAddForm" role="form" class="form-horizontal" method="post">
      <div class="form-group">
        <label class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
          <input class="form-control"  type="text" name="userName" placeholder="请在这里输入4-10位的用户名" required pattern="^\w{4,10}$">
        </div>
      </div>
      
      <div class="form-group">
        <label class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
          <input type="password" name="userPwd" placeholder="请输入4-10位的密码" required pattern="^\w{4,10}$" class="form-control">
        </div>
      </div>
      
      <div class="form-group">
        <label class="col-sm-2 control-label">密码确认</label>
        <div class="col-sm-10">
          <input type="password" placeholder="请再次输入新密码" required onkeyup="if(this.form.userPwd.value!=this.value){this.setCustomValidity('两次输入的密码不匹配')}else{this.setCustomValidity('');}"  class="form-control">
        </div>
      </div>
      
      <div class="form-group">
        <label class="col-sm-2 control-label">真实姓名</label>
        <div class="col-sm-4">
          <input class="form-control"  type="text" name="userRealName" placeholder="请输入2-6位的中文姓名" required pattern="^[\u4e00-\u9fa5]{2,6}$">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-2 control-label">联系电话</label>
        <div class="col-sm-10">
          <input class="form-control"  type="text" name="userTel" placeholder="请在这里输入手机号码" required pattern="^\w{7,15}$">
        </div>
      </div>
      
      <div class="form-group">
        <label class="col-sm-2 control-label">性别</label>
        <div class="col-sm-10">
         <select class="form-control" name="userSex">
      	<option value="true" selected="selected">男</option>
      	<option value="false">女</option>
      </select>
        </div>
      </div>
      
      <div class="form-group">
        <label class="col-sm-2 control-label">系统角色</label>
        <div class="col-sm-10">
         <select class="form-control" name="userTypeId">
      	<c:forEach items="${list }" var="vo">
      	<option value="${vo.userTypeId }">${vo.userTypeName }</option>
      	</c:forEach>
      </select>
        </div>
      </div>
      


      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button class="btn btn-primary" type="submit"><i class="fa fa-plus"></i> 添加用户</button>
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
			"user-add.action",
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