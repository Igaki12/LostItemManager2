 function check(){
	let alertMsg = "";
	const form = document.getElementById(register_form);
	let item_kind = form.item_kind.value;
	let found_place = form.found_place.value;
	
	if(item_kind == "" || item_kind.match(/^([1-8])$/) == null){
		alertMsg += "種類をえらんでください";
	}if(found_place == "" || found_place.match(/^([1-9])$/) == null ){
		alertMsg += "場所をえらんでください";
	}
	if(alertMsg != ""){
		alert(alertMsg);
		return false;
	}
	return true;
}