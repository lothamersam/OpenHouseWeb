$("div").click(function() {
	$("#sectionContentInput").html($(this).find("#sectionContent:first").val())
});