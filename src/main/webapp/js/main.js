(function($){
$(function(){
	
	
	/**
		菜单栏内容加载
	**/	
	$.post(
		"login-user.action",
		function(data){
			if(data==null){
				window.location="login.html";
			}
			for(var key in data){
				$("._"+key).text(data[key]);
			}
			$.openHTML("html/menu-"+data.userTypeId+".html","#menu",[],function(menu){
				menu.mainMenu({click:subMenuClick});
			});
		},"json"
	);
	
	
	
	
	
	/**
		子菜单操作处理
	**/
	var subMenuClick = function(a,parentMenu){
		$("#address a:not(:first)").remove();
		$("#content-header h1").text(a.text());
		$("#address a.current").removeClass("current");
		$("#address").append(parentMenu.clone().click(function(){
			parentMenu.click();
			return false;
		}));
		$("#address").append(a.clone().addClass("current").click(function(){
			a.click();
			return false;
		}));
		$.openContent(a);
		//alert(parentMenu.text() + " > " + a.text());
	};
	
	
	$("body").on("click","[data-address]",function(){
		var temp = $(this).attr("data-address");
		if(temp=="set"){
			address.set($(this));
		}else if(temp=="add"){
			address.add($(this));
		}else{
			address.parent();
		}
		return false;
	});
	
	var address = {
		set : function(a){
			$("#address a:not(:first)").remove();
			$("#content-header h1").text(a.text());
			$("#address .current").removeClass("current");
			var temp = $("<a></a>");
			temp.attr("href",a.attr("href"))
			.attr("data-open","")
			.text(a.text());
			temp.removeAttr("class");
			$("#address").append(temp);
			temp.addClass("current");
			$.openContent(a);
		},
		parent : function(){
			$("#address a:last").remove();
			$("#content-header h1").text($("#address a:last").text());
			$("#address a:last").addClass("current");
			$.openContent($("#address a:last"));
		},
		add :	function(a){
			$("#content-header h1").text(a.text());
			$("#address .current").removeClass("current");
			var temp = $("<a></a>");
			temp.attr("href",a.attr("href"))
			.attr("data-load","")
			.text(a.text());
			$("#address").append(temp);
			temp.addClass("current");
			$.openContent(temp);
		}
	}
	/**
		地址导航 首页处理
	**/
	$("#address a:first").click(function(){
		$("#address a:not(:first)").remove();
		$("#content-header h1").text($(this).text());
		$("#address .current").removeClass("current");
		$(this).addClass("current");
		$.openContent($(this));
		return false;
	}).click();
	

	
	/**
	退出处理
	**/
	$("body").on("click","._exit",function(){
		$.confirm("退出提示","您确定要退出系统吗？",function(r){
			if(r){
				window.location="logout.action";
			}
		});
		return false;
	});
	
 
});	
})(jQuery);