<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<form id="modifyPwdForm" role="form" class="form-horizontal"  method="post">
	<input name="userId" type="hidden" value="" />
      <div class="form-group">
        <label class="col-sm-2 control-label">新密码</label>
        <div class="col-sm-10">
          <input type="password" name="userPwd" placeholder="请输入3-10位的新密码" required pattern="^\w{3,10}$" class="form-control">
        </div>
      </div>
      
      <div class="form-group">
        <label class="col-sm-2 control-label">密码确认</label>
        <div class="col-sm-10">
          <input type="password" placeholder="请再次输入新密码" required onkeyup="if(this.form.userPwd.value!=this.value){this.setCustomValidity('两次输入的密码不匹配')}else{this.setCustomValidity('');}"  class="form-control">
        </div>
      </div>
      
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button class="btn btn-primary" type="submit"><i class="fa fa-save"></i> 重新设置密码</button>
          <button class="btn btn-danger"  data-dismiss="modal"><i class="fa fa-close"></i> 关闭</button>
        </div>
      </div>
    </form>
<script language="javascript">
$(function(){
	var form = $("#modifyPwdForm");
	form.find(":input[name='userId']").val($.dataTarget.parents("tr:first").attr("data-id"));
	form.submit(function(){
		$.post(
			"user-set-pwd.action",
			form.serializeArray(),
			function(data){
				if(data.msg!=null){
					$.alert("错误提示",data.msg);
				}else{
					form.parents(".modal").modal('hide');
					$.alert("成功提示","重新设置登陆密码成功");
				}
			},"json"
		);
		
		return false;
	});
});
</script>
