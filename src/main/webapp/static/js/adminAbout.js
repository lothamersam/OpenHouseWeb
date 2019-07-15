$("div.tooltipped").click(function() {
	$("#title").val($(this).attr("id"))
	console.log($(this).find("#sectionContent:first").html())
	$("#sectionContentInput").html($(this).find("#sectionContent").html())
	
	$("#editModal").modal('open')
});