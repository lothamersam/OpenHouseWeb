$("#auditionForm").submit(function (event) {
	$("#dateText").val($("#datesList option:selected").html())
	$("#timeText").val($("#timeSlots option:selected").html())
    let contactFormData = $("#auditionForm").serialize();

    $.post("/do/signup/add", contactFormData, function (response) {
        Materialize.toast(response["message"], 4000);
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

