<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<html>
<tags:meta title="Home" />

<body>
	<main> <tags:adminHeader />

	<div class="container row top-row">
		<div class="col s12 m9 l10">
			<div class="row">
				<div id="auditionInformation"
					class="card section scrollspy hoverable tooltipped"
					data-position="top" data-delay="200"
					data-tooltip="Click to edit section">
					<div class="card-content">
						<span class="card-title">Audition Information:</span> <span
							id="sectionContent">${auditionInformation.sectionContent}</span>
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
							<td><a href="#addDate"
								class="waves-effect waves-teal btn-flat modal-trigger tooltipped"
								data-position="top" data-delay="200"
								data-tooltip="Add an audition date"> <i
									class="material-icons">add_circle</i>
							</a></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${auditionDates}" var="date">
							<tr>
								<td>${date.date}</td>
								<td>${date.startTime}-${date.endTime}</td>
								<td>${date.location}</td>
								<td>${date.information}</td>
								<td><a
									href="/do/admin/date/delete/${date.id}/auditions"
									class="waves-effect waves-teal btn-flat"> <i
										class="material-icons">clear</i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div id="signUp" class="row section scrollspy">
				<h4>Audition Signups:</h4>

				<table>
					<thead>
						<tr>
							<th>Last, First</th>
							<th>Pronoun</th>
							<th>Date</th>
							<th>Email</th>
							<th>Phone</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${signupInformation}" var="signup">
							<tr>
								<td>${signup.lastName}, ${signup.firstName}</td>
								<td>${signup.pronouns}</td>
								<td>${signup.date}</td>
								<td>${signup.email}</td>
								<td>${signup.phoneNumber}</td>
								<td><a
									href="/do/admin/signup/delete/${signup.id}/auditions"
									class="waves-effect waves-teal btn-flat"> <i
										class="material-icons">clear</i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<div class="col hide-on-small-only m3 l2">
			<ul class="section table-of-contents">
				<li><a href="#dates">Audition Dates</a></li>
				<li><a href="#auditionInformation">Audition Information</a></li>
				<li><a href="#signUp">Sign Up</a></li>
			</ul>
		</div>
	</div>
	</main>

	<div id="editModal" class="modal modal-fixed-footer">
		<form action="/do/admin/page/change/auditions" method="POST">
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

	<div id="addDate" class="modal modal-fixed-footer">
		<form action="/do/admin/date/add/auditions" method="POST">
			<div class="modal-content">
				<div class="row">
					<div class="input-field col s6">
						<input name="date" type="text" class="datepicker"
							placeholder="Date" required>
					</div>
					<div class="input-field col s6">
						<input name="location" type="text" required> <label
							for="location">Location</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input name="time" type="text" class="timepicker"
							placeholder="Start Time" required>
					</div>
					<div class="input-field col s6">
						<input name="endTime" type="text" class="timepicker"
							placeholder="End Time" required>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<textarea name="information" id="sectionContentInput"
							class="materialize-textarea"
							placeholder="Enter date information..." required></textarea>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Add Audition Date<i class="material-icons right">add_box</i>
				</button>
			</div>
		</form>
	</div>

	<script src="/static/js/standardPage.js"></script>
	<script src="/static/js/adminPageSection.js"></script>

	<tags:footer />
</body>

</html>
