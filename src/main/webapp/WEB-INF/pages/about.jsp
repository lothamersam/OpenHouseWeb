<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<html>
<tags:meta title="Home" />

<body>
	<main> <tags:header />

	<div class="container row top-row">
		<div class="col s12 m9 l10">
			<img class="center-content img responsive-img"
				src="/static/img/logo.png" alt="Open House Logo"
				title="Open House Theatre Company" />

			<div id="introduction" class="card section scrollspy">
				<div class="card-content">
					<span class="card-title">About Our Organization</span>

					${aboutUsSnippet}
				</div>
			</div>

			<div class="row">
				<div id="location" class="section scrollspy col s4">${organizationAddress}</div>
				<div class="col s8">
					<iframe width="100%" height="50%" frameborder="0"
						style="border: 0"
						src="https://www.google.com/maps/embed/v1/place?q=place_id:ChIJoWECiUZ1F4gRTAgu-YkgCCQ&key=AIzaSyA_rZXfAdHNDmsCnSKfkdJlNhTvVY09zps"
						allowfullscreen></iframe>
				</div>
			</div>

			<div id="involvement" class="section scrollspy top-row"
				style="clear: both;">
				<h4 class="center-align">Get Involved</h4>

				<div class="row">
					<div class="col s4">
						<div class="center promo">
							<i class="material-icons cyan-text">flash_on</i>
							<p class="promo-caption">Get invloved fast</p>
							<p class="light center">Lorem ipsum dolor sit amet
								consectetur, adipiscing elit duis nascetur.</p>
						</div>
					</div>
					<div class="col s4">
						<div class="center promo">
							<i class="material-icons cyan-text">group</i>
							<p class="promo-caption">Experience Focused</p>
							<p class="light center">Lorem ipsum dolor sit amet
								consectetur, adipiscing elit duis nascetur.</p>
						</div>
					</div>
					<div class="col s4">
						<div class="center promo">
							<i class="material-icons cyan-text">settings</i>
							<p class="promo-caption">Easy to work with</p>
							<p class="light center">Lorem ipsum dolor sit amet
								consectetur, adipiscing elit duis nascetur.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col hide-on-small-only m3 l2">
			<ul class="section table-of-contents">
				<li><a href="#introduction">About Us</a></li>
				<li><a href="#location">Our Location</a></li>
				<li><a href="#involvement">Get Involved</a></li>
			</ul>
		</div>
	</div>
	</main>

	<script src="/static/js/standardPage.js"></script>

	<tags:footer />
</body>

</html>
