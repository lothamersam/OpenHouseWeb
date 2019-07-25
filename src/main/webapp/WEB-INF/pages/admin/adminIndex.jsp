<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<html>
<tags:meta title="Contact" />

<body>
	<main> <tags:adminHeader />

	<div class="container row">
		<div class="row top-row">
			<div class="card">
				<div class="card-content">
					<span class="card-titile">Admin Dashboard</span> The admin
					dashboard allows authorized members of the Open House Threatre
					Company to edit various pages of the website. Additionally staff
					can view audition signups, add production and audition dates, and
					upload staff photos. Select the pencil icon to the right of each page
					to visit the editable version of each page!
				</div>
				<div class="card-content">
					<ul class="collection with-header">
						<li class="collection-header"><h4>Editable pages:</h4></li>
						<li class="collection-item"><div>
								Home<a href="/admin/home" class="secondary-content"><i
									class="material-icons">mode_edit</i></a>
							</div></li>
						<li class="collection-item"><div>
								About Us<a href="/admin/about" class="secondary-content"><i
									class="material-icons">mode_edit</i></a>
							</div></li>
						<li class="collection-item"><div>
								Productions<a href="/admin/upcoming" class="secondary-content"><i
									class="material-icons">mode_edit</i></a>
							</div></li>
						<li class="collection-item"><div>
								Auditions<a href="/admin/auditions" class="secondary-content"><i
									class="material-icons">mode_edit</i></a>
							</div></li>
						<li class="collection-item"><div>
								Our Staff<a href="/admin/staff" class="secondary-content"><i
									class="material-icons">mode_edit</i></a>
							</div></li>
						<li class="collection-item"><div>
								Donate<a href="/admin/donate" class="secondary-content"><i
									class="material-icons">mode_edit</i></a>
							</div></li>
						<li class="collection-item"><div>
								Contact Us<a href="/admin/contact" class="secondary-content"><i
									class="material-icons">mode_edit</i></a>
							</div></li>
						<li class="collection-item"><div>
								Admin Users<a href="/admin/users" class="secondary-content"><i
									class="material-icons">mode_edit</i></a>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	</main>

	<tags:footer />

	<script src="/static/js/standardPage.js"></script>
	<script lang="javascript" src="/static/js/adminPageSection.js"></script>
</body>

</html>
