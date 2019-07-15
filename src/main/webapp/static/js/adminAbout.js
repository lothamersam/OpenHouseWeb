$("div.tooltipped").click(function() {
	$("#title").val($(this).attr("id"))
	$("#sectionContentInput").html($(this).find("#sectionContent:first").html())
	
	$("#editModal").modal('open')
});