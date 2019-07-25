$("#passChange").submit(function (event) {
    let passChangeData = $("#passChange").serialize();

    if(checkFields()) {    
    	$.post("/do/admin/users/change", passChangeData, function (response) {
    		Materialize.toast(respose["message"]);
    		$("#formReset").click();
    	})
    	.fail(function (response) {
    		Materialize.toast("There an error sending your email, please try again!", 4000);
    	});
    }

    return false;
})

function checkFields() {
	return true;
}
