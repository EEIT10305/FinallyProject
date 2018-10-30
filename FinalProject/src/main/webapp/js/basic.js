$(document).ready(function() {
		//篩選器
		$('button[name="becheckbtn"]').next().hide();
		$('button.menuitemstyle').click(function() {
			$(this).parent().siblings(".btnwidth").text($(this).text());
		})
		$('button[name="category"]').click(function() {
			$('button[name="becheckbtn"]').hide();
			$('button[name="becheckbtn"]').next().show();
			// 這裡可以加動態產生的品牌或價格選項
		})

		
		$('#test').mouseover(function() {
			$("fieldset").show();
		});
		$('#test').mouseout(function() {
			if (!$(".mymodal:hover").length) {
				$("fieldset").hide();
			}
		})
	})