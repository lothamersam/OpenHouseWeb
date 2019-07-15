$("div").click(function(event){
	$("#sectionContentInput").val(event.target.find("#sectionContent:first").val())
});