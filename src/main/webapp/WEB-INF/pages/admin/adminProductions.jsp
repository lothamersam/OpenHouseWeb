<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<html>
<tags:meta title="Home" />

<body>
	<tags:header />

	<div class="container row">
		<div class="row top-row">
			<div class="card">
				<div class="card-content">

					<span class="card-title">Upcoming Productions</span>

					<div class="row">
						<div class="col l4 m12 s12">
							<h3>IMAGE COMING SOON</h3>
						</div>
						<div class="col l8 m12 s12">
							<table>
								<thead>
									<tr>
										<th>Date</th>
										<th>Time</th>
										<th>Location</th>
										<td><a href="#addDate"
											class="waves-effect waves-teal btn-flat modal-trigger tooltipped"
											data-position="top" data-delay="200"
											data-tooltip="Add an audition date"> <i
												class="material-icons">add_circle</i>
										</a></td>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${productionDates}" var="date">
										<tr>
											<td>${date.date}</td>
											<td>${date.startTime}-${date.endTime}</td>
											<td>${date.location}</td>
											<td><a href="/do/admin/date/delete/${date.id}/upcoming"
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
			<div class="card">
				<div id="productionSection" id="production"
					class="card section scrollspy hoverable tooltipped"
					data-position="top" data-delay="200"
					data-tooltip="Click to edit section">
					<div class="card-content">
						<span id="sectionContent">${productionSection.sectionContent}</span>
					</div>
				</div>
			</div>

			<div id="editModal" class="modal modal-fixed-footer">
				<form action="/do/admin/page/change/upcoming" method="POST">
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
					<input id="sectionType" type="hidden" name="isDate" value="false" />
					<div class="modal-footer">
						<button class="btn waves-effect waves-light" type="submit"
							name="action">
							Apply Edits<i class="material-icons right">add_box</i>
						</button>
					</div>
				</form>
			</div>

			<div id="addDate" class="modal modal-fixed-footer">
				<form action="/do/admin/date/add/upcoming" method="POST">
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
					<input id="sectionType" type="hidden" name="isDate" value="true" />
					<div class="modal-footer">
						<button class="btn waves-effect waves-light" type="submit"
							name="action">
							Add Audition Date<i class="material-icons right">add_box</i>
						</button>
					</div>
				</form>
			</div>
		</div>

		<script src="/static/js/standardPage.js"></script>
		<script src="/static/js/adminPageSection.js"></script>

		<tags:footer />
</body>
</html>