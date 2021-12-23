 function check(){
	let alertMsg = "";
	const form = document.getElementById("register_form");
	let item_kind = form.item_kind.value;
	let found_place = form.found_place.value;
	let found_at = form.found_at.value;
	let found_year = found_at.split("-")[0];
	let found_month = found_at.split("-")[1];
	let found_day = found_at.split("-")[2];
	
	if(item_kind == "" || item_kind.match(/^([1-8])$/) == null){
		alertMsg += "種類をえらんでください\n";
	}if(found_place == "" || found_place.match(/^([1-9])$/) == null ){
		alertMsg += "場所をえらんでください\n";
	}if(found_at == "" || found_year.match(/^([0-9]{4})$/) == null || found_month.match(/^(0[1-9]|1[0-2])$/)==null || found_day.match(/^(0[1-9]|[12][0-9]|3[01])$/)== null){
		alertMsg += "発見日をえらんでください\n";
	}
	if(alertMsg != ""){
		alert(alertMsg);
		return false;
	}
	return true;
}