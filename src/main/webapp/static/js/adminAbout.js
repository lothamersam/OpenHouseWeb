$("div").click(function() {
	$("#name").val($(this).attr("id"))
	console.log($(this).attr("id"))
	$("#sectionContentInput").html($(this).find("#sectionContent:first").html())
	
	$("#editModal").modal('open')
});