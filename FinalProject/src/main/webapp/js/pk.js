$(document).ready(function(){
	$("#pro2").hide();
//	alert("Katniss!!!")
	$.ajax({
		type: "get",
		url: "pkSelectAll",				
		success: function (data) {
			var querydata = $.parseJSON(data);
			$("#pro1").append('<option  value="choose1">請選擇商品</option>')
			$("#pro2").append('<option  value="choose2">請選擇商品</option>')
			$.each(querydata,function(index,json){
			    $("#pro1").append('<option value="'+ json.name+'">'+json.name+'</option>')
			    $("#pro2").append('<option value="'+ json.name+'">'+json.name+'</option>')
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
				  $.each(querydata, function(index, json){
					  $('tbody tr td:eq(0)').html('<img src="image/'+json.name+'.jpg" width="300px">')
					  $('tbody tr td:eq('+ count +')').html(json.model)
					  
//alert(json.model)
                           count = count+2;
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
			  }
		  });	
		}
	})	
	
})