window.onload = function () {
	new Vue({
		el: '#userManagerPage',
		data: function () {
			var _this = this;
			return {
				tableData: [{
					id: 1,
					userName: 'zms_1',
					createTime: '2019-01-29 13:48:00'
				}, {
					id: 2,
					userName: 'zms_2',
					createTime: '2019-01-29 13:49:00'
				}, {
					id: 3,
					userName: 'zms_3',
					createTime: '2019-01-29 13:50:00'
				}],
				dialog: {
					dialogVisible: false,
					dialogVisiblePwd: false,
					addForm: {
						name: '',
						password: '',
						confirmPwd: ''
					},
					pwdForm: {
						oldPwd: '',
						password: '',
						confirmPwd: ''
					}
				}
			}
		},
		mounted: function () {
		},
		methods: {
			/**
			 * 新增用户
			 * @param formName-表单名
			 */
			addUser: function (formName) {
				var _this = this;
				var data = _this.$refs[formName].model;
				// RSA 加密密码
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(window.sessionStorage.publicKey);
				data.password = encrypt.encrypt(data.password);
				data.confirmPwd = encrypt.encrypt(data.confirmPwd);
				// 新增请求
				fetch('/api/user/add', {
					method: 'POST',
					cache: 'no-cache',
					body: JSON.stringify(data),
					headers: {
						'content-type': 'application/json'
					}
				}).then(function (response) {
					return response.json();
				}).then(function (myJson) {
					_this.resetForm('addForm');
					_this.$message({type: myJson.code == 0 ? 'info' : 'warning', message: myJson.message});
					// 新增成功隐藏表单
					if (myJson.code == 0) {
						_this.dialog.dialogVisible = false;
					}
				}).catch(function (reason) {
					console.log(reason);
				});
			},
			/**
			 * 密码修改
			 * @param formName-表单名
			 */
			pwdModify: function (formName) {
				var _this = this;
				// TODO 需要先判断是否选中数据
				// var selections = _this.$refs.tableName.selections;
				// TODO 在修改密码之前需要将表单内容绑定到table选中的数据中
				var data = {
					id: '2',
					oldPwd: _this.$refs[formName].model.oldPwd,
					password: _this.$refs[formName].model.password,
					confirmPwd: _this.$refs[formName].model.confirmPwd
				};
				// RSA 加密密码
				var encrypt = new JSEncrypt();
				encrypt.setPublicKey(window.sessionStorage.publicKey);
				data.oldPwd = encrypt.encrypt(data.oldPwd);
				data.password = encrypt.encrypt(data.password);
				data.confirmPwd = encrypt.encrypt(data.confirmPwd);
				// 更新请求
				fetch('/api/user/update', {
					method: 'POST',
					cache: 'no-cache',
					body: JSON.stringify(data),
					headers: {
						'content-type': 'application/json'
					}
				}).then(function (response) {
					return response.json();
				}).then(function (myJson) {
					_this.resetForm('pwdForm');
					_this.$message({type: myJson.code == 0 ? 'info' : 'warning', message: myJson.message});
					// 修改成功后隐藏表单
					if (myJson.code == 0) {
						_this.dialog.dialogVisiblePwd = false;
					}
				}).catch(function (reason) {
					console.log(reason);
				});
			},
			/**
			 * 删除用户
			 */
			deleteUser: function () {
				var _this = this;
				// TODO 需要先判断是否选中数据,删除前的确认confirm
				// 删除请求
				fetch('/api/user/delete/' + '219af17f-59a8-4771-a09b-e4f71b5d5359', {
					method: 'POST',
					cache: 'no-cache',
					headers: {
						'content-type': 'application/json'
					}
				}).then(function (response) {
					return response.json();
				}).then(function (myJson) {
					_this.$message({type: myJson.code == 0 ? 'info' : 'warning', message: myJson.message});
				}).catch(function (reason) {
					console.log(reason);
				});
			},
			/**
			 * 重置表单
			 * @param formName-表单名
			 */
			resetForm: function (formName) {
				var _this = this;
				this.$nextTick(function () {
					_this.$refs[formName].resetFields();
				});
			},
			/**
			 * 取消按钮
			 * @param forName-表单名
			 */
			cancleFn:function (forName) {
				this.resetForm(forName);
				if(forName=='addForm'){
					this.dialog.dialogVisible = false;
				}else if(forName=='pwdForm'){
					this.dialog.dialogVisiblePwd = false;
				}
			},
			stop:function () {
				fetch('http://localhost:8861/actuator/shutdown', {
					method: 'POST',
					cache: 'no-cache',
					headers: {
						'content-type': 'application/json'
					}
				}).then(function (response) {
					return response.json();
				}).then(function (myJson) {
					_this.$message({type: myJson.code == 0 ? 'info' : 'warning', message: myJson.message});
				}).catch(function (reason) {
					console.log(reason);
				});
			}
		}
	});
}