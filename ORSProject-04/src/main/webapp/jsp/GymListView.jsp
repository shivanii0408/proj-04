<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.bean.GymBean"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gym List</title>
<!-- Bootstrap CSS/JS already loaded via Header.jsp, isliye yahan dobara nahi liya -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" rel="stylesheet">
</head>
<body class="bg-light">
	<%@ include file="Header.jsp"%>

	<%
	int pageNo = ServletUtility.getPageNo(request);
	int pageSize = ServletUtility.getPageSize(request);
	int index = ((pageNo - 1) * pageSize) + 1;
	List<GymBean> list = ServletUtility.getList(request);
	Iterator<GymBean> it = list.iterator();
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);
	%>

	<form action="<%=ORSView.GYM_LIST_CTL%>" method="post">

		<!-- FIX: extra bottom padding taaki fixed/sticky Footer Previous/Delete/Next
		     buttons ko neeche se overlap na kare -->
		<div class="container pt-5" style="padding-bottom: 100px !important;">
			<div class="card shadow-sm border-0">

				<div class="card-header bg-white text-center border-bottom py-4">
					<h2 class="text-primary fw-bold mb-0">
						<i class="fa-solid fa-user-shield"></i> Gym List
					</h2>
				</div>
				
				   <!-- PDF Link - Top Right -->
					
					<div class="position-absolute top-0 end-0 mt-2 me-3">
					
						<a href="<%=ORSView.GYM_REPORT_CTL%>"
							class="btn btn-outline-danger btn-sm px-3" target="_blank">
						
							 <i class="bi bi-file-earmark-pdf me-1"></i> PDF
							 
						</a>
						<!-- target=blank -->
						
						 <a href="<%=ORSView.GYM_REPORT_CTL%>?type=doc"
                             class="btn btn-outline-primary btn-sm px-3">
                               
                               <i class="bi bi-file-earmark-word me-1"></i> Doc
                         </a>
						
						
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

					<input type="hidden" name="pageNo" value="<%=pageNo%>">
					<input type="hidden" name="pageSize" value="<%=pageSize%>">

					<div class="row g-2 mb-4">
						<div class="col-md-4">
							<input type="text" name="name" value="" class="form-control"
								placeholder="search by name">
						</div>
						<div class="col-md-4">
							<input type="text" name="membershipType" value=""
								class="form-control" placeholder="search by membership type">
						</div>
						<div class="col-md-2">
							<input type="submit" name="operation"
								class="btn btn-primary w-100" value="<%=BaseCtl.OP_SEARCH%>">
						</div>
					</div>

					<div class="table-responsive">
						<table class="table table-bordered table-hover align-middle">
							<thead class="table-primary text-center">
								<tr>
									
									<th><input type="checkbox" id="selectAll"
										onclick="document.querySelectorAll('input[name=ids]').forEach(c=>c.checked=this.checked)"></th>
									<th>S.No</th>
									<th>Member Id</th>
									<th>Name</th>
									<th>Membership Type</th>
									<th>Joining Date</th>
									<th>Trainer Name</th>
									<th>Edit</th>
								</tr>
							</thead>
							<tbody>
								<%
								while (it.hasNext()) {
									GymBean bean = it.next();
								%>
								<tr class="text-center">
									<td><input type="checkbox"
										class="form-check-input"
										name="ids"
										value="<%=bean.getId()%>"
										onclick="document.getElementById('selectAll').checked =
										document.querySelectorAll('input[name=ids]:checked').length ===
										document.querySelectorAll('input[name=ids]').length"></td>
									<td><%=index++%></td>
									<td><%=bean.getMemberId()%></td>
									<td><%=bean.getName()%></td>
									<td><%=bean.getMembershipType()%></td>
									<td><%=bean.getJoiningDate()%></td>
									<td><%=bean.getTrainerName()%></td>
									<td><a class="btn btn-sm btn-outline-primary"
										href="<%=ORSView.GYM_CTL + "?id=" + bean.getId()%>">
											<i class="fa-solid fa-pen-to-square"></i> Edit
									</a></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>

					<div class="d-flex justify-content-between align-items-center mt-3">
						<input type="submit" name="operation"
							class="btn btn-secondary" <%=pageNo == 1 ? "disabled" : ""%>
							value="<%=BaseCtl.OP_PREVIOUS%>">

						<input type="submit" name="operation" class="btn btn-danger"
							value="<%=BaseCtl.OP_DELETE%>">

						<input type="submit" name="operation"
							class="btn btn-secondary" <%=list.size() < 10 ? "disabled" : ""%>
							value="<%=BaseCtl.OP_NEXT%>">
					</div>

				</div>
			</div>
		</div>
	</form>

	<%@ include file="Footer.jsp"%>
</body>
</html>