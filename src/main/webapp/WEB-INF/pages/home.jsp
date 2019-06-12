<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="tags" %>


<html>
<tags:meta title="Home" />

<body>
	<main>
		<tags:homeHeader />

		<div class="container row">
			<div class="col s12 m9 l10">
				<div id="introduction" class="section scrollspy">
					<h3>Introduction</h3>
					<p>Lorem ipsum dolor sit amet consectetur adipiscing elit pulvinar cubilia nostra venenatis,
						risus
						tempus urna aptent tempor vel gravida primis molestie sociis, cursus ornare neque in nisl
						congue
						donec dictum natoque ante. Dui metus ullamcorper cras tristique non in morbi nulla,
						curabitur
						donec ridiculus habitasse pharetra blandit cursus habitant leo, praesent facilisi phasellus
						felis et viverra natoque. Imperdiet sociosqu potenti velit vulputate senectus et fermentum
						platea interdum duis nisi, sem tellus a odio nostra nullam tristique per cras pretium
						habitant,
						congue eros arcu vestibulum montes vel litora magnis volutpat est.</p>
					<p>A sociis potenti arcu dictumst purus venenatis fusce imperdiet quisque platea laoreet, ornare
						metus hac lectus sem penatibus netus nam nascetur himenaeos cum, faucibus facilisi mus
						consequat
						mauris id aliquam curabitur euismod dapibus. Non proin diam arcu duis nam ante nostra
						inceptos,
						mattis placerat varius accumsan velit mus fermentum faucibus, in nulla lectus montes ornare
						aliquam vitae. Ac netus lectus accumsan arcu ullamcorper nisi donec semper, nullam rutrum
						nulla
						purus aliquam natoque lacinia, ridiculus ultricies neque litora molestie velit imperdiet.
						Ultrices potenti torquent metus posuere litora feugiat dis vulputate turpis, tincidunt nam
						dictumst nunc habitant sollicitudin parturient eget, porttitor inceptos ut velit pharetra
						nulla
						condimentum erat.</p>
				</div>

				<div id="community" class="section scrollspy">
					<h3>Community</h3>
					<ul class="collapsible popout" data-collapsible="expandable">
						<li>
							<div class="collapsible-header active"><i class="material-icons">filter_drama</i>First</div>
							<div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
						</li>
						<li>
							<div class="collapsible-header"><i class="material-icons">place</i>Second</div>
							<div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
						</li>
						<li>
							<div class="collapsible-header"><i class="material-icons">whatshot</i>Third</div>
							<div class="collapsible-body"><span>Lorem ipsum dolor sit amet.</span></div>
						</li>
					</ul>
				</div>

				<div id="involvement" class="section scrollspy">
					<h3>Involvement</h3>
					<div class="row">
						<div class="col s4">
							<div class="center promo">
								<i class="material-icons">flash_on</i>
								<p class="promo-caption">Get invloved fast</p>
								<p class="light center">Lorem ipsum dolor sit amet consectetur, adipiscing elit duis nascetur.</p>
							</div>
						</div>
						<div class="col s4">
							<div class="center promo">
								<i class="material-icons">group</i>
								<p class="promo-caption">Experience Focused</p>
								<p class="light center">Lorem ipsum dolor sit amet consectetur, adipiscing elit duis nascetur.</p>
							</div>
						</div>
						<div class="col s4">
							<div class="center promo">
								<i class="material-icons">settings</i>
								<p class="promo-caption">Easy to work with</p>
								<p class="light center">Lorem ipsum dolor sit amet consectetur, adipiscing elit duis nascetur.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col hide-on-small-only m3 l2">
				<ul class="section table-of-contents">
					<li><a href="#introduction">Introduction</a></li>
					<li><a href="#community">Community</a></li>
					<li><a href="#involvement">Involvement</a></li>
				</ul>
			</div>
		</div>
	</main>

	<script language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/typed.js/2.0.10/typed.min.js"></script>
</body>

</html>