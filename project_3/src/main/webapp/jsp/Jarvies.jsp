<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>your assistent</title>
<head>
<style>
.vr-btn {
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 10px 20px;
	font-size: 120px;
	background-color: warning; /* Green background */
	color: white; /* White text */
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.vr-btn i {
	margin-right: 8px; /* Spacing between icon and text */
}

/* Hover effect */
.vr-btn:hover {
	background-color: black;
}

/* Responsive - Smaller screens */
@media ( max-width : 600px) {
	.vr-btn {
		font-size: 14px;
		padding: 8px 16px;
	}
}
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>

</head>
<body
	background="https://www.gifcen.com/wp-content/uploads/2022/01/wallpaper-gif-9.gif">



	<h1></h1>
	<div class="center">
		<button id="start" class="vr-btn">
			<i class="fa fa-microphone"></i>
		</button>
	</div>


	<button id="stop">vr stop</button>
	<button id="speak">vr speak</button>
	<noscript>You need JavaScript for this web app</noscript>

	<script type="text/javascript"
		src="<%=ORSView.APP_CONTEXT%>/js/jarvies.js">
		
	</script>

</body>
</html>