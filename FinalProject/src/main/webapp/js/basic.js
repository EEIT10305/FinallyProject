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
	
		$('#test').mouseover(function(){
        	$("#myModal").show();
        });
        $('#test').mouseout(function () {
            if (!$('#myModal:hover').length) {
            	$("#myModal").hide();            	
            }
        })
		$('#mailshow').mouseover(function() {
			$("#mymail").show();
		});
		$('#mailshow').mouseout(function() {
			if (!$("#mymail:hover").length) {
				$("#mymail").hide();
			}
		})
		
		$('#lodinyes').mouseover(function() {
			$("#logoutbtn").show();
		});
		$('#lodinyes').mouseout(function() {
			if (!$("#logoutbtn:hover").length) {
				$("#logoutbtn").hide();
			}
		})
    	

	})