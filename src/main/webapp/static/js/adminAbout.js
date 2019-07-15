$("div.tooltipped").click(function() {
	$("#title").val($(this).attr("id"))
	$(".trumbowyg-editor").html($(this).find("#sectionContent:first").html())
	
	$("#editModal").modal('open')
});