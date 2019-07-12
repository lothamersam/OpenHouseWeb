<%@ attribute name="title" required="true" %>

<head>
	<title>${title}: Open House</title>

	<link rel="stylesheet" href="/static/vendor/materialize/css/materialize.min.css" />
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
	<link href="https://fonts.googleapis.com/css?family=Oswald:500|Montserrat|Arvo|Permanent+Marker&display=swap" rel="stylesheet">

	<link href="/static/css/header.css" rel="stylesheet" />

	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="/static/vendor/materialize/js/materialize.min.js"></script>
    <script type="text/javascript" src="//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
	<script type="text/javascript">
    	jQuery(function ($) {
        	$("textarea").shieldEditor({
            	height: 260
        	});
    	});
	</script>

	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>