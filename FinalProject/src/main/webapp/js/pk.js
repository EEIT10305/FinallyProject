$(document).ready(function(){
	
	sessionStorage.CartId=1;
	
	
	$("#pro2").hide();
	$.ajax({
		type: "get",
		url: "pkSelectAll",				
		success: function (data) {
			var querydata = $.parseJSON(data);
			$("#pro1").append('<option  value="choose1">請選擇商品</option>')
//			$("#pro2").append('<option  value="choose2">請選擇商品</option>')
			$.each(querydata,function(index,json){
			    $("#pro1").append('<option value="'+ json.name+'">'+json.name+'</option>')
//			    $("#pro2").append('<option value="'+ json.name+'">'+json.name+'</option>')
			})
			
		}
	});
	
	
	$("#pro1").change(function(){
		sessionStorage.pk1=event.target.value;	
		$("#pro2").show();
		if($("#pro1").val()!="choose1"){
//			alert(sessionStorage.pk1)
		  $.ajax({
			  type: "post",
			  url: "showPinginDetail",
			  data: {"pkNo":sessionStorage.pk1},
			  success: function (data) {
				  var querydata = $.parseJSON(data)
				  var count = 2;
				  var countpro2 = 3;
				  $.each(querydata, function(index, json){
					  $('tbody tr td:eq(0)').html('<img src="image/'+json.name+'.jpg" width="300px">')
					  $('tbody tr td:eq('+ count +')').html(json.model)
					
					  
					   $('tbody tr td:eq(1)').html('')						  
					      $('tbody tr td:eq('+ countpro2 +')').html("");
//alert(json.model)
                           count = count+2;
					       countpro2 = countpro2+2;
				  })
				  $('tbody tr td:eq(16)').html('<a href="#" id="addToCart1"  class="btn btn-danger">加入購物車'+
                                  '<img src="image/shopping-cart (1).png" width="20px"></a>');
//				  document.getElementById("addToCart1").addEventListener("click",addToCart);
				  $("#addToCart1").click(addToCart1);
			  }
		  });	
		  $("#pro2").html("");
			$.ajax({
				type: "get",
				url: "pkSelectAll",				
				success: function (data) {
					var querydata = $.parseJSON(data);					
					$("#pro2").append('<option  value="choose2">請選擇商品</option>')
					$.each(querydata,function(index,json){
//					    $("#pro1").append('<option value="'+ json.name+'">'+json.name+'</option>')
						if(json.name!=sessionStorage.pk1){
							$("#pro2").append('<option value="'+ json.name+'">'+json.name+'</option>')							
						} else {
							$("#pro2").append('<option value="'+ json.name+'" disabled>'+json.name+'</option>')	
						}
					})
					
				}
			});
		  
		  
		  
		  
		  
		  
		}
	})	
	
	$("#pro2").change(function(){
		sessionStorage.pk2=event.target.value;	
		
		if($("#pro2").val()!="choose2"){
//			alert(sessionStorage.pk1)
		  $.ajax({
			  type: "post",
			  url: "showPinginDetail",
			  data: {"pkNo":sessionStorage.pk2},
			  success: function (data) {
				  var querydata = $.parseJSON(data)
				  var count = 3;
				  $.each(querydata, function(index, json){
					 					  
					      $('tbody tr td:eq(1)').html('<img src="image/'+json.name+'.jpg" width="300px">')						  
					      $('tbody tr td:eq('+ count +')').html(json.model)					  
					 
//alert(json.model)
                           count = count+2;
				  })
				  $('tbody tr td:eq(17)').html('<a href="#" id="addToCart2" class="btn btn-danger">加入購物車'+
                  '<img src="image/shopping-cart (1).png" width="20px"></a>');
//				  document.getElementById("addToCart2").addEventListener("click",addToCart);
				  $("#addToCart2").click(addToCart2);
			  }
		  });	
		}
	})	
	
	
	
	
	function addToCart1(){	
		$.post("showCartDetail",{"model":$('tbody tr td:eq(2)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(4)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(6)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(8)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(10)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(12)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(14)').html(),"CartId":sessionStorage.CartId})
		alert("加入購物車成功");
	}
	
	function addToCart2(){		
		$.post("showCartDetail",{"model":$('tbody tr td:eq(3)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(5)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(7)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(9)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(11)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(13)').html(),"CartId":sessionStorage.CartId})
		$.post("showCartDetail",{"model":$('tbody tr td:eq(15)').html(),"CartId":sessionStorage.CartId})
		alert("加入購物車成功");
	}
	
})