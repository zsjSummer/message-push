window.onload = function () {

	document.querySelector("#send").onclick = function() {
		var content = document.querySelector("#content").value;
		fetch('/push/' + content, {
			method: 'GET',
			cache: 'no-cache',
			headers: {
				'content-type': 'application/json'
			}
		}).then(function (response) {
			return response.json();
		}).then(function (myJson) {
			console.log(myJson);
		});
	}
};