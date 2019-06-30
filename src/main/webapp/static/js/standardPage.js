$(document).ready(function () {
    $(".dropdown-trigger").dropdown();
    $(".button-collapse").sideNav();
    $('.modal').modal();
    $(".button-collapse").sideNav();
    $('.parallax').parallax({
        height: 70
    });

    $('.scrollspy').scrollSpy();
    $('.collapsible').collapsible({
        accordion: true
    });

    $('.table-of-contents').pushpin({
        top: 300,
        offset: 0
    });

    $(document).ready(function () {
        $('select').material_select();
    });

    
});