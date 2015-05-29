(function($){
	$.fn.mainMenu = function(arg){
		var root = $(this);
		var config = $.extend({
			resize	:	function(){//窗口大小改变事件
							
							root.height($(window).height()-parseInt(root.css("top")));//设定左边菜单的高度
							var showSubMenu = root.children("ul").children("li").children("ul");//找到所有的子菜单
							showSubMenu.height(showSubMenu.height()+root.height()-root.children("ul").height());
						},
			menuClick:	function(){//主菜单单击触发事件
							var the = $(this).next("ul");
							if(the.is(":hidden")){
								root.children("ul").children("li").removeClass("open");
								root.children("ul").children("li").children("ul:visible").slideUp();
								$(this).parent().addClass("open");
								the.slideDown();
							}
							return false;
						},
			subMenuClick:function(){//子菜单单击触发事件
							var a = $(this);
							var parentMenu = a.parent().parent().parent().children("a");
							parentMenu.click();
							root.children("ul").children("li").children("ul").children("li").children("a.active").removeClass("active");
							a.addClass("active");
							root.children("ul").children("li.active").removeClass("active");
							parentMenu.parent().addClass("active");
							config.click(a,parentMenu);
							return false;
						},
			click	:	function(a,parentMenu){//单击某个子菜单触发的事件
							console.info(a);
							console.info(parentMenu);
						},
			init	:	function(){//菜单初始化
							root.children("ul").children("li").children("ul:first").show();
							$(window).resize(config.resize).resize();
							root.children("ul").children("li").children("ul:first").hide();
							root.children("ul").children("li").children("a").click(config.menuClick).filter(":first").click();
							root.children("ul").children("li").children("ul").children("li").children("a").click(config.subMenuClick);
						}
		},arg);
		config.init();
		return root;
	}	
})(jQuery);