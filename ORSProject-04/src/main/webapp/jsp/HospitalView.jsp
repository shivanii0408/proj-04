<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.HospitalBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital</title>
<!-- Bootstrap CSS/JS already loaded via Header.jsp, isliye yahan dobara nahi liya -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<%@ include file="Header.jsp"%>
	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	/* HospitalBean bean = (HospitalBean) request.getAttribute("bean"); */
	%>

	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.HospitalBean"
		scope="request"></jsp:useBean>

	<!-- FIX: pt-5 rakha upar ke liye, pb-5 ki jagah extra inline padding-bottom
	     diya taaki fixed/sticky Footer neeche content (Save button) ko overlap na kare -->
	<div
		class="container d-flex justify-content-center align-items-center pt-5"
		style="padding-bottom: 100px !important;">

		<div class="card shadow-sm border-0"
			style="width: 100%; max-width: 700px;">

			<div class="card-header bg-white text-center border-bottom py-4">
				<h2 class="text-primary fw-bold mb-1">
					<i class="fa-solid fa-user-shield"></i>
					<%=bean != null && bean.getId() > 0 ? "Update Hospital" : "Add Hospital"%>
				</h2>
				<p class="text-secondary mb-0">Manage Hospital</p>
			</div>

			<div class="card-body p-4">

				<%
				if (_suc != null && _suc.length() > 0) {
				%>
				<div class="alert alert-success text-center py-2"><%=_suc%></div>
				<%
				}
				if (_err != null && _err.length() > 0) {
				%>
				<div class="alert alert-danger text-center py-2"><%=_err%></div>
				<%
				}
				%>

				<form action="<%=ORSView.HOSPITAL_CTL%>" method="post">

					<input type="hidden" name="id"
						value="<%=DataUtility.getStringData(bean.getId())%>">

					<div class="mb-3">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-user text-primary"></i> Patient Id <span
							class="text-danger">*</span>
						</label> <input type="text" name="patientId"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getPatientId())%>"
							placeholder="enter patient id"> <small
							class="text-danger"><%=ServletUtility.getErrorMessage("patientId", request)%></small>
					</div>

					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Name <span
							class="text-danger">*</span>
						</label> <input type="text" name="name"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getName())%>"
							placeholder="enter name"> <small
							class="text-danger"><%=ServletUtility.getErrorMessage("name", request)%></small>
					</div>

					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Age <span
							class="text-danger">*</span>
						</label> <input type="number" name="age"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getAge())%>"
							placeholder="enter age"> <small
							class="text-danger"><%=ServletUtility.getErrorMessage("age", request)%></small>
					</div>
					
					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Blood Group <span
							class="text-danger">*</span>
						</label> <input type="text" name="bloodGroup"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getBloodGroup())%>"
							placeholder="enter blood group"> <small
							class="text-danger"><%=ServletUtility.getErrorMessage("bloodGroup", request)%></small>
					</div>

                  <div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i>  Disease <span
							class="text-danger">*</span>
						</label> <input type="text" name="disease"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getDisease())%>"
							placeholder="enter disease "> <small
							class="text-danger"><%=ServletUtility.getErrorMessage("disease", request)%></small>
					</div>
                  


					<div class="text-center">
						<input type="submit" name="operation" class="btn btn-primary px-4"
							value="<%=bean != null && bean.getId() > 0 ? "Update" : BaseCtl.OP_SAVE%>">
					</div>

				</form>
			</div>
		</div>
	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>