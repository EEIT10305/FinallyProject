	// -----------------改變圖片透明度來顯示現在工作----------------------------
	var flag1 = true;
	var flag2 = true;
	function receiveMessage(event) {
		if (event.data == "cardback") {
			if (flag1 && flag2) {//都沒按過按卡
				$("header").css("opacity", "0.5");
				$(".search").css("opacity", "0.5");
				$("#carouselExampleIndicatorsup").css("opacity", "0.5")
				$("footer").css("opacity", "0.5");
				$(".forcard").css("opacity", "1");
				flag1 = false;
			} else if (!flag1 && flag2) {//卡被按過按卡
				$("header").css("opacity", "1");
				$(".search").css("opacity", "1");
				$("#carouselExampleIndicatorsup").css("opacity", "1")
				$("footer").css("opacity", "1");
				$(".forcard").css("opacity", "1");
				flag1 = true;
			} else if (flag1 && !flag2) {//牆被按過按卡
				$("header").css("opacity", "0.5");
				$(".search").css("opacity", "0.5");
				$("#carouselExampleIndicatorsup").css("opacity", "0.5")
				$("footer").css("opacity", "0.5");
				$(".forcard").css("opacity", "1");
				flag1 = false;
			} else {//都被按過按卡
				$("header").css("opacity", "1");
				$(".search").css("opacity", "1");
				$("#carouselExampleIndicatorsup").css("opacity", "1")
				$("footer").css("opacity", "1");
				$(".forcard").css("opacity", "1");
				flag1 = true;
			}
			// $("#carouselExampleIndicators").css("-webfilter","opacity(0.5)")
		} else if (event.data == "wallback") {
			if (flag1 && flag2) {//都沒按過按牆
				$("header").css("opacity", "0.5");
				$(".search").css("opacity", "0.5");
				$("#carouselExampleIndicatorsup").css("opacity", "1")
				$(".forcard").css("opacity", "0.5");
				$("footer").css("opacity", "0.5");
				flag2 = false;
			} else if (flag1 && !flag2) {//牆被按過按牆
				$("header").css("opacity", "1");
				$(".search").css("opacity", "1");
				$("#carouselExampleIndicatorsup").css("opacity", "1")
				$(".forcard").css("opacity", "1");
				$("footer").css("opacity", "1");
				flag2 = true;
			} else if (!flag1 && flag2) {//卡被按過按牆
				$("header").css("opacity", "0.5");
				$(".search").css("opacity", "0.5");
				$(".forcard").css("opacity", "0.5");
				$("footer").css("opacity", "0.5");
				$("#carouselExampleIndicatorsup").css("opacity", "1")
				flag2 = false;
			} else {
				$("header").css("opacity", "1");
				$(".search").css("opacity", "1");
				$("#carouselExampleIndicatorsup").css("opacity", "1")
				$(".forcard").css("opacity", "1");
				$("footer").css("opacity", "1");
				flag2 = true;
			}

		}
	}

	$(function() {
		window.addEventListener("message", receiveMessage);
	});
	//---------------------------------------------------------------------------------------------------------------------------
	$(document).ready(function() {	
		//傳值iframe-----------------------
		$('.forcard').click(function() {
			window.parent.postMessage("card", '*');
		})
		$("#carouselExampleIndicatorsup").click(function() {
			window.parent.postMessage("wall", '*');
		});

	})
		