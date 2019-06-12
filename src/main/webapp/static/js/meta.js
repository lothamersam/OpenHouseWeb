$(document).ready(function () {
    $(".dropdown-trigger").dropdown();
    $(".button-collapse").sideNav();
    $('.parallax').parallax();
    $('.scrollspy').scrollSpy();

    $('.table-of-contents').pushpin({
        top: 500,
        offset: 0
      });

    var typed = new Typed('.element', {
        strings: ["", "inclusive.", "educational.", "accessible."],
        typeSpeed: 20,
        backSpeed: 20,
        backDelay: 2000,
        loop: true,
        loopCount: 3
    });
});



