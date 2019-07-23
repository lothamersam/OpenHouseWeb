<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<html>
<tags:meta title="Contact" />

<body>
	<main> <tags:adminHeader />

	<div class="container row">
		<div class="row top-row">
			<div id="contactSection" class="card section scrollspy hoverable tooltipped"
				data-position="top" data-delay="200"
				data-tooltip="Click to edit section">
				<div class="card-content">
					<span class="card-title">Contact Our Team</span>
					<span id="sectionContent">${contactSection.sectionContent}</span>
				</div>
			</div>
		</div>
	</div>

	</main>

	<div id="editModal" class="modal modal-fixed-footer">
		<form action="/action/admin/contactChange" method="POST">
			<div class="modal-content">
				<div class="row">
					<div class="input-field col s12">
						<textarea name="content" id="sectionContentInput"
							class="materialize-textarea"
							placeholder="Enter section content..." required></textarea>
					</div>
				</div>
			</div>
			<input id="sectionType" type="hidden" name="sectionType" value="" />
			<div class="modal-footer">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Apply Edits<i class="material-icons right">add_box</i>
				</button>
			</div>
		</form>
	</div>

	<tags:footer />

	<script src="/static/js/standardPage.js"></script>
	<script lang="javascript" src="/static/js/adminContact.js"></script>
</body>

</html>