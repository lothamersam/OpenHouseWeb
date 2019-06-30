<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="tags" %>


<html>
<tags:meta title="Home" />

<body>
	<tags:header />

	<div class="row container top-row">
		<c:forEach items="${staffMembers}" var="member">
			<div class="col s12 m12 l4">
				<div class="card">
					<div class="card-image">
						<img src="/static/img/director.jpg" class="circle responsive-img">
						<a class="btn-floating halfway-fab waves-effect waves-light red modal-trigger" href="#modal1"><i
								class="material-icons">add</i></a>
					</div>
					<div class="card-content">
						<span class="card-title"><strong>${member.firstName} ${member.lastName}</strong></span>
						<span class="card-title flow-text" style="font-size:100%;">${member.title}</span>
					</div>
					<div class="card-action">
						<a class="modal-trigger" href="#modal1">Read about ${member.firstName}</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<!-- Modal Structure -->
	<div id="modal1" class="modal modal-fixed-footer">
		<div class="modal-content">
			<div class="row">
				<div class="col s12 m4 l4">
					<img src="/static/img/director.jpg" class="circle responsive-img">
					<br><br>
					<span class="flow-text"><strong>Nicholas Sienkiewicz</strong></span>
					<br>
					<span>Executive Director/Co-founder</span>
				</div>
				<div class="col s12 m8 l8">
					<p>Nick grew up in a small, rural town on the eastern side of the state where he lived with his
						parents and his younger brother. In high school, he was a part of many clubs and extracurricular
						activities, including student council, the Romeo Theatre Company, and the United States Naval
						Sea Cadet Corps, just to name a few. He graduated high school one class away from my Associate
						Degree at Macomb Community College, which was officially complete after taking a final English
						course in the summer of 2018. Nick entered Western as one of the 20 Medallion scholars and has
						loved every minute of his time there.
						<br><br>
						Nick has had many musical experiences both within Kalamazoo and across the greater nation. He
						has been studying piano for 14 years along with training in classical voice. He attended arts
						camps, such as Solo and Ensemble Festival, Honors Band, Michigan Thespian Festival, and Blue
						Lake Fine Arts Camp. These past two years, he served as judge for the Michigan Thespian Festival
						and worked as a musician and a music director at WMU, Timberlake Playhouse, the Barn Theatre,
						and Farmers Alley. He was a part of many theatrical productions, both on stage and off.
						Furthermore, he is a member of WMU’s University Chorale and their wonderful music department. He
						is entering his senior year at Western and will be graduating with a degree in Biochemistry and
						a degree in Music.
						<br><br>
						Nick has worn many hats in his short time in Kalamazoo. Since 2017, he has had the privilege to
						serve as the Music Director at the Unitarian Universalist community Church in Portage. This
						position is something that he holds near and dear to his heart as it has allowed him to expand
						his musical horizons and given him the opportunity to be active in the greater community. At
						WMU, he has worked as a Supplemental Instructor for chemistry courses, along with an
						Undergraduate Teaching Assistant. In the Fall of 2018, he joined a lab at WMU as a research
						assistant, a position which he very much enjoys. In September of 2019, he will be teaching a
						course through the Osher Lifelong Learning Institute regarding African American Musical History
						and Impact. He has been a pianist, a scientist, a vocalist, a teacher, a director, a researcher,
						and a volunteer. All of these experiences have shaped the person he is today. </p>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat ">Done</a>
		</div>
	</div>

	<tags:footer />

	<script src="/static/js/standardPage.js"></script>
</body>

</html>