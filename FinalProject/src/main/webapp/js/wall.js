$(document).ready(function() {
		 
		$.post("WallController",function(data, status) {
			if (status == "success") {
				var querydata = $.parseJSON(data);	
				var text ='<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">'
				 text +='<ol class="carousel-indicators">';
				$.each(querydata, function(index, json) {
					if(index == 0 ){
					    text +='<li data-target="#carouselExampleIndicators" data-slide-to="'+index+'" class="active" ></li>';						
					}else{
					    text +='<li data-target="#carouselExampleIndicators" data-slide-to="'+index+'"></li>';												
					}
				})
				text += '</ol><div class="carousel-inner">'
				$.each(querydata, function(index, json) {
					if(index == 0 ){
                	text +='<div class="carousel-item active"><img class="d-block w-100" src="'+json.photosrc+'"></div>'						
					}else{						
                	text +='<div class="carousel-item"><img class="d-block w-100" src="'+json.photosrc+'" ></div>'						
					}
				})
				text += '</div><a class="carousel-control-prev" href="#carouselExampleIndicators"role="button" data-slide="prev">'+
				'<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>'+
				'</a> <a class="carousel-control-next" href="#carouselExampleIndicators"'+
				'role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span></a></div>';
				$("#carouselExampleIndicatorsup").html(text);
			}})
		
		
	})