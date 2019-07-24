<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<html>
<tags:meta title="Users" />

<body>
	<main> <tags:adminHeader />

	<div class="container row">
		<div class="row top-row">
			<div class="card">
				<div class="card-content">
					<span class="card-title">All users</span>

					<table>
						<thead>
							<tr>
								<th>Last, First</th>
								<th>UserName</th>
								<td><a href="#editModal"
									class="waves-effect waves-teal btn-flat modal-trigger tooltipped"
									data-position="top" data-delay="200" data-tooltip="Add user">
										<i class="material-icons">add_circle</i>
								</a></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${userList}" var="user">
								<tr>
									<td>${user.lastName},${user.firstName}</td>
									<td>${user.username}</td>
									<td><a href="/do/admin/users/delete/${user.id}"
										class="waves-effect waves-teal btn-flat"> <i
											class="material-icons">clear</i>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<div class="container row">
		<div class="card">
			<form action="/do/admin/users/change" method="POST">
			<div class="card-content">
				<span class="card-title">Change your password</span>
			
				<div class="row">
					<div class="input-field col s12">
						<input name="oldPass" id="password" type="password"
							class="validate"> <label for="password" minlength="8" required>Old
							Password</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input name="password" id="password" type="password"
							class="validate"> <label for="password" minlength="8" required>New
							Password</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input name="passwordValidate" id="password" type="password"
							class="validate"> <label for="password" minlength="8" required>New
							Password Validate</label>
					</div>
				</div>
			</div>
			<input type="hidden" name="id" value="" />
			<div class="modal-footer">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Add user<i class="material-icons right">add_box</i>
				</button>
			</div>
		</form>
		</div>	
	</div>

	</main>

	<div id="editModal" class="modal modal-fixed-footer">
		<form action="/do/admin/users/add" method="POST">
			<div class="modal-content">
				<div class="row">
					<div class="input-field col s12">
						<input name="firstName" id="firstName" type="text"
							class="validate"> <label for="firstName" required>First
							Name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input name="lastName" id="lastName" type="text" class="validate">
						<label for="lastName" required>Last Name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input name="username" id="username" type="text" class="validate">
						<label for="username" minlength="3" required> Username</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input name="password" id="password" type="password"
							class="validate"> <label for="password" minlength="8" required>Temporary
							Password</label>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					Add user<i class="material-icons right">add_box</i>
				</button>
			</div>
		</form>
	</div>

	<tags:footer />

	<script src="/static/js/standardPage.js"></script>
	<script lang="javascript" src="/static/js/adminPageSection.js"></script>
</body>

</html>
