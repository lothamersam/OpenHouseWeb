$(document).ready(function () {
    $(".dropdown-trigger").dropdown();
    $(".button-collapse").sideNav();
    $('.parallax').parallax();

    var typed = new Typed('.element', {
        strings: ["", "inclusive.", "educational.", "accessible."],
        typeSpeed: 20,
        backSpeed: 20,
        backDelay: 2000,
        loop: true,
        loopCount: 3
    });
});



