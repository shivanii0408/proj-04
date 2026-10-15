<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.bean.StudentBean"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.MarksheetBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Marksheet</title>
<!-- Bootstrap CSS/JS already loaded via Header.jsp, isliye yahan dobara nahi liya -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="bg-light">

<%@ include file="Header.jsp"%>
	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	List<StudentBean> studentList = (List) request.getAttribute("studentList");

	/* MarksheetBean bean = (MarksheetBean) request.getAttribute("bean"); */
	%>

	  <jsp:useBean id="bean" class="in.co.rays.proj4.bean.MarksheetBean"
		scope="request"></jsp:useBean>

	<!-- FIX: extra bottom padding taaki fixed/sticky Footer Save button ko
	     overlap na kare -->
	<div class="container pt-5" style="padding-bottom: 100px !important;">
		<div class="row justify-content-center">
			<div class="col-md-10 col-lg-8">

				<div class="card shadow-lg border-0">

					<div class="card-header bg-white text-center py-3">
						<h3 class="mb-1 text-primary">
							<i class="bi bi-file-earmark-text-fill"></i>
							<%=bean != null && bean.getId() > 0 ? "Update Marksheet" : "Add Marksheet"%>
						</h3>
						<small class="text-muted">Manage ORS marksheets</small>
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

						<form action="<%=ORSView.MARKSHEET_CTL%>" method="post">

							<input type="hidden" name="id"
								value="<%=DataUtility.getStringData(bean.getId())%>">

							<!-- Roll No full width -->
							<div class="mb-3">
								<label class="form-label fw-bold"><i
									class="bi bi-hash text-primary"></i> Roll No <span
									class="text-danger">*</span></label> <input type="text"
									name="rollNo" class="form-control"
									value="<%=DataUtility.getStringData(bean.getRollNo())%>"
									placeholder="enter role no">
								<small class="text-danger"><%=ServletUtility.getErrorMessage("rollNo", request)%></small>
							</div>

							<!-- Name (student dropdown) full width -->
							<div class="mb-3">
								<label class="form-label fw-bold"><i
									class="bi bi-person-fill text-success"></i> Name <span
									class="text-danger">*</span></label>

								<!-- <select class='form-control' name='studentId'>
										<option selected value=''>-------------Select------------</option>
										<%
										for (StudentBean sbean : studentList) {
										%>
										<option value='<%=sbean.getKey()%>'><%=sbean.getValue()%></option>
										<%
										}
										%>
								</select>
								 -->

								<%
								String studentHtml = HTMLUtility.getList("studentId", "", studentList);
								studentHtml = studentHtml.replaceFirst("<select",
										"<select class=\"form-control\"");
								%>
								<%=studentHtml%>
								<!-- name, student list object -->
							</div>

							<!-- Student Id (plain text input) full width -->
							<div class="mb-3">
								<label class="form-label fw-bold"><i
									class="bi bi-person-badge-fill text-info"></i> Student Id
									<span class="text-danger">*</span></label> <input type="text"
									name="studentId" class="form-control"
									value="<%=DataUtility.getStringData(bean.getStudentId())%>"
									placeholder="enter Student ID">
								<small class="text-danger"><%=ServletUtility.getErrorMessage("studentId", request)%></small>
							</div>

							<!--  <div class="mb-3">
								<label class="form-label fw-bold">Name <font color="red">*</font></label>
								<input type="text" name="name" value="" class="form-control" placeholder="enter name">
								<small class="text-danger"><%=ServletUtility.getErrorMessage("name", request)%></small>
							</div> -->

							<!-- Physics + Chemistry side-by-side -->
							<div class="row">
								<div class="col-md-6 mb-3">
									<label class="form-label fw-bold"><i
										class="bi bi-clipboard-data-fill text-primary"></i> Physics
										<span class="text-danger">*</span></label> <input type="text"
										name="physics" class="form-control"
										value="<%=DataUtility.getStringData(bean.getPhysics())%>"
										placeholder="enter physics">
									<small class="text-danger"><%=ServletUtility.getErrorMessage("physics", request)%></small>
								</div>
								<div class="col-md-6 mb-3">
									<label class="form-label fw-bold"><i
										class="bi bi-clipboard-data-fill text-warning"></i> Chemistry
										<span class="text-danger">*</span></label> <input type="text"
										name="chemistry" class="form-control"
										value="<%=DataUtility.getStringData(bean.getChemistry())%>"
										placeholder="enter chemistry">
									<small class="text-danger"><%=ServletUtility.getErrorMessage("chemistry", request)%></small>
								</div>
							</div>

							<!-- Maths full width -->
							<div class="mb-4">
								<label class="form-label fw-bold"><i
									class="bi bi-clipboard-data-fill text-danger"></i> Maths <span
									class="text-danger">*</span></label> <input type="text"
									name="maths" class="form-control"
									value="<%=DataUtility.getStringData(bean.getMaths())%>"
									placeholder="enter maths">
								<small class="text-danger"><%=ServletUtility.getErrorMessage("maths", request)%></small>
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