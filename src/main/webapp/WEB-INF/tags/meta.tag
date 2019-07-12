<%@ attribute name="title" required="true" %>

<head>
	<title>${title}: Open House</title>

	<link rel="stylesheet" href="/static/vendor/materialize/css/materialize.min.css" />
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css?family=Oswald:500|Montserrat|Arvo|Permanent+Marker&display=swap" rel="stylesheet">
	<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">

	<link href="/static/css/header.css" rel="stylesheet" />

	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="/static/vendor/materialize/js/materialize.min.js"></script>
	<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
	<script>
		var quill = new Quill('textarea', {
			modules: { toolbar: true },
		  	theme: 'snow'
		});
	</script>

	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>