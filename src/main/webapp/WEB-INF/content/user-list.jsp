<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="panel">
<div class="panel-body">

<form class="form-inline" id="userListSearchForm">
  <div class="form-group">
    <div class="input-group">
      <div class="input-group-addon">关键字</div>
      <input name="key" class="form-control" type="text" placeholder="搜索关键字">
    </div>
  </div>
  <div class="form-group">
    <div class="input-group">
      <select class="form-control" name="userTypeId">
      	<option value="0" selected="selected">全部用户</option>
      	<c:forEach items="${list }" var="vo">
      	<option value="${vo.userTypeId }">${vo.userTypeName }</option>
      	</c:forEach>
      </select>
    </div>
  </div>
  
  <button type="submit" class="btn btn-default"><i class="fa fa-search"></i> 搜索</button>
  <a class="btn btn-primary" data-dialog="" href="user-add-form.action"><i class="fa fa-plus"></i> 新增用户</a>
</form>
<div id="userListShow">

</div>
</div>
</div>
<script language="javascript">
(function($){
	$(function(){
		var form = $("#userListSearchForm");
		var show = $("#userListShow");
		var p=1;
		form.submit(function(){
			$.openHTML(
				"user-list-data.action",
				show,
				form.serializeArray(),
				function(){
					
					form.find(":input[name='p']").remove();
					
					userDelete();
					
					
					/**
					页面加载以后绑定分页的所有a标签的单击事件
					单击的时候，给表单添加一个页面的表单，并且触发表单的提交事件
					
					**/
					show.find("ul.pagination a").click(function(){
						form.append("<input type=\"hidden\" name=\"p\" value=\""+$(this).attr("data-page")+"\"/>");
						form.submit();
						return false;
					});
				}
				);
			return false;
		}).submit();
		
		/**
		删除按钮的单击事件的处理
		**/
		var userDelete =function(){
			show.find("._delete").click(function(){
				var tr = $(this).parents("tr:first");
				$.confirm(
					"删除确认",
					"您确定要删除[<b>"+tr.find("._userRealName").text()+"</b>]这个用户吗？",
					function(r){
						if(r){
							$.post(
								"user-delete.action",
								{"id":tr.attr("data-id")},
								function(data){
									if(data.msg!=null){
										$.alert("错误提示",data.msg);
									}else{
										$("#userListSearchForm").submit();
									}
								},"json"
							);
						}
					}
				);
				return false;
			});
		}
	});
})(jQuery);
</script>

    