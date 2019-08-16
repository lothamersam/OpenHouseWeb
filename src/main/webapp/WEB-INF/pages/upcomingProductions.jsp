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
							<img class="responsive-img" src="/static/img/our-town.jpg" title="Our Town Poster" alt="Our Town Poster" />
						</div>
						<div class="col l8 m12 s12">
							<table>
								<thead>
									<tr>
										<th>Date</th>
										<th>Time</th>
										<th>Location</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${productionDates}" var="date">
										<tr>
											<td>${date.date}</td>
											<td>${date.startTime}-${date.endTime}</td>
											<td>${date.location}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="card">
				<div class="card-content">${productionSection.sectionContent}</div>
			</div>
		</div>
	</div>

	<tags:footer />
</body>
</html>