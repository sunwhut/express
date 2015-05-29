	//列出订单详情
	function setOrderInfo(){
		$.post(
				"order-liat-all.action",
				function(data){
					if(data==null){
						window.location("html/1-order/order-info.html");
					}
					$("#sendName").text(data.orderSenderName);
				}, "json"
		);
	}
