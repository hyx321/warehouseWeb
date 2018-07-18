var Account ={
	Login:{
		LoginHandler:function isNum(){
			//账号密码不能为空
			$("#enter").click(function(){
				var name = document.getElementById("inputYourName").value;
				var password = document.getElementById("inputPassword").value;	
				if(name == "" || password == "")
				{
					alert("格式不对");
				}
				else{
					 window.location.href="/warehouseBeta/Staff/CheckLogin?name="+encodeURI(encodeURI(name))+"&password="+password;
					/*$.ajax({
						url:"/warehouseBeta/Staff/CheckLogin",
						type:'POST',
						data:{
							name:name,
							password:password
						},
				 
						success:function(meg){
							
						},
						 error: function(XMLHttpRequest, textStatus, errorThrown) {		                       
		                       alert(XMLHttpRequest.status+" "+XMLHttpRequest.readyState+" "+textStatus);
		              
		                    }
					});*/
				}
			})
		}
		
	}
	
}