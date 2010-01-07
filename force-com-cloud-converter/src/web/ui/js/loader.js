
function showLoader() {
	var div = document.getElementById("loading");
	var formDiv = document.getElementById("form");
	if (div.style.display == "none") {
		div.style.display = "";
		formDiv.style.display = "none";
	} else {
		div.style.display = "none";
		formDiv.style.display = "";
	}
}
function hideLoader() {
	var div = document.getElementById("loading");
	var formDiv = document.getElementById("form");
	div.style.display = "none";
	formDiv.style.display = "";
}

