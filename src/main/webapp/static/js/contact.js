$("#contactForm").submit(function (event) {
    let contactFormData = $("#contactForm").serialize();

    $.post("/do/email/send", contactFormData, function (response) {
        Materialize.toast(response["message"], 4000);
        $("#formReset").click();
    })
    .fail(function (response) {
        Materialize.toast("There an error sending your email, please try again!", 4000);
    });

    return false;
})
