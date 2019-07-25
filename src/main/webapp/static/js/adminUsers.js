$("#passChange").submit(function (event) {
    let passChangeData = $("#passChange").serialize();

    if(checkFields()) {    
    	$.post("/do/admin/users/change", passChangeData, function (response) {
    		Materialize.toast(response["message"]);
    		$("#formReset").click();
    	})
    	.fail(function (response) {
    		Materialize.toast("There an error changing your password, please try again!", 4000);
    	});
    }

    return false;
})

function checkFields() {
	success = true;
	
	if($("#password").val() != $("#passwordValidate").val()){
		success = false;
		Materialize.toast("Passwords do not match!", 4000);
	}
	
	return success;
}
