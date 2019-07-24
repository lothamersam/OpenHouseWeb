<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="tags" %>

<html>
<tags:meta title="Login" />

<body>
	<main>
		<tags:header />

		<div class="container row">
			<div class="row top-row">
				<form id="contactForm" class="col s12" action="/do/login">
					<div class="card">
						<div class="card-content">
							<span class="card-title">Login to Admin Dashboard:</span>
						</div>
						<div class="card-content">
							<div class="row">
								<div class="input-field col s12">
									<input name="username" id="username" type="text" class="validate" required>
									<label for="username">Username</label>
								</div>
                </div>
                <div class="row">
								<div class="input-field col s12">
									<input name="password" id="password" type="text" class="validate" required>
									<label for="password">Password</label>
								</div>
							</div>
				
							<button class="btn waves-effect waves-light cyan" type="submit" name="action">Submit
								<i class="material-icons right">send</i>
							</button>
							<button id="formReset" class="btn-flat waves-effect waves-cyan" type="reset" name="reset">Reset
								<i class="material-icons right">refresh</i>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>

	</main>

	<tags:footer />

	<script src="/static/js/standardPage.js"></script>
</body>

</html>
