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

	$("#timeSlots").find('option').remove();

	$.get("/do/times/" + selectId, function (data) {
		for(let time in data["times"]) {
			$("#timeSlots").append("<option value=" + data["times"][time]["id"] + ">" + data["times"][time]["time"] + "</option>");
		}
		
		$("#timeSlots").material_select();
	});
});

