<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.controller.BaseCtl"%>
<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.bean.BookBean"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>

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

	HashMap<String, String> map = new HashMap<String, String>();

	map.put("Programming", "Programming");
	map.put("Technology", "Technology");
	map.put("Education", "Education");
	map.put("Science", "Science");
	map.put("Fiction", "Fiction");
	map.put("History", "History");
	map.put("Database", "Database");
	map.put("Business", "Business");
	map.put("Biography", "Biography");
	%>

	<jsp:useBean id="bean" class="in.co.rays.proj4.bean.BookBean"
		scope="request"></jsp:useBean>

	<div
		class="container d-flex justify-content-center align-items-center pt-5"
		style="padding-bottom: 100px !important;">

		<div class="card shadow-sm border-0"
			style="width: 100%; max-width: 700px;">

			<div class="card-header bg-white text-center border-bottom py-4">
				<h2 class="text-primary fw-bold mb-1">
					<i class="fa-solid fa-user-shield"></i>
					<%=bean != null && bean.getId() > 0 ? "Update Book" : "Add Book"%>
				</h2>
				<p class="text-secondary mb-0">Manage Book</p>
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

				<form action="<%=ORSView.BOOK_CTL%>" method="post">

					<input type="hidden" name="id"
						value="<%=DataUtility.getStringData(bean.getId())%>">

					<div class="mb-3">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-user text-primary"></i> Book Name <span
							class="text-danger">*</span>
						</label> <input type="text" name="bookName"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getBookName())%>"
							placeholder="enter book name"> <small class="text-danger">
							<%=ServletUtility.getErrorMessage("bookName", request)%>
						</small>
					</div>

					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Author <span
							class="text-danger">*</span>
						</label> <input type="text" name="author"
							class="form-control form-control-lg"
							value="<%=DataUtility.getStringData(bean.getAuthor())%>"
							placeholder="enter author"> <small class="text-danger">
							<%=ServletUtility.getErrorMessage("author", request)%>
						</small>
					</div>

					<div class="col-md-6 mb-3">
						<label class="form-label fw-bold"> <i
							class="bi bi-gender-ambiguous text-success"></i> Category <span
							class="text-danger">*</span>
						</label>

						<%=HTMLUtility.getList("category", DataUtility.getStringData(bean.getCategory()), map)%>

						<small class="text-danger"> <%=ServletUtility.getErrorMessage("category", request)%>
						</small>
					</div>

					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> Publisher <span
							class="text-danger">*</span>
						</label> <input type="text" name="publisher" class="form-control duration"
							value="<%=DataUtility.getStringData(bean.getPublisher())%>"
							placeholder="enter publisher"> <small class="text-danger">
							<%=ServletUtility.getErrorMessage("publisher", request)%>
						</small>
					</div>

					<div class="mb-4">
						<label class="form-label fw-bold"> <i
							class="fa-solid fa-align-left text-success"></i> IsbnNumber <span
							class="text-danger">*</span>
						</label> <input type="text" name="isbnNumber"
							class="form-control duration"
							value="<%=DataUtility.getStringData(bean.getIsbnNumber())%>"
							placeholder="enter isbnNumber"> <small
							class="text-danger"> <%=ServletUtility.getErrorMessage("isbnNumber", request)%>
						</small>
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