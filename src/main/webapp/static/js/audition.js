$("#auditionForm").submit(function (event) {
    let contactFormData = $("#auditionForm").serialize();

    $.post("/action/audition", contactFormData, function (response) {
        Materialize.toast("You have signed up succesfully!", 4000);
        $("#auditionForm").trigger("reset");
    })
    .fail(function (response) {
        Materialize.toast("There an error signing up, please try again!", 4000);
    });

    return false;
})
