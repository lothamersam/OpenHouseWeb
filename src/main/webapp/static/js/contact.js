$("#contactForm").submit(function (event) {
    let contactFormData = $("#contactForm").serialize();

    $.post("/do/email/send", contactFormData, function (response) {
        Materialize.toast("Your email has been sent succesfully!", 4000);
        $("#contactForm").trigger("reset");
    })
    .fail(function (response) {
        Materialize.toast("There an error sending your email, please try again!", 4000);
    });

    return false;
})
