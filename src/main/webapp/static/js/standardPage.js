$(document).ready(function () {
    $(".dropdown-trigger").dropdown();
    $(".button-collapse").sideNav();
    $('.modal').modal();
    $(".button-collapse").sideNav();
    $('select').material_select();
    $('.tooltipped').tooltip({delay: 50});
    $('.parallax').parallax({
        height: 70
    });

    $('.scrollspy').scrollSpy();
    $('.collapsible').collapsible({
        accordion: true
    });

    $('.table-of-contents').pushpin({
        top: 70,
        offset: 0
    });
    
    $('textarea').trumbowyg();
});