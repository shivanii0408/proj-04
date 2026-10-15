<%@page import="in.co.rays.proj4.bean.MarksheetBean"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Marksheet Result</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
</head>
<body class="bg-light">

<%@ include file="Header.jsp"%>

<%
    MarksheetBean bean =
            (MarksheetBean) request.getAttribute("bean");
%>

	<div class="container py-5">
		<div class="row justify-content-center">
			<div class="col-md-8 col-lg-6">

				<div class="card shadow-lg border-0">

					<div class="card-header bg-white text-center py-3">
						<h3 class="mb-0 text-primary">
							<i class="bi bi-search"></i> Search Marksheet
						</h3>
					</div>

					<div class="card-body p-4">

						<form action="<%=ORSView.GET_MARKSHEET_CTL%>" method="post">

							<div class="mb-3">
								<label class="form-label fw-bold"> <i
									class="bi bi-hash text-primary"></i> Roll No
								</label>
								<div class="input-group">
									<input type="text" name="rollNo" class="form-control"
										value="<%=bean != null ? bean.getRollNo() : ""%>"
										placeholder="enter roll no">
									<button type="submit" class="btn btn-primary">
										<i class="bi bi-search"></i> Search
									</button>
								</div>
							</div>

						</form>

						<%
						if (bean != null) {
						%>

						<hr class="my-4">

						<h4 class="text-primary mb-3">
							<i class="bi bi-file-earmark-text-fill"></i> Marksheet Result
						</h4>

						<div class="table-responsive">
							<table class="table table-bordered table-hover align-middle">

								<tr>
									<th class="table-light">Roll No</th>
									<td><%=bean.getRollNo()%></td>
								</tr>

								<tr>
									<th class="table-light">Student Name</th>
									<td><%=bean.getName()%></td>
								</tr>

								<tr>
									<th class="table-light">Physics</th>
									<td><%=bean.getPhysics()%></td>
								</tr>

								<tr>
									<th class="table-light">Chemistry</th>
									<td><%=bean.getChemistry()%></td>
								</tr>

								<tr>
									<th class="table-light">Maths</th>
									<td><%=bean.getMaths()%></td>
								</tr>

								<tr class="table-primary">
									<th>Total</th>
									<td class="fw-bold">
										<%=bean.getPhysics()
												+ bean.getChemistry()
												+ bean.getMaths()%>
									</td>
								</tr>

								<tr class="table-success">
									<th>Percentage</th>
									<td class="fw-bold">
										<%=
											(bean.getPhysics()
											+ bean.getChemistry()
											+ bean.getMaths()) / 3.0
										%> %
									</td>
								</tr>

							</table>
						</div>

						<%
						}
						%>

					</div>
				</div>
			</div>
		</div>
	</div>

<%@ include file="Footer.jsp"%>

</body>
</html>