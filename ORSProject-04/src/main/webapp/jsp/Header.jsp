<%@page import="in.co.rays.proj4.util.MessageSource"%>

<%@page import="in.co.rays.proj4.controller.ORSView"%>

<%@page import="in.co.rays.proj4.bean.UserBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>ORS Project</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">


<!-- jQuery UI -->
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#udatee").datepicker({
			changeMonth : true,
			changeYear : true,
			yearRange : '1980:2020',
		});
	});
</script>
</head>

<body>

	<%
	MessageSource ms = MessageSource.getInstance();

	UserBean userBean = (UserBean) session.getAttribute("user");

	String roleName = (String) session.getAttribute("role");

	boolean isLogin = userBean != null;

	String welcomeMsg = "Hi, ";

	String locale = ms.getLanguage();
	%>


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

		<div class="container-fluid">


			<!-- LOGO -->

			<div class="bg-white rounded-3 p-1 shadow-sm me-3">

				<img src="<%=ORSView.APP_CONTEXT%>/img/customLogo.jpg" width="140"
					height="45" class="rounded-3" alt="ORS Logo">

			</div>


			<!-- Language Dropdown -->

			<td style="width: 120px; text-align: center;">

				<form style="margin: 0;">

					<select name="lang" onchange="this.form.submit()">

						<%-- onchange ek event h --%>

						<option value="en" <%=("en".equals(locale)) ? "selected" : ""%>>English</option>

						<option value="hi" <%=("hi".equals(locale)) ? "selected" : ""%>>Hindi</option>

					</select>

				</form>

			</td>


			<!-- MOBILE MENU BUTTON -->

			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarContent"
				aria-controls="navbarContent" aria-expanded="false"
				aria-label="Toggle navigation">

				<span class="navbar-toggler-icon"></span>

			</button>


			<div class="collapse navbar-collapse" id="navbarContent">


				<%
				if (isLogin) {
				%>


				<!-- ================= MENU ================= -->

				<ul class="navbar-nav me-auto mb-2 mb-lg-0">


					<!-- ROLE DROPDOWN -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="roleDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">

							Role </a>

						<ul class="dropdown-menu dropdown-menu-dark">

							<li><a class="dropdown-item" href="<%=ORSView.ROLE_CTL%>">

									Add Role </a></li>

							<li><a class="dropdown-item"
								href="<%=ORSView.ROLE_LIST_CTL%>"> Role List </a></li>

						</ul></li>


					<!-- USER DROPDOWN -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="userDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">

							User </a>

						<ul class="dropdown-menu dropdown-menu-dark">

							<li><a class="dropdown-item" href="<%=ORSView.USER_CTL%>">

									Add User </a></li>

							<li><a class="dropdown-item"
								href="<%=ORSView.USER_LIST_CTL%>"> User List </a></li>

						</ul></li>


					<!-- COLLEGE DROPDOWN -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="collegeDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">

							College </a>

						<ul class="dropdown-menu dropdown-menu-dark">

							<li><a class="dropdown-item" href="<%=ORSView.COLLEGE_CTL%>">

									Add College </a></li>

							<li><a class="dropdown-item"
								href="<%=ORSView.COLLEGE_LIST_CTL%>"> College List </a></li>

						</ul></li>


					<!-- STUDENT DROPDOWN -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="studentDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">

							Student </a>

						<ul class="dropdown-menu dropdown-menu-dark">

							<li><a class="dropdown-item" href="<%=ORSView.STUDENT_CTL%>">

									Add Student </a></li>

							<li><a class="dropdown-item"
								href="<%=ORSView.STUDENT_LIST_CTL%>"> Student List </a></li>

						</ul></li>


					<!-- MARKSHEET DROPDOWN -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="marksheetDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">

							MarkSheet </a>

						<ul class="dropdown-menu dropdown-menu-dark">

							<li><a class="dropdown-item"
								href="<%=ORSView.MARKSHEET_CTL%>"> Add MarkSheet </a></li>

							<li><a class="dropdown-item"
								href="<%=ORSView.MARKSHEET_LIST_CTL%>"> MarkSheet List </a></li>

							<li><a class="dropdown-item"
								href="<%=ORSView.GET_MARKSHEET_CTL%>"> Get MarkSheet </a></li>
						</ul></li>


					<!-- COURSE DROPDOWN -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="courseDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">

							Course </a>

						<ul class="dropdown-menu dropdown-menu-dark">

							<li><a class="dropdown-item" href="<%=ORSView.COURSE_CTL%>">

									Add Course </a></li>

							<li><a class="dropdown-item"
								href="<%=ORSView.COURSE_LIST_CTL%>"> Course List </a></li>

						</ul></li>


					<!-- SUBJECT DROPDOWN -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="subjectDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">

							Subject </a>

						<ul class="dropdown-menu dropdown-menu-dark">

							<li><a class="dropdown-item" href="<%=ORSView.SUBJECT_CTL%>">

									Add Subject </a></li>

							<li><a class="dropdown-item"
								href="<%=ORSView.SUBJECT_LIST_CTL%>"> Subject List </a></li>

						</ul></li>


					<!-- FACULTY DROPDOWN -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="facultyDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">

							Faculty </a>

						<ul class="dropdown-menu dropdown-menu-dark">

							<li><a class="dropdown-item" href="<%=ORSView.FACULTY_CTL%>">

									Add Faculty </a></li>

							<li><a class="dropdown-item"
								href="<%=ORSView.FACULTY_LIST_CTL%>"> Faculty List </a></li>

						</ul></li>


					<!-- TIME TABLE DROPDOWN -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="timetableDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">

							Time Table </a>

						<ul class="dropdown-menu dropdown-menu-dark">

							<li><a class="dropdown-item"
								href="<%=ORSView.TIMETABLE_CTL%>"> Add Time Table </a></li>

							<li><a class="dropdown-item"
								href="<%=ORSView.TIMETABLE_LIST_CTL%>"> Time Table List </a></li>

						</ul></li>


					<!-- MODULE DROPDOWN -->

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="moduleDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">

							Module </a>

						<ul class="dropdown-menu dropdown-menu-dark">


							<li><a class="dropdown-item" href="<%=ORSView.GYM_CTL%>">
									Add Gym Member </a></li>


							<li><a class="dropdown-item"
								href="<%=ORSView.GYM_LIST_CTL%>"> Gym Member List </a></li>

							<li><a class="dropdown-item" href="<%=ORSView.PARKING_CTL%>">
									Add Parking </a></li>


							<li><a class="dropdown-item"
								href="<%=ORSView.PARKING_LIST_CTL%>"> Parking List </a></li>


							<li><a class="dropdown-item" href="<%=ORSView.VOTING_CTL%>">
									Add Voter </a></li>


							<li><a class="dropdown-item"
								href="<%=ORSView.VOTING_LIST_CTL%>"> Voter List </a></li>


							<li><a class="dropdown-item"
								href="<%=ORSView.HOSPITAL_CTL%>"> Add Hospital </a></li>


							<li><a class="dropdown-item"
								href="<%=ORSView.HOSPITAL_LIST_CTL%>"> Hospital List </a></li>


							<li><a class="dropdown-item" href="<%=ORSView.MOVIE_CTL%>">
									Add Movie </a></li>


							<li><a class="dropdown-item"
								href="<%=ORSView.MOVIE_LIST_CTL%>"> Movie List </a></li>


							<li><a class="dropdown-item"
								href="<%=ORSView.RESTAURANT_CTL%>"> Add Restaurant </a></li>


							<li><a class="dropdown-item"
								href="<%=ORSView.RESTAURANT_LIST_CTL%>"> Restaurant List </a></li>

							<li><a class="dropdown-item" href="<%=ORSView.GYM_CTL%>">
									Add Gym Member </a></li>


							<li><a class="dropdown-item"
								href="<%=ORSView.GYM_LIST_CTL%>"> Gym Member List </a></li>

							<li><a class="dropdown-item" 
							href="<%=ORSView.FOOD_CTL%>">Add Food </a></li>
							
							<li><a class="dropdown-item"
								href="<%=ORSView.FOOD_LIST_CTL%>"> Food List </a></li>

						</ul></li>

				</ul>


				<!-- My Account DROPDOWN -->

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="timetableDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">

						<b> <%=welcomeMsg + userBean.getFirstName() + " (" + roleName + ")"%>
					</b>

				</a>

					<ul class="dropdown-menu dropdown-menu-dark">

						<li><a class="dropdown-item"
							href="<%=ORSView.MY_PROFILE_CTL + "?id=" + userBean.getId()%>">

								My Profile </a></li>

						<li><a class="dropdown-item"
							href="<%=ORSView.CHANGE_PASSWORD_CTL%>"> Change Password </a></li>

					</ul></li>


				<!-- JAVADOC -->

				<a class="btn btn-outline-light btn-sm me-2"
					href="<%=ORSView.JAVA_DOC_VIEW%>" target="_blank"> JavaDoc </a>


				<!-- LOGOUT -->

				<a class="btn btn-outline-light btn-sm"
					href="<%=ORSView.LOGIN_CTL%>?operation=logout"> Logout </a>


				<%
				}
				%>


				<%
				if (!isLogin) {
				%>


				<!-- ================= GUEST MENU ================= -->

				<ul class="navbar-nav ms-auto align-items-lg-center">


					<!-- WELCOME -->

					<li class="nav-item"><a
						class="btn btn-primary btn-sm me-2 px-3"
						href="<%=ORSView.WELCOME_CTL%>"> Welcome </a></li>


					<!-- LOGIN -->

					<li class="nav-item"><a
						class="btn btn-primary btn-sm me-2 px-3"
						href="<%=ORSView.LOGIN_CTL%>"> Login </a></li>


					<!-- SIGN UP -->

					<li class="nav-item"><a class="btn btn-primary btn-sm px-3"
						href="<%=ORSView.USER_REGISTRATION_CTL%>"> Sign Up </a></li>


				</ul>


				<%
				}
				%>


			</div>

		</div>

	</nav>


	<!-- BOOTSTRAP JAVASCRIPT -->

	<!-- FIX: pehle popper.min.js aur bootstrap.min.js alag-alag load ho rahe the,
	     aur bootstrap.min.js ka integrity hash galat tha (bundle wala hash lag gaya tha).
	     Integrity mismatch hone par browser SRI check fail karke poori script silently
	     block kar deta hai — isi wajah se dropdown click par khulta nahi tha.
	     FIX: dono ko hata kar ek hi bootstrap.bundle.min.js use kiya (Popper already
	     isme included hota hai) aur integrity attribute hata diya taaki mismatch na ho. -->

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js">
		
	</script>


</body>

</html>