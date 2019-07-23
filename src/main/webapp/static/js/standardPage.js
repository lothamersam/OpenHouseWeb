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
    

    $('.datepicker').pickadate({
      selectMonths: true, // Creates a dropdown to control month
      selectYears: 15, // Creates a dropdown of 15 years to control year,
      today: 'Today',
      clear: 'Clear',
      close: 'Ok',
      closeOnSelect: false // Close upon selecting a date,
    container: undefined, // ex. 'body' will append picker to body
    });
    
    $('.timepicker').pickatime({
    	default: 'now', // Set default time: 'now', '1:30AM', '16:30'
    	fromnow: 0,
    	twelvehour: false, // Use AM/PM or 24-hour format
    	donetext: 'OK', // text for done-button
    	cleartext: 'Clear', // text for clear-button
    	canceltext: 'Cancel', // Text for cancel-button,
    	container: undefined, // ex. 'body' will append picker to body
    	autoclose: false, // automatic close timepicker
    	ampmclickable: true, // make AM PM clickable
    	aftershow: function(){} // Function for after opening timepicker
    });
});