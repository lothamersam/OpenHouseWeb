<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="tags" %>

<html>
<tags:meta title="Contact" />

<body>
	<main>
		<tags:header />

		<div class="container row">
			<div class="row top-row">
				<form id="contactForm" class="col s12" action="/action/email">
					<div class="row">
						<div class="input-field col s6">
							<input name="firstName" id="first_name" type="text" class="validate" required>
							<label for="first_name">First Name</label>
						</div>
						<div class="input-field col s6">
							<input name="lastName" id="last_name" type="text" class="validate" required>
							<label for="last_name">Last Name</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input name="email" id="email" type="email" class="validate" required>
							<label for="email">Email</label>
						</div>
						<div class="input-field col s6">
							<input name="phoneNumber" id="icon_telephone" type="tel" class="validate">
							<label for="icon_telephone">Telephone</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<select name"subject" required>
								<option value="" disabled selected>Choose category</option>
								<option value="Sponsorship/Advertisment">Sponsorship/Advertisment</option>
								<option value="Performance">Performance</option>
								<option value="Audtion">Audition</option>
								<option value="Ticket">Ticketing</option>
								<option value="Contact Director">Contact the Executive Director</option>
								<option value="Other">Other</option>
							</select>
							<label>Message Subject</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<textarea name="message" id="textarea1" class="materialize-textarea" required></textarea>
							<label for="textarea1">Textarea</label>
						</div>
					</div>

					<button class="btn waves-effect waves-light" type="submit" name="action">Submit
						<i class="material-icons right">send</i>
					</button>
				</form>
			</div>
		</div>

	</main>

	<script src="/static/js/standardPage.js"></script>
	<script lang="javascript" src="/static/js/contact.js"></script>
</body>

</html>