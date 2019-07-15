$("div.tooltipped").click(function() {
	$("#title").val($(this).attr("id"))
	$("#title").next().addClass("active")
	$(".trumbowyg-editor").html($(this).find("#sectionContent:first").html())
	
	$("#editModal").modal('open')
});