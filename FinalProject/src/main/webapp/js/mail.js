$(document).ready(function(){
	$("#mymail").children(":last-child").click(function(){
		$("#mailpage").show();
		$("#mymail").hide();
	})
	 $("#mailpage").hide();
	$("#mailshow").mouseover(function(){
	document.cookie = "test@gmail.com";
	var cookies = document.cookie;
	var cookie = cookies.split(";");
	var who = ""
	for(var i = 0 ; i < cookie.length ; i++){
		if(cookie[i].indexOf("email=") != -1){
			who = cookie[i].split("=")[1]
		}
	}
		$.post("MailController",{
			"who":who
		},function(data,status){
			if(status == "success"){
				var query = $.parseJSON(data);
			    var str = '<div style="text-align:center;line-height:30px;background:gainsboro;">未讀訊息</div>'
			    
			    
				$.each(query, function(index,json){			
					str += '<div value="'+json.message_id+'" class="toMail" style="cursor:pointer;margin:5px 0px;padding:5px;line-height:25px;background:floralwhite">'
					str += '<table class="mailtable"><tr>'
					str += '<td><p> From: '+json.memberidA.empname+'</p></td>'
					str += '<td><p>'+json.title+'</p></td>'
					str += '<td><p style="margin-right:0px;">'+json.date+'</p></td>'
				    str += "</tr></table></div>"

				})
				$("#mailcontent").html(str);
				
			    
				$(".toMail").click(function(){
					$("#mailpage").show();
					$("[id*='hehe']").hide();
					var id = $(this).attr("value");
					$("#hehe"+ id).show();
					$("#mymail").hide();
					$("#img" + id).attr("src","image/yet.png")
					$.post("ReadMail",{
						"id":id
					})
				})
			}
		})
		$.post("MailAllController",{
			"who":who
		},function(data,status){
			if(status == "success"){
				var query = $.parseJSON(data);
			    var str1_2 = '<div style="text-align:center;line-height:40px;background:gainsboro;">訊息</div>'
			    var str2 =''
				$.each(query, function(index,json){			
					str1_2 += '<div value="'+json.message_id+'" class="toMail" style="cursor:pointer;margin:5px 0px;padding:5px;line-height:25px;background:floralwhite">'
					str1_2 += '<table class="mailtable2"><tr>'
					str1_2 += '<td><p> From: '+json.memberidA.empname+'</p>'
					str1_2 += '<p>'+json.title+'</p></td>'
					str1_2 += '<td><span style="margin-right:0px;">'+json.date+'  </span>'
					str1_2 += '<span style="margin-left:5px"><img id="img'+json.message_id+'" src="image/'+json.readstatu+'.png" width="20px" ></span></td>'
				    str1_2 += "</tr></table></div>"
				    
				    str2 += '<div id="hehe'+json.message_id+'" style="background-image:url(image/1327616d-e269-4691-946b-36cf76b668fcb.png);-webkit-background-size:100% 100%;display:none;width:70%;height:650px;margin:30px auto;padding-top:10%;padding-left:14%;line-height:30px;">'
					str2 += '<span style="font-size:24px;font-weight:bold">Title : </span><span>'+json.title+'</span><br>'
					str2 += '<span style="font-size:24px;font-weight:bold">From : </span><span>'+json.memberidA.empname+'</span><br>'
					str2 += '<span style="font-size:24px;font-weight:bold">Time : </span><span>'+json.date+'</span><br>'
					str2 += '<span style="font-size:24px;font-weight:bold">Content :</span><div style="padding-left:20px;"> <p>'+json.message.replace(/\\n/g,"<br>")+'<p></div>'
					str2 += "</div>"
				   
				})
				$("#mailblock").html(str1_2);
			    $("#mailpage").children().eq(0).html(str2);
			    
				$(".toMail").click(function(){
					click1('#mailpage');
					$("[id*='hehe']").hide();
					var id = $(this).attr("value");
					$("#hehe"+ id).show();
					$("#mymail").hide();
					$("#img" + id).attr("src","image/yet.png")
					$.post("ReadMail",{
						"id":id
					})
				})
			}
		})
	
	})
// 秉毅用的,查詢會員的訂單===========================================================






})
	