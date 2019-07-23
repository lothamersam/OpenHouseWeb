$("#contactForm").submit(function (event) {
    let contactFormData = $("#contactForm").serialize();

    $.post("/action/email", contactFormData, function (response) {
        Materialize.toast("Your email has been sent succesfully!", 4000);
        $("#formReset").clcik();
    })
    .fail(function (response) {
        Materialize.toast("There an error sending your email, please try again!", 4000);
    });

    return false;
})
