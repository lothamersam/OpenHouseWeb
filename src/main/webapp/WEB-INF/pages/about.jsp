<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<html>
<tags:meta title="Home" />

<body>
	<main> <tags:header />

	<div class="container row top-row">
		<div class="col s12 m9 l10">
			<h2 class="center-align">About Us</h2>
			<img class="center-content img responsive-img"
				src="/static/img/logo.png" alt="Open House Logo"
				title="Open House Theatre Company" />

			<div id="introduction" class="card">
				<div class="card-content">
					<span class="card-title">About Our Organization</span>

					${aboutUsSnippet}
				</div>
			</div>


			<iframe width="600" height="450" frameborder="0" style="border: 0"
				src="https://www.google.com/maps/embed/v1/search?q=Unitarian+Universalist+Community+Church+of+Southwest+Michigan&key=AIzaSyA_rZXfAdHNDmsCnSKfkdJlNhTvVY09zps"
				allowfullscreen></iframe>
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