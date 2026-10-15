
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.bean.VotingBean"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Voting List</title>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	rel="stylesheet">
</head>

<body class="bg-light">

	<%@ include file="Header.jsp"%>

	<%
	int pageNo = ServletUtility.getPageNo(request);
	int pageSize = ServletUtility.getPageSize(request);
	int index = ((pageNo - 1) * pageSize) + 1;

	List<VotingBean> list = ServletUtility.getList(request);
	Iterator<VotingBean> it = list.iterator();

	String success = ServletUtility.getSuccessMessage(request);
	String error = ServletUtility.getErrorMessage(request);
	%>

	<form action="<%=ORSView.VOTING_LIST_CTL%>" method="post">

		<div class="container pt-5" style="padding-bottom: 100px;">
			<div class="card shadow-sm border-0">

				<div class="card-header bg-white text-center border-bottom py-4">
					<h2 class="text-primary fw-bold mb-0">
						<i class="fa-solid fa-user-shield"></i> Voting List
					</h2>
				</div>

				<div class="position-relative">
					<div class="position-absolute top-0 end-0 mt-2 me-3">
						<a href="<%=ORSView.VOTING_REPORT_CTL%>"
							class="btn btn-outline-danger btn-sm px-3" target="_blank">PDF</a>

						<a href="<%=ORSView.VOTING_REPORT_CTL%>?type=doc"
							class="btn btn-outline-primary btn-sm px-3">Doc</a>
					</div>
				</div>

				<div class="card-body p-4">

					<%
					if (success != null && !success.isEmpty()) {
					%>
					<div class="alert alert-success text-center py-2">
						<%=success%>
					</div>
					<%
					}
					%>

					<%
					if (error != null && !error.isEmpty()) {
					%>
					<div class="alert alert-danger text-center py-2">
						<%=error%>
					</div>
					<%
					}
					%>

					<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
						type="hidden" name="pageSize" value="<%=pageSize%>">

					<div class="row g-2 mb-4">
						<div class="col-md-4">
							<input type="text" name="voterId" class="form-control"
								placeholder="Search by Voter ID">
						</div>

						<div class="col-md-4">
							<input type="text" name="constituency" class="form-control"
								placeholder="Search by constituency">
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
										onclick="document.querySelectorAll('input[name=ids]').forEach(c => c.checked = this.checked)">
									</th>
									<th>S.No</th>
									<th>Voter ID</th>
									<th>Name</th>
									<th>Age</th>
									<th>Constituency</th>
									<th>Has Voted</th>
									<th>Edit</th>
								</tr>
							</thead>

							<tbody>
								<%
								while (it.hasNext()) {
									VotingBean bean = it.next();
								%>
								<tr class="text-center">

									<td><input type="checkbox" class="form-check-input"
										name="ids" value="<%=bean.getVoterId()%>"></td>

									<td><%=index++%></td>
									<td><%=bean.getVoterId()%></td>
									<td><%=bean.getName()%></td>
									<td><%=bean.getAge()%></td>
									<td><%=bean.getConstituency()%></td>
									<td><%=bean.isHasVoted()%></td>

									<td><a class="btn btn-sm btn-outline-primary"
										href="<%=ORSView.VOTING_CTL%>?voterId=<%=java.net.URLEncoder.encode(bean.getVoterId(), "UTF-8")%>">
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

						<input type="submit" name="operation" class="btn btn-secondary"
							<%=pageNo == 1 ? "disabled" : ""%>
							value="<%=BaseCtl.OP_PREVIOUS%>"> <input type="submit"
							name="operation" class="btn btn-danger"
							value="<%=BaseCtl.OP_DELETE%>"> <input type="submit"
							name="operation" class="btn btn-secondary"
							<%=list.size() < pageSize ? "disabled" : ""%>
							value="<%=BaseCtl.OP_NEXT%>">

					</div>

				</div>
			</div>
		</div>

	</form>

	<script>
document.querySelectorAll('input[name="ids"]').forEach(function (checkbox) {
    checkbox.addEventListener('change', function () {
        const all = document.querySelectorAll('input[name="ids"]');
        const checked = document.querySelectorAll('input[name="ids"]:checked');
        document.getElementById('selectAll').checked =
            all.length > 0 && all.length === checked.length;
    });
});
</script>

	<%@ include file="Footer.jsp"%>

</body>
</html>
