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
			<div class="row">
				<div id="information" class="card section scrollspy">
					<div class="card-content">
						<span class="card-title">Audition Information:</span>

						${auditionInformation.sectionContent}
					</div>
				</div>
			</div>			
			
			<div id="dates" class="row section scrollspy">
				<h5>Available Audition Dates:</h5>
				<table>
					<thead>
						<tr>
							<th>Date</th>
							<th>Time</th>
							<th>Location</th>
							<th>Information</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${auditionDates}" var="date">
							<tr>
								<td>${date.date}</td>
								<td>${date.startTime}-${date.endTime}</td>
								<td>${date.location}</td>
								<td>${date.information}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div id="signUp" class="row section scrollspy">
				<h4>Sign up to audition:</h4>

				<form id="auditionForm" action="/do/signup/add" method="POST">
					<div class="row">
						<div class="row">
							<div class="input-field col s6">
								<input name="first_name" id="first_name" type="text"
									class="validate"> <label for="first_name" required>First
									Name</label>
							</div>
							<div class="input-field col s6">
								<input name="last_name" id="last_name" type="text"
									class="validate"> <label for="last_name" required>Last
									Name</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s6">
								<select name="pronoun" required>
									<option value="" disabled selected>Choose Pronoun</option>
									<option value="he">He/Him/His</option>
									<option value="she">She/Her/Hers</option>
									<option value="they">They/them/Theirs</option>
								</select> <label>Pronouns</label>
							</div>
							<div class="input-field col s6">
								<input name="phone_number" id="phone_number" type="text"
									class="validate"> 
								<label for="phone_number" required>Phone Number</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s6">
								<select id="datesList" name="date" required>
									<option value="" disabled selected>Choose a Date</option>
									<c:forEach items="${auditionDates}" var="date">
										<option value="${date.id}">${date.date}</option>
									</c:forEach>
								</select> <label>Preferred Audition Date</label>
							</div>
							<div class="input-field col s6">
								<select id="timeSlots" name="time" required>
									<option value="" disabled selected>Please choose a date</option>
								</select> <label>Timeslot</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<input name="email" id="email" type="email" class="validate" required>
								<label for="email">Email</label>
							</div>
						</div>
					</div>
					
					<input id="dateText" type="hidden" name="dateText" value="" />
					<input id="timeText" type="hidden" name="timeText" value="" />
					<button class="btn waves-effect waves-light cyan" type="submit"
						name="action">
						Submit <i class="material-icons right">send</i>
					</button>
					<button id="formReset" class="btn-flat waves-effect waves-cyan" type="reset"
						name="reset">Reset<i class="material-icons right">refresh</i>
					</button>
				</form>
			</div>
		</div>

		<div class="col hide-on-small-only m3 l2">
			<ul class="section table-of-contents">
				<li><a href="#information">Audition Information</a></li>
				<li><a href="#dates">Audition Dates</a></li>
				<li><a href="#signUp">Sign Up</a></li>
			</ul>
		</div>
	</div>
	</main>

	<script src="/static/js/standardPage.js"></script>
	<script src="/static/js/audition.js"></script>

	<tags:footer />
</body>

</html>
