  <%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.controller.LoginCtl"%>



<%@page import="in.co.rays.proj4.util.ServletUtility"%>

<%@page import="in.co.rays.proj4.controller.BaseCtl"%>

<%@page import="in.co.rays.proj4.controller.ORSView"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Login</title>

<!-- Bootstrap Icons -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body>

	<%@ include file="Header.jsp"%>

	<%
	String _suc = ServletUtility.getSuccessMessage(request);

	String _err = ServletUtility.getErrorMessage(request);
	

	%>
	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.UserBean"
		scope="request"></jsp:useBean>


	<!-- ACADEMIC BACKGROUND -->

	<div class="position-relative overflow-hidden bg-light"
		style="min-height: 80vh; padding-top: 50px; padding-bottom: 50px;">


		<!-- BACKGROUND ACADEMIC ICONS -->

		<i class="bi bi-book position-absolute text-primary"
			style="font-size: 120px; opacity: 0.06; top: 40px; left: 8%;"> </i> <i
			class="bi bi-mortarboard-fill position-absolute text-primary"
			style="font-size: 150px; opacity: 0.06; top: 80px; right: 8%;"> </i>


		<i class="bi bi-laptop position-absolute text-primary"
			style="font-size: 130px; opacity: 0.05; bottom: 40px; left: 10%;">
		</i> <i class="bi bi-journal-bookmark-fill position-absolute text-primary"
			style="font-size: 120px; opacity: 0.05; bottom: 50px; right: 12%;">
		</i>


		<!-- SMALL DECORATIVE CIRCLES -->

		<div class="position-absolute bg-primary rounded-circle"
			style="width: 180px; height: 180px; opacity: 0.04; top: 20px; left: 35%;">
		</div>


		<div class="position-absolute bg-info rounded-circle"
			style="width: 220px; height: 220px; opacity: 0.04; bottom: 20px; right: 35%;">
		</div>


		<!-- LOGIN CARD -->

		<div class="container position-relative">

			<div class="row justify-content-center">

				<div class="col-md-5">


					<div class="card shadow-lg border-0">


						<!-- CARD HEADER -->

						<div class="card-header bg-white text-center py-3">

							<h3 class="mb-0 text-primary">

								<i class="bi bi-box-arrow-in-right"></i>
								<%=ms.get("login.title")%>

							</h3>

							<small class="text-muted"> <%=ms.get("login.subtitle")%>
							</small>

						</div>


						<!-- CARD BODY -->

						<div class="card-body p-4">


							<!-- SUCCESS MESSAGE -->
							<!-- FIX: alert-dismissible + btn-close add kiya taaki right side me
							     cross (X) button aaye jisse click karke success message
							     (jaise "Logout successfully") band kar sakein. -->

							<%
							if (_suc != null && !_suc.isEmpty()) {
							%>

							<div class="alert alert-success alert-dismissible fade show"
								role="alert">

								<i class="bi bi-check-circle-fill"></i>

								<%=_suc%>

								<button type="button" class="btn-close" data-bs-dismiss="alert"
									aria-label="Close"></button>

							</div>

							<%
							}
							%>


							<!-- ERROR MESSAGE -->
							<!-- FIX: alert-dismissible + btn-close add kiya taaki right side me
							     cross (X) button aaye jisse click karke error message band kar sakein.
							     data-bs-dismiss="alert" Bootstrap JS (jo Header.jsp se already load
							     hota hai) ko batata hai ki click par is alert ko fade-out karke hata de. -->

							<%
							if (_err != null && !_err.isEmpty()) {
							%>

							<div class="alert alert-danger alert-dismissible fade show"
								role="alert">

								<i class="bi bi-exclamation-triangle-fill"></i>
  
								<%=_err%>

								<button type="button" class="btn-close" data-bs-dismiss="alert"
									aria-label="Close"></button>

							</div>

							<%
							}
							%>


							<!-- LOGIN FORM -->

							<form action="<%=ORSView.LOGIN_CTL%>" method="post">


								<!-- LOGIN FIELD -->

								<div class="mb-3">

									<label class="form-label fw-bold"> <i
										class="bi bi-person-circle text-primary"></i> <%=ms.get("login.userid")%>

										<font color="red">*</font>

									</label> <input type="email" name="login" value="<%= DataUtility.getStringData(bean.getLogin()) %>"
										placeholder="Enter your login" class="form-control">


									<div class="text-danger mt-1">

										<%=ServletUtility.getErrorMessage("login", request)%>

									</div>

								</div>


								<!-- PASSWORD FIELD -->

								<div class="mb-4">

									<label class="form-label fw-bold"> <i
										class="bi bi-lock-fill text-warning"></i> <%=ms.get("login.password")%>

										<font color="red">*</font>

									</label> <input type="password" name="password" value="<%= DataUtility.getStringData(bean.getPassword()) %>"
										placeholder="Enter your password" class="form-control">


									<div class="text-danger mt-1">

										<%=ServletUtility.getErrorMessage("password", request)%>

									</div>

								</div>


								<!-- LOGIN BUTTON -->

								<div class="text-center">

									<input type="submit" name="operation"
										value="<%=LoginCtl.OP_SIGN_IN%>" class="btn btn-primary px-4">

								</div>


								<!-- FORGOT PASSWORD LINK -->
								<!-- YE LOGIN BUTTON KE NICHE ADD KIYA HAI -->

								<div class="text-center mt-3">

									<a href="<%=ORSView.FORGET_PASSWORD_CTL%>"
										class="text-decoration-none"> Forgot Password? </a>

								</div>


							</form>

						</div>

					</div>

				</div>

			</div>

		</div>

	</div>


	<%@ include file="Footer.jsp"%>

</body>

</html>