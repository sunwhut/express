(function($){
	$(function(){
		var w = ($("body").width()-990)/2;
		$(".logo").css("left",(-w-284)+"px").animate({"left":"0px"},2000);
		$(".fly").css({"left":(990+w)+"px","top":"340px",opacity:0.1}).animate({"left":"490px","top":"50px",opacity:1},2000,function(){
			
		});
		$(".login-frame").animate({
			top:"150px",
			left:"700px",
			opacity:1
		},500);
		var text = $(".text");
		
		var textX = text.position().left;
		var textY = text.position().top;
		text.css("opacity",0);
		var textShow = function(){
			var x = Math.floor(Math.random()*11)-5;
			var y = Math.floor(Math.random()*11)-5;
			x *= 10;
			y *= 5;
			if(text.css("opacity")==0){
				text.css({left:(textX+x)+"px",top:(textY+y)+"px"})
				.animate({left:textX+"px",top:textY+"px",opacity:1},1000);
				window.setTimeout(textShow,5000);
			}else{
				text.animate({left:(textX+x)+"px",top:(textY+y)+"px",opacity:0},1000);
				window.setTimeout(textShow,2000);
			}
		}
		//textShow();
		var bgX = 0;
		window.setInterval(function(){
			bgX -= 2;
			if(bgX<-1440){
				bgX = 0;
			}
			$("body").css("background-position",bgX+"px 0");
		},100);
		
		
		$("form").submit(function(){
			var form = $(this);
			$.post(
					form.attr("action"),
					form.serializeArray(),
					function(data){
						if(data.msg!=null){
							//alert(data.msg);
							bootbox.alert(data.msg);
						}else{
							window.location="main.html";
						}
					},"json"
			);
			
			return false;
		});
	});
})(jQuery);