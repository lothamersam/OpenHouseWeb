<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<html>
<tags:meta title="Home" />

<body>
	<main> <tags:adminHeader />

	<div class="container row">
		<div class="col s12 m9 l10">
			<div>
				<h3>Introduction</h3>
				<div id="homeTop" class="section scrollspy hoverable tooltipped"
					data-position="top" data-delay="200"
					data-tooltip="Click to edit section">
					<span id="sectionContent">${homeTop.sectionContent}</span>
				</div>
			</div>

			<div id="community" class="section scrollspy">
				<h3>Community</h3>
				<ul class="collapsible popout" data-collapsible="expandable">
					<li>
						<div class="collapsible-header active">
							<i class="material-icons">filter_drama</i>First
						</div>
						<div id="homeCollapseOne"
							class="collapsible-body hoverable tooltipped" data-position="top"
							data-delay="200" data-tooltip="Click to edit section">
							<span id="sectionContent">${homeCollapseOne.sectionContent}</span>
						</div>
					</li>
					<li>
						<div class="collapsible-header">
							<i class="material-icons">place</i>Second
						</div>
						<div id="homeCollapseTwo"
							class="collapsible-body hoverable tooltipped" data-position="top"
							data-delay="200" data-tooltip="Click to edit section">
							<span id="sectionContent">${homeCollapseTwo.sectionContent}</span>
						</div>
					</li>
					<li>
						<div class="collapsible-header">
							<i class="material-icons">whatshot</i>Third
						</div>
						<div id="homeCollapseThree"
							class="collapsible-body hoverable tooltipped" data-position="top"
							data-delay="200" data-tooltip="Click to edit section">
							<span id="sectionContent">${homeCollapseThree.sectionContent}</span>
						</div>
					</li>
				</ul>
			</div>

			<div id="involvement" class="section scrollspy">
				<h3>Involvement</h3>
				<div class="row">
					<div id="homeColOne" class="col l4 m12 s12 hoverable tooltipped"
						data-position="top" data-delay="200"
						data-tooltip="Click to edit section">
						<div class="center promo">
							<i class="material-icons cyan-text">flash_on</i>
							<p class="promo-caption">Get invloved fast</p>
							<p class="light center">
								<span id="sectionContent">${homeColOne.sectionContent}</span>
							</p>
						</div>
					</div>
					<div id="homeColTwo" class="col l4 m12 s12 hoverable tooltipped"
						data-position="top" data-delay="200"
						data-tooltip="Click to edit section">
						<div class="center promo">
							<i class="material-icons cyan-text">group</i>
							<p class="promo-caption">Experience Focused</p>
							<p class="light center">
								<span id="sectionContent">${homeColTwo.sectionContent}</span>
							</p>
						</div>
					</div>
					<div id="homeColThree" class="col l4 m12 s12 hoverable tooltipped"
						data-position="top" data-delay="200"
						data-tooltip="Click to edit section">
						<div class="center promo">
							<i class="material-icons cyan-text">settings</i>
							<p class="promo-caption">Easy to work with</p>
							<p class="light center">
								<span id="sectionContent">${homeColThree.sectionContent}</span>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col hide-on-small-only m3 l2">
			<ul class="section table-of-contents">
				<li><a href="#homeTop">Introduction</a></li>
				<li><a href="#community">Community</a></li>
				<li><a href="#involvement">Involvement</a></li>
			</ul>
		</div>
	</div>
	</main>

	<div id="editModal" class="modal modal-fixed-footer">
		<form action="/action/admin/homeChange" method="POST">
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

	<script language="javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/typed.js/2.0.10/typed.min.js"></script>
	<script language="javascript" src="/static/js/standardPage.js"></script>
	<script language="javascript" src="/static/js/home.js"></script>
	<script language="javascript" src="/static/js/adminPageSection.js"></script>

</body>

</html>