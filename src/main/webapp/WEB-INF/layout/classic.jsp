<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<!--  Some CSS for the task page  -->
<link href='../css/style.css' rel="stylesheet" type="text/css" />
<link href='../css/css/font-awesome.css' rel="stylesheet"
	type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

<!--  data tables  -->
<!-- DataTables CSS -->

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.css">

<!-- jQuery -->

<script type="text/javascript" charset="utf8"
	src="https://code.jquery.com/jquery-1.10.2.min.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>

<!--  end of all -->



<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>

</head>
<body>
	<tilesx:useAttribute name="current" />

	<div class="container">
		<div class="navbar navbar-default navbar-static-top" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<spring:url value="/"/>">Template</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="${current == 'index' ? 'active' : '' }"><a
						href='<spring:url value="/"/>'>Home</a></li>

					<%-- <security:authorize access="hasRole('ROLE_ADMIN')">
						<li class="${current == 'users' ? 'active' : '' }"><a
							href='<spring:url value="/users.html"/>'>Users</a></li>
					</security:authorize> --%>
					<security:authorize access="isAuthenticated()">
						<li class="${current == 'Category' ? 'active' : '' }"><a
							href='<spring:url value="/cat.html"/>'>Category </a></li>
					</security:authorize>

					<security:authorize access="isAuthenticated()">
						<li class="${current == 'Product' ? 'active' : '' }"><a
							href='<spring:url value="/prod.html"/>'>Product </a></li>
					</security:authorize>

					<security:authorize access="isAuthenticated()">
						<li class="${current == 'Task' ? 'active' : '' }"><a
							href='<spring:url value="/task.html"/>'>Task </a></li>
					</security:authorize>

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<security:authorize access="! isAuthenticated()">
						<li class="${current == 'login' ? 'active' : '' }"><a
							href='<spring:url value="/login.html"/>'>Loging </a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li><a href='<spring:url value="/logout"/>'>Logout </a></li>
					</security:authorize>
				</ul>


			</div>
			<!--/.nav-collapse -->
		</div>


		<tiles:insertAttribute name="body" />







		<br> <br>



		<center>
			<tiles:insertAttribute name="footer" />
		</center>
	</div>



</body>
</html>