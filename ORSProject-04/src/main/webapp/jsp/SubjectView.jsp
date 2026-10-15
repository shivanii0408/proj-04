<%@page import="in.co.rays.proj4.bean.CourseBean"%>

<%@page import="java.util.List"%>

<%@page import="in.co.rays.proj4.controller.SubjectCtl"%>

<%@page import="in.co.rays.proj4.util.ServletUtility"%>

<%@page import="in.co.rays.proj4.controller.BaseCtl"%>

<%@page import="in.co.rays.proj4.controller.ORSView"%>

<%@page import="in.co.rays.proj4.util.HTMLUtility"%>

<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.SubjectBean"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Subject</title>

<!-- Bootstrap CSS/JS already loaded via Header.jsp, isliye yahan dobara nahi liya -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

	<%@ include file="Header.jsp"%>

	<%
	String _suc = ServletUtility.getSuccessMessage(request);

	String _err = ServletUtility.getErrorMessage(request);

	List<CourseBean> courseList = (List) request.getAttribute("courseList");

	/* SubjectBean bean = (SubjectBean) request.getAttribute("bean"); */
	%>

	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.SubjectBean"
		scope="request"></jsp:useBean>

	<!-- FIX: extra bottom padding taaki fixed/sticky Footer Save button ko
	     overlap na kare -->
	<div class="container pt-5" style="padding-bottom: 100px !important;">
		<div class="row justify-content-center">
			<div class="col-md-10 col-lg-7">

				<div class="card shadow-lg border-0">

					<div class="card-header bg-white text-center py-3">
						<h3 class="mb-1 text-primary">
							<i class="bi bi-book-fill"></i>
							<%=bean != null && bean.getId() > 0 ? "Update Subject" : "Add Subject"%>
						</h3>
						<small class="text-muted">Manage ORS subjects</small>
					</div>

					<div class="card-body p-4">

						<%
						if (_suc != null && _suc.length() > 0) {
						%>
						<div class="alert alert-success">
							<i class="bi bi-check-circle-fill"></i>
							<%=_suc%></div>
						<%
						}
						if (_err != null && _err.length() > 0) {
						%>
						<div class="alert alert-danger">
							<i class="bi bi-exclamation-triangle-fill"></i>
							<%=_err%></div>
						<%
						}
						%>

						<form action="<%=ORSView.SUBJECT_CTL%>" method="post">

							<input type="hidden" name="id"
								value="<%=DataUtility.getStringData(bean.getId())%>">

							<!-- Name full width -->
							<div class="mb-3">
								<label class="form-label fw-bold"><i
									class="bi bi-book text-primary"></i> Name <span
									class="text-danger">*</span></label> <input type="text" name="name"
									class="form-control"
									value="<%=DataUtility.getStringData(bean.getName())%>"
									placeholder="enter subject name"> <small
									class="text-danger"><%=ServletUtility.getErrorMessage("name", request)%></small>
							</div>

							<!-- Description full width -->
							<div class="mb-3">
								<label class="form-label fw-bold"><i
									class="bi bi-align-start text-success"></i> Description <span
									class="text-danger">*</span></label> <input type="text"
									name="description" class="form-control"
									value="<%=DataUtility.getStringData(bean.getDescription())%>"
									placeholder="enter description"> <small
									class="text-danger"><%=ServletUtility.getErrorMessage("description", request)%></small>
							</div>

							<!-- Course Dropdown -->
							<div class="mb-4">
								<label class="form-label fw-bold"> <i
									class="bi bi-journal-bookmark-fill text-warning"></i> Course <span
									class="text-danger">*</span>
								</label>

								<%
								String courseHtml = HTMLUtility.getList("courseId", DataUtility.getStringData(bean.getCourseId()), courseList);

								courseHtml = courseHtml.replaceFirst("<select", "<select class=\"form-select\"");
								%>

								<%=courseHtml%>

								<small class="text-danger"> <%=ServletUtility.getErrorMessage("courseId", request)%>
								</small>
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