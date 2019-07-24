$("#auditionForm").submit(function (event) {
    let contactFormData = $("#auditionForm").serialize();

    $.post("/action/audition", contactFormData, function (response) {
        Materialize.toast("You have signed up succesfully!", 4000);
        $("#formReset").click();
    })
    .fail(function (response) {
        Materialize.toast("There an error signing up, please try again!", 4000);
    });

    return false;
});

$("#datesList").change(function() {
	let selectId = this.value;
	
	$.get("/do/times/" + selectId, function (data) {
		for(let time in data["times"]) {
			$("timesList").append($("<option>", { value : time["id"], text : time["time"] }));
		}
	});
});
