﻿		<!-- 模态框（Modal） -->
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改员工信息</h4>
					</div>
					<div class="modal-body">
						<!-- 修改信息的表单 -->
						<form class="form-horizontal" role="form">
						<!-- ID栏 -->
							<div class="form-group">	
							<label for="firstname" class="col-sm-2 control-label" id="s">ID</label>		
								<div class="col-sm-10 ">
									<input type="text" class="form-control" name="workerNum" id="workerNum" readonly="true" placeholder="请输入ID">
								</div>
							</div>
						<!-- 姓名栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-10">
									<input type="text" class="form-control"  name="workerName" id="workerName" placeholder="请输入姓名">
								</div>
							</div>
						<!-- 密码栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">密码</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="workerPwd" id="workerPwd" placeholder="请输入密码">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">电话</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="workerTele" id="workerTele" placeholder="请输入电话">
								</div>
							</div>
						<!-- 电话栏 -->
							<div class="form-group">
								<label for="lastname" class="col-sm-2 control-label">地址</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="workerAdd" id="workerAdd" placeholder="请输入地址">
								</div>
							</div>
						</form>
					</div>
					<!-- 按钮 -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				
						<button type="button" class="btn btn-primary" id="update" onclick="UpdateStaff()">修改</button>
					</div>
				</div>		
			</div>
		</div>