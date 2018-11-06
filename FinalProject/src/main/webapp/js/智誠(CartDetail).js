		$(document).ready(function() {
				$.post("ShowToCart",
							function(data, status) {		
							if (status == "success") {
									 temp = 0;
									var sum = 0;
									var esum = 0 ;
									exchange = 0 ; 
									var querydata = $.parseJSON(data);
 								$.each(querydata, function(index, json) {
 														//var x =  json.productBean.price *  index+1
 														//alert(x)
 														//alert(json.productBean.price)
 												var uuu = "select"+(index+1)
 										$("#show").append(
												"<tr><th>"+(index+1)+"</th><td>" + json.productBean.picture
 														+ "</td><td>"
 														+ json.productBean.model
														+ "</td><td>"
														+ json.productBean.price
 														+ "</td>"  
//  														+"<td><select id='select1'>"+
 														//+"<td><select id='select"+(index+1)+"'>"
 														+"<td><select id='"+uuu +"' name='"+uuu+"' onchange='chg()'>"
 														
 														+"</select></td></tr>"
										                );
 														
										
 												//sessionStorage.sel+(index+1) = $("#select2").val();
												//alert(sessionStorage.sel+(index+1))		
 										
											
 														
 										for(var i=1;i<=10 ;i++){
//  	 										var opt = $("<option>").val(i).text(i);
                                                 var opt = "<option value='" + i + "'>" + i + "</option>";
// 										  		$("#select"+(index+1)).append(opt);
                                                $("#"+uuu).append(opt);
 										  	
 										  	}
												
 												 esum = esum + json.productBean.price  * $("#"+uuu).val()
												alert(esum)
 								
												
												
												$("#"+uuu).change(function(){
												    temp = $("#"+uuu).val();
												    
												    sum = esum ;
												    sum = sum + json.productBean.price  * temp
												   
												    alert(sum)
													
												})
												
 													
												//	sum = sum + json.productBean.price  * $("#"+uuu).val()
												//	sessionStorage.sum = sum;
//  														alert("index" + index)
// 													alert("select" + uuu)
                                                    //    alert("$('#uuu'.val()) " +$("#"+uuu).val()) //nooooo
 												//	alert("sum" + sum)	
 										
									}
 								)
 								
 									
							
 									//alert(data)
 //									alert(json.parse(json.productBean.price))
//  									for(var i=1;i<=10 ;i++){
//  										var opt = $("<option>").val(i).text(i);
// 									  		$("#select1").append(opt);
// 									  	}
									
 								}
							else
								alert("你沒抓到")
							})
							
						$("#david").click(function(){
							alert(sessionStorage.sum);
						})	
 				})

//   $(document).on("#show",function(){
// 	  for(var i=1;i<=10 ;i++){
// 	  		var opt = $("<option>").val(i).text(i);
// 	  		$("#select1").append(opt);
// 	  	}
//   })

// function chg(){
// 	if(document.form1.select1.value != -1 && document.form1.select.value != -1){
// 		a1 = eval(document.form1.select1.value+"+"+document.form1.select.value);//選擇的值放入a
// 		alert(a1);
// 	}
// }

	


