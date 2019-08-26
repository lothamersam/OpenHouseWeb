<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="tags" %>


<html>
<tags:meta title="Home" />

<body>
	<main>
		<tags:homeHeader />

		<div class="container row">
			<div class="col s12 m9 l10">
				<div id="introduction" class="section scrollspy">
					<h3>Introduction</h3>
					<span>${homeTop.sectionContent}</span>
				</div>

				<div id="community" class="section scrollspy">
					<h3>Community</h3>
					<ul class="collapsible popout" data-collapsible="expandable">
						<li>
							<div class="collapsible-header active"><i class="material-icons">filter_drama</i>About Us</div>
							<div class="collapsible-body"><span>${homeCollapseOne.sectionContent}</span></div>
						</li>
						<li>
							<div class="collapsible-header"><i class="material-icons">place</i>Our Location</div>
							<div class="collapsible-body"><span>${homeCollapseTwo.sectionContent}</span></div>
						</li>
						<li>
							<div class="collapsible-header"><i class="material-icons">whatshot</i>Our Goal</div>
							<div class="collapsible-body"><span>${homeCollapseThree.sectionContent}</span></div>
						</li>
					</ul>
				</div>

				<div id="involvement" class="section scrollspy">
					<h3>Involvement</h3>
					<div class="row">
						<div class="col s4">
							<div class="center promo">
								<i class="material-icons cyan-text">flash_on</i>
								<p class="promo-caption">Get invloved fast</p>
								<p class="light center">${homeColOne.sectionContent}</p>
							</div>
						</div>
						<div class="col s4">
							<div class="center promo">
								<i class="material-icons cyan-text">group</i>
								<p class="promo-caption">Experience Focused</p>
								<p class="light center">${homeColTwo.sectionContent}</p>
							</div>
						</div>
						<div class="col s4">
							<div class="center promo">
								<i class="material-icons cyan-text">settings</i>
								<p class="promo-caption">Easy to work with</p>
								<p class="light center">${homeColThree.sectionContent}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col hide-on-small-only m3 l2">
				<ul class="section table-of-contents">
					<li><a href="#introduction">Introduction</a></li>
					<li><a href="#community">Community</a></li>
					<li><a href="#involvement">Involvement</a></li>
				</ul>
			</div>
		</div>
	</main>

	<tags:footer />

	<script language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/typed.js/2.0.10/typed.min.js"></script>
	<script language="javascript" src="/static/js/home.js"></script>
</body>

</html>
