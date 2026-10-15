<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.CollegeBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>College</title>
<!-- Bootstrap CSS/JS already loaded via Header.jsp, isliye yahan dobara nahi liya -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="bg-light">

<%@ include file="Header.jsp"%>
	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	/* CollegeBean bean = (CollegeBean) request.getAttribute("bean"); */
	%>

	 <jsp:useBean id="bean" class="in.co.rays.proj4.bean.CollegeBean"
		scope="request"></jsp:useBean>

	<!-- FIX: extra bottom padding taaki fixed/sticky Footer Save button ko
	     overlap na kare -->
	<div class="container pt-5" style="padding-bottom: 100px !important;">
		<div class="row justify-content-center">
			<div class="col-md-10 col-lg-7">

				<div class="card shadow-lg border-0">

					<div class="card-header bg-white text-center py-3">
						<h3 class="mb-1 text-primary">
							<i class="bi bi-bank2"></i>
							<%=bean != null && bean.getId() > 0 ? "Update College" : "Add College"%>
						</h3>
						<small class="text-muted">Manage ORS colleges</small>
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

						<form action="<%=ORSView.COLLEGE_CTL%>" method="post">

							<input type="hidden" name="id"
								value="<%=DataUtility.getStringData(bean.getId())%>">

							<!-- Name field full width -->
							<div class="mb-3">
								<label class="form-label fw-bold"><i
									class="bi bi-bank text-primary"></i> Name <span
									class="text-danger">*</span></label> <input type="text"
									name="name" class="form-control"
									value="<%=DataUtility.getStringData(bean.getName())%>"
									placeholder="enter college name">
								<small class="text-danger"><%=ServletUtility.getErrorMessage("name", request)%></small>
							</div>

							<!-- Address field full width -->
							<div class="mb-3">
								<label class="form-label fw-bold"><i
									class="bi bi-geo-alt-fill text-danger"></i> Address <span
									class="text-danger">*</span></label> <input type="text"
									name="address" class="form-control"
									value="<%=DataUtility.getStringData(bean.getAddress())%>"
									placeholder="enter address">
								<small class="text-danger"><%=ServletUtility.getErrorMessage("address", request)%></small>
							</div>

							<!-- State + City side-by-side -->
							<div class="row">
								<div class="col-md-6 mb-3">
									<label class="form-label fw-bold"><i
										class="bi bi-map-fill text-success"></i> State <span
										class="text-danger">*</span></label> <input type="text"
										name="state" class="form-control"
										value="<%=DataUtility.getStringData(bean.getState())%>"
										placeholder="enter state">
									<small class="text-danger"><%=ServletUtility.getErrorMessage("state", request)%></small>
								</div>
								<div class="col-md-6 mb-3">
									<label class="form-label fw-bold"><i
										class="bi bi-building text-info"></i> City <span
										class="text-danger">*</span></label> <input type="text"
										name="city" class="form-control"
										value="<%=DataUtility.getStringData(bean.getCity())%>"
										placeholder="enter city">
									<small class="text-danger"><%=ServletUtility.getErrorMessage("city", request)%></small>
								</div>
							</div>

							<!-- Phone No full width -->
							<div class="mb-4">
								<label class="form-label fw-bold"><i
									class="bi bi-telephone-fill text-warning"></i> Phone no <span
									class="text-danger">*</span></label> <input type="text"
									name="phoneNo" class="form-control"
									value="<%=DataUtility.getStringData(bean.getPhoneNo())%>"
									placeholder="enter phone no">
								<small class="text-danger"><%=ServletUtility.getErrorMessage("phoneNo", request)%></small>
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