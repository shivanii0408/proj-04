<%@page import="in.co.rays.proj4.bean.CollegeBean"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.proj4.controller.FacultyCtl"%>
<%@page import="in.co.rays.proj4.controller.LoginCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.FacultyBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Faculty</title>
<!-- Bootstrap CSS/JS already loaded via Header.jsp, isliye yahan dobara nahi liya -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="bg-light">

<%@ include file="Header.jsp"%>
	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	List<CollegeBean> collegeList = (List) request.getAttribute("collegeList");
	
	/* FacultyBean bean = (FacultyBean) request.getAttribute("bean"); */
	%>

     <jsp:useBean id="bean" class="in.co.rays.proj4.bean.FacultyBean"
		scope="request"></jsp:useBean>
		

	<!-- FIX: extra bottom padding taaki fixed/sticky Footer Save button ko
	     overlap na kare -->
	<div class="container pt-5" style="padding-bottom: 100px !important;">
		<div class="row justify-content-center">
			<div class="col-md-10 col-lg-8">

				<div class="card shadow-lg border-0">

					<div class="card-header bg-white text-center py-3">
						<h3 class="mb-1 text-primary">
							<i class="bi bi-person-workspace"></i>
							<%=bean != null && bean.getId() > 0 ? "Update Faculty" : "Add Faculty"%>
						</h3>
						<small class="text-muted">Manage ORS faculty members</small>
					</div>

					<div class="card-body p-4">

						<%
						if (_suc != null && _suc.length() > 0) {
						%>
						<div class="alert alert-success"><i
							class="bi bi-check-circle-fill"></i> <%=_suc%></div>
						<%
						}
						if (_err != null && _err.length() > 0) {
						%>
						<div class="alert alert-danger"><i
							class="bi bi-exclamation-triangle-fill"></i> <%=_err%></div>
						<%
						}
						%>

						<form action="<%=ORSView.FACULTY_CTL%>" method="post">
	
						<input type="hidden" name="id"
							value="<%=DataUtility.getStringData(bean.getId())%>">

							<!-- FirstName + LastName side-by-side -->
							<div class="row">
								<div class="col-md-6 mb-3">
									<label class="form-label fw-bold"><i
										class="bi bi-person-fill text-primary"></i> FirstName <span
										class="text-danger">*</span></label> <input type="text"
										name="firstName" class="form-control"
										value="<%=DataUtility.getStringData(bean.getFirstName())%>"
										placeholder="enter your firstName">
									<small class="text-danger"><%=ServletUtility.getErrorMessage("firstName", request)%></small>
								</div>
								<div class="col-md-6 mb-3">
									<label class="form-label fw-bold"><i
										class="bi bi-person-fill text-success"></i> LastName <span
										class="text-danger">*</span></label> <input type="text"
										name="lastName" class="form-control"
										value="<%=DataUtility.getStringData(bean.getLastName())%>"
										placeholder="enter your lastName">
									<small class="text-danger"><%=ServletUtility.getErrorMessage("lastName", request)%></small>
								</div>
							</div>

							<!-- Email + Mobile No side-by-side -->
							<div class="row">
								<div class="col-md-6 mb-3">
									<label class="form-label fw-bold"><i
										class="bi bi-envelope-fill text-info"></i> Email <span
										class="text-danger">*</span></label> <input type="email"
										name="email" class="form-control"
										value="<%=DataUtility.getStringData(bean.getEmail())%>"
										placeholder="enter email">
									<small class="text-danger"><%=ServletUtility.getErrorMessage("email", request)%></small>
								</div>
								<div class="col-md-6 mb-3">
									<label class="form-label fw-bold"><i
										class="bi bi-telephone-fill text-warning"></i> Mobile No
										<span class="text-danger">*</span></label> <input type="text"
										name="mobileNo" class="form-control"
										value="<%=DataUtility.getStringData(bean.getMobileNo())%>"
										placeholder="enter an mobile no">
									<small class="text-danger"><%=ServletUtility.getErrorMessage("mobileNo", request)%></small>
								</div>
							</div>

							<!-- Address full width -->
							<div class="mb-3">
								<label class="form-label fw-bold"><i
									class="bi bi-geo-alt-fill text-danger"></i> Address <span
									class="text-danger">*</span></label> <input type="text"
									name="address" class="form-control"
									value="<%=DataUtility.getStringData(bean.getAddress())%>"
									placeholder="enter address">
								<small class="text-danger"><%=ServletUtility.getErrorMessage("address", request)%></small>
							</div>

							<!-- DOB full width -->
							<div class="mb-3">
								<label class="form-label fw-bold"><i
									class="bi bi-calendar-event-fill text-primary"></i> DOB <span
									class="text-danger">*</span></label> <input type="date"
									name="dob" class="form-control"
									value="<%=DataUtility.getStringData(bean.getDateOfBirth())%>"
									placeholder="enter dob">
								<small class="text-danger"><%=ServletUtility.getErrorMessage("dob", request)%></small>
							</div>

							<!-- College Name + Gender side-by-side -->
							<div class="row">
								<div class="col-md-6 mb-4">
									<label class="form-label fw-bold"><i
										class="bi bi-bank2 text-success"></i> College Name <span
										class="text-danger">*</span></label>

									<!-- <select class='form-control' name='collegeId'>
											<option selected value=''>-------------Select------------</option>
											<%
											for (CollegeBean rbean : collegeList) {
											%>
											<option value='<%=rbean.getKey()%>'><%=rbean.getValue()%></option>
											<%
											}
											%>
									</select>-->

									<%
									String collegeHtml = HTMLUtility.getList("collegeId",
											DataUtility.getStringData(bean.getCollegeId()), collegeList);
									collegeHtml = collegeHtml.replaceFirst("<select",
											"<select class=\"form-control\"");
									%>
									<%=collegeHtml%>
									<small class="text-danger"><%=ServletUtility.getErrorMessage("collegeId", request)%></small>
								</div>

								<div class="col-md-6 mb-4">
									<label class="form-label fw-bold"><i
										class="bi bi-gender-ambiguous text-info"></i> Gender <span
										class="text-danger">*</span></label>
									<select class='form-control' name='gender'>
										<option selected value=''>-------------Select------------</option>
										<option value='female'>female</option>
										<option value='male'>male</option>
									</select>
									<small class="text-danger"><%=ServletUtility.getErrorMessage("gender", request)%></small>
								</div>
							</div>

							<div class="text-center">
								<input type="submit" name="operation"
									class="btn btn-primary px-4"
									value="<%=bean != null && bean.getId() > 0 ? "Update" : BaseCtl.OP_SAVE%>">
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>