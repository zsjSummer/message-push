window.onload = function () {
	new Vue({
		el: '#registPage',
		data: function () {
			return {}
		},
		mounted: function () {
		},
		methods: {
			route: function (pageName) {
				MyRouter(pageName);
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