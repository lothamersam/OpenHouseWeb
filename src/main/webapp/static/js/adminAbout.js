$("div.tooltipped").click(function() {
	$("#sectionType").val($(this).attr("id"))
	$(".trumbowyg-editor").html($(this).find("#sectionContent:first").html())
	
	$("#editModal").modal('open')
});