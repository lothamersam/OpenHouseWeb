<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<html>
<tags:meta title="Home" />

<body>
	<main> <tags:header />

	<div class="container row top-row">
		<div class="col s12 m9 l10">
			<div id="date" class="row section scrollspy">
				<h5>Available Audition Dates:</h5>
				<table>
					<thead>
						<tr>
							<th>Date</th>
							<th>Time</th>
							<th>Location</th>
							<th>Additional Information</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${auditionDates}" var="date">
							<tr>
								<td>${date.date}</td>
								<td>${date.time}</td>
								<td>${date.location}</td>
								<td>${date.information}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div class="row">
				<div id="information" class="card section scrollspy">
					<div class="card-content">
						<span class="card-title">Audition Information:</span>

						${auditionInformation.sectionContent}
					</div>
				</div>
			</div>


			<div id="signUp" class="row section scrollspy">
				<h4>Sign up to audition:</h4>

				<form action="/action/audition" method="POST">

					<div class="row">
						<div class="row">
							<div class="input-field col s6">
								<input placeholder="Placeholder" id="first_name" type="text"
									class="validate"> <label for="first_name">First
									Name</label>
							</div>
							<div class="input-field col s6">
								<input id="last_name" type="text" class="validate"> <label
									for="last_name">Last Name</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<input disabled value="I am not editable" id="disabled"
									type="text" class="validate"> <label for="disabled">Disabled</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<input id="password" type="password" class="validate"> <label
									for="password">Password</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<input id="email" type="email" class="validate"> <label
									for="email">Email</label>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="col hide-on-small-only m3 l2">
			<ul class="section table-of-contents">
				<li><a href="#dates">Audition Dates</a></li>
				<li><a href="#information">Audition Information</a></li>
				<li><a href="#signUp">Sign Up</a></li>
			</ul>
		</div>
	</div>
	</main>

	<script src="/static/js/standardPage.js"></script>

	<tags:footer />
</body>

</html>