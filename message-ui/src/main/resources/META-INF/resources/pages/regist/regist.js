window.onload = function () {
	new Vue({
		el: '#registPage',
		data: function () {
			return {
				formPosition: 'left',
				registForm: {
					account: '',
					password: '',
					confirmPwd: ''
				}
			}
		},
		mounted: function () {
		},
		methods: {
			route: function (pageName) {
				MyRouter(pageName);
			},
			submit:function(formName){
				var _this = this;
				var data = _this.$refs[formName].model;
				// RSA 加密密码
				/*var encrypt = new JSEncrypt();
				encrypt.setPublicKey(_this.publicKey);
				data.password = encrypt.encrypt(data.password);*/
				// 注册请求
				/*fetch('/api/user/login', {
					method: 'POST',
					cache: 'no-cache',
					body: JSON.stringify(data),
					headers: {
						'content-type': 'application/json'
					}
				}).then(function (response) {
					return response.json();
				}).then(function (myJson) {
				});*/
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
			}
		}
	});
};