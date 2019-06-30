<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="tags" %>


<html>
<tags:meta title="Home" />

<body>
	<tags:header />

	<div class="row container top-row">
		<c:forEach items="${staffMembers}" var="member" varStatus="status">
			<div class="col s12 m12 l4">
				<div class="card">
					<div class="card-image">
						<img src="${member.imagePath}" class="circle responsive-img">
						<a class="btn-floating halfway-fab waves-effect waves-light red modal-trigger"
							href="#${member.firstName}"><i class="material-icons">create</i></a>
					</div>
					<div class="card-content">
						<span class="card-title"><strong>${member.firstName} ${member.lastName}</strong></span>
						<span class="card-title flow-text" style="font-size:100%;">${member.title}</span>
					</div>
					<div class="card-action">
						<a class="modal-trigger" href="#${member.firstName}">Read about ${member.firstName}</a>
					</div>
				</div>
			</div>
			<c:if test="${status.index != 0 && status.index % 3 == 0}">
				</div>
				<div class="row container top-row">
			</c:if>
		</c:forEach>
	</div>

	<c:forEach items="${staffMembers}" var="member">
		<div id="${member.firstName}" class="modal modal-fixed-footer">
			<div class="modal-content">
				<div class="row">
					<div class="col s12 m4 l4">
						<img src="${member.imagePath}" class="circle responsive-img">
						<br><br>
						<span class="flow-text"><strong>${member.firstName} ${member.lastName}</strong></span>
						<br>
						<span>${member.title}</span>
					</div>
					<div class="col s12 m8 l8">
						<p>${member.bio}</p>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Done</a>
			</div>
		</div>
	</c:forEach>

	<tags:footer />

	<script src="/static/js/standardPage.js"></script>
</body>

</html>