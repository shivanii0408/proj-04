<%@page import="in.co.rays.proj4.util.DataUtility"%>

<%@page import="in.co.rays.proj4.controller.LoginCtl"%>

<%@page import="in.co.rays.proj4.util.ServletUtility"%>

<%@page import="in.co.rays.proj4.controller.BaseCtl"%>

<%@page import="in.co.rays.proj4.controller.ORSView"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Change Password</title>

<!-- Bootstrap CSS/JS already loaded via Header.jsp, isliye yahan dobara nahi liya -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="bg-light">

    <jsp:useBean id="bean" class="in.co.rays.proj4.bean.UserBean"
        scope="request"></jsp:useBean>

    <%@ include file="Header.jsp"%>

    <%

    String _suc = ServletUtility.getSuccessMessage(request);

    String _err = ServletUtility.getErrorMessage(request);

    %>

    <!-- FIX: extra bottom padding taaki fixed/sticky Footer Save button ko
         overlap na kare -->
    <div class="container pt-5" style="padding-bottom: 100px !important;">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">

                <div class="card shadow-lg border-0">

                    <div class="card-header bg-white text-center py-3">
                        <h3 class="mb-1 text-primary">
                            <i class="bi bi-shield-lock-fill"></i> Change Password
                        </h3>
                        <small class="text-muted">Update your ORS account password</small>
                    </div>

                    <div class="card-body p-4">

                        <!-- SUCCESS MESSAGE -->
                        <%
                        if (_suc != null && _suc.length() > 0) {
                        %>
                        <div class="alert alert-success alert-dismissible fade show"
                            role="alert">
                            <i class="bi bi-check-circle-fill"></i> <%=_suc%>
                            <button type="button" class="btn-close"
                                data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                        <%
                        }
                        %>

                        <!-- ERROR MESSAGE -->
                        <%
                        if (_err != null && _err.length() > 0) {
                        %>
                        <div class="alert alert-danger alert-dismissible fade show"
                            role="alert">
                            <i class="bi bi-exclamation-triangle-fill"></i> <%=_err%>
                            <button type="button" class="btn-close"
                                data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                        <%
                        }
                        %>

                        <form action="<%=ORSView.CHANGE_PASSWORD_CTL%>" method="post">

                            <!-- LOGIN -->
                            <div class="mb-3">
                                <label class="form-label fw-bold"> <i
                                    class="bi bi-person-circle text-primary"></i>
                                    <%=ms.get("login.userid")%> <span class="text-danger">*</span>
                                </label>
                                <input type="text" name="login" class="form-control"
                                    value="<%=DataUtility.getStringData(bean.getLogin())%>"
                                    placeholder="Enter your login">
                                <small class="text-danger"><%=ServletUtility.getErrorMessage("login", request)%></small>
                            </div>

                            <!-- OLD PASSWORD -->
                            <div class="mb-3">
                                <label class="form-label fw-bold"> <i
                                    class="bi bi-lock-fill text-warning"></i> Old Password
                                    <span class="text-danger">*</span>
                                </label>
                                <input type="password" name="oldPassword" class="form-control"
                                    placeholder="Enter your old password">
                                <small class="text-danger"><%=ServletUtility.getErrorMessage("oldPassword", request)%></small>
                            </div>

                            <!-- NEW PASSWORD -->
                            <div class="mb-4">
                                <label class="form-label fw-bold"> <i
                                    class="bi bi-shield-lock-fill text-danger"></i> New
                                    Password <span class="text-danger">*</span>
                                </label>
                                <input type="password" name="newPassword" class="form-control"
                                    placeholder="Enter your new password">
                                <small class="text-danger"><%=ServletUtility.getErrorMessage("newPassword", request)%></small>
                            </div>

                            <!-- SUBMIT BUTTON -->
                            <div class="text-center">
                                <input type="submit" name="operation" class="btn btn-primary px-4"
                                    value="<%=BaseCtl.OP_GO%>">
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