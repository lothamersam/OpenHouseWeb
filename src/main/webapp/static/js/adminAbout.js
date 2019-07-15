$("div").click(function() {
	$("#name").val($(this).attr(id))
	$("#sectionContentInput").html($(this).find("#sectionContent:first").html())
	
	$("#editModal").show()
});