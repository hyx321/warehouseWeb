//将选中的那一行的 ID 信息赋值到 modal 中的 id 上
function updated(ID) {
	
	$.ajax({
		url:"/warehouseBeta/Staff/GetStaff",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{	
			ID:ID
		},
 
		success:function(meg){
			var inf = JSON.parse(meg)[0];
			
			$('#workerNum').val(ID);
			$('#workerName').val(inf.name);
			$('#workerPwd').val(inf.password);
			$('#workerTele').val(inf.telephone);
			$('#workerAdd').val(inf.address);
		
			$('#deleteWorkerNum').val(ID);
			$('#deleteWorkerName').val(inf.name);
			$('#deleteWorkerPwd').val(inf.password);
			$('#deleteWorkerTele').val(inf.telephone);
			$('#deleteWorkerAdd').val(inf.address);
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//删除员工的信息
function DeleteStaff() {
	var workerNum = document.getElementById("deleteWorkerNum").value;	
	$.ajax({
		url:"/warehouseBeta/Staff/DeleteStaff",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			ID:workerNum
		},
 
		success:function(meg){
			location.replace("/warehouseBeta/Staff/StaffList");
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//更新员工的信息
function UpdateStaff(){
	//获取modal中的各个信息
	var workerNum = document.getElementById("workerNum").value;
	var workerName = document.getElementById("workerName").value;
	var workerPwd = document.getElementById("workerPwd").value;
	var workerTele = document.getElementById("workerTele").value;
	var workerAdd = document.getElementById("workerAdd").value;
	$.ajax({
		url:"/warehouseBeta/Staff/UpdateStaff",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			id:workerNum,
			name:workerName,
			password:workerPwd,
			telephone:workerTele,
			address:workerAdd
		},
		success:function(meg){
			location.replace("/warehouseBeta/Staff/StaffList");		
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}

//新增员工
function AddStaff(){
	//获取modal中的各个信息
	var workerName = document.getElementById("addWorkerName").value;
	var workerPwd = document.getElementById("addWorkerPwd").value;
	var workerTele = document.getElementById("addWorkerTele").value;
	var workerAdd = document.getElementById("addWorkerAdd").value;
	/*alert(workerName+""+workerPwd+""+workerTele+""+workerAdd);*/
	$.ajax({
		url:"/warehouseBeta/Staff/AddStaff",
		type:'POST',
		contentType: "application/x-www-form-urlencoded;charset=UTF-8",
		data:{
			name:workerName,
			password:workerPwd,
			telephone:workerTele,
			address:workerAdd
		},
 
		success:function(meg){
			location.replace("/warehouseBeta/Staff/StaffList");
			
		},
		 error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            }
	});
}