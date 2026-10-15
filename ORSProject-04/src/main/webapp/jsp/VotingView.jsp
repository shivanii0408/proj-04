<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.VotingBean"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">

<title>Online Voting</title>

<!-- Bootstrap CSS/JS already loaded via Header.jsp -->

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	rel="stylesheet">

</head>

<body class="bg-light">

	<%@ include file="Header.jsp"%>

	<%
	String _suc = ServletUtility.getSuccessMessage(request);
	String _err = ServletUtility.getErrorMessage(request);

	/* VotingBean bean = (VotingBean) request.getAttribute("bean"); */

	HashMap<String, String> constituencyMap = new HashMap<String, String>();

	constituencyMap.put("Indore-1", "Indore-1");
	constituencyMap.put("Indore-2", "Indore-2");
	constituencyMap.put("Indore-3", "Indore-3");
	constituencyMap.put("Indore-4", "Indore-4");
	constituencyMap.put("Indore-5", "Indore-5");
	constituencyMap.put("Rau", "Rau");
	constituencyMap.put("Depalpur", "Depalpur");

	HashMap<String, String> hasVotedMap = new HashMap<String, String>();

	hasVotedMap.put("true", "Yes");
	hasVotedMap.put("false", "No");
	%>


	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.VotingBean"
		scope="request">
	</jsp:useBean>


	<div
		class="container d-flex justify-content-center align-items-center pt-5"
		style="padding-bottom: 100px !important;">

		<div class="card shadow-sm border-0"
			style="width: 100%; max-width: 700px;">

			<div class="card-header bg-white text-center border-bottom py-4">

				<h2 class="text-primary fw-bold mb-1">

					<i class="fa-solid fa-user-shield"></i>

					<%=bean != null && bean.getId() > 0 ? "Update Voting" : "Add Voting"%>

				</h2>

				<p class="text-secondary mb-0">Manage Voting</p>

			</div>


			<div class="card-body p-4">

				<%
				if (_suc != null && _suc.length() > 0) {
				%>

				<div class="alert alert-success text-center py-2">
					<%=_suc%>
				</div>

				<%
				}

				if (_err != null && _err.length() > 0) {
				%>

				<div class="alert alert-danger text-center py-2">
					<%=_err%>
				</div>

				<%
				}
				%>


				<form action="<%=ORSView.VOTING_CTL%>" method="post">


					<!-- Hidden ID -->

					<input type="hidden" name="id"
						value="<%=DataUtility.getStringData(bean.getId())%>">


					<!-- Voter Id -->

					<div class="mb-3">

						<label class="form-label fw-bold"> <i
							class="fa-solid fa-user text-primary"></i> Voter Id <span
							class="text-danger">*</span>

						</label> <input type="text" name="voterId"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getVoterId())%>"
							placeholder="enter voter id"> <small class="text-danger">
							<%=ServletUtility.getErrorMessage("voterId", request)%>
						</small>

					</div>


					<!-- Name -->

					<div class="mb-4">

						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Name <span
							class="text-danger">*</span>

						</label> <input type="text" name="name"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getName())%>"
							placeholder="enter name"> <small class="text-danger">
							<%=ServletUtility.getErrorMessage("name", request)%>
						</small>

					</div>


					<!-- Age -->

					<div class="mb-4">

						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Age <span
							class="text-danger">*</span>

						</label> <input type="text" name="age"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getAge())%>"
							placeholder="enter age"> <small class="text-danger">
							<%=ServletUtility.getErrorMessage("age", request)%>
						</small>

					</div>


					<!-- Constituency -->

					<div class="mb-4">

						<label class="form-label fw-bold"> <i
							class="fa-solid fa-building text-primary"></i> Constituency <span
							class="text-danger">*</span>

						</label>

						<%=HTMLUtility.getList("constituency", DataUtility.getStringData(bean.getConstituency()), constituencyMap)%>

						<small class="text-danger"> <%=ServletUtility.getErrorMessage("constituency", request)%>

						</small>

					</div>


					<!-- Has Voted -->

					<div class="mb-4">

						<label class="form-label fw-bold"> <i
							class="fa-solid fa-check-circle text-success"></i> Has Voted <span
							class="text-danger">*</span>

						</label>

						<%=HTMLUtility.getList("hasVoted", DataUtility.getStringData(bean.isHasVoted()), hasVotedMap)%>

						<small class="text-danger"> <%=ServletUtility.getErrorMessage("hasVoted", request)%>

						</small>

					</div>


					<!-- Save / Update -->

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